package com.xiang.core.controller;

import com.xiang.core.dao.MemberRepository;
import com.xiang.core.entity.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import utils.https.ExecuteDTO;
import utils.page.PageQueryParamDTO;
import utils.page.PageResultDTO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 会员控制器
 * <p>
 * <p>
 * Created by xiangjiangcheng on 2018/7/14 11:05.
 */
@Api(description = "会员API")
@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberRepository repository;

    @ApiOperation(value = "获取会员详细信息", notes = "根据url的id来获取会员详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @GetMapping("get/{id}")
    public Member get(@PathVariable String id) {
        return repository.findById(id).get();
    }

    @ApiOperation(value = "创建会员", notes = "根据Member对象创建会员")
    @ApiImplicitParam(name = "entity", value = "用户详细实体member", required = true, dataType = "Member")
    @PostMapping("save")
    public ExecuteDTO save(@RequestBody Member entity) {
        if (entity.date == null) {
            entity.date = new Date();
        }
        repository.save(entity);
        return new ExecuteDTO(true, "保存成功", entity.id);
    }

    @ApiOperation(value = "分页 查询会员", notes = "查询")
    @ApiImplicitParam(name = "params", value = "PageQueryParamDTO", required = true, dataType = "PageQueryParamDTO")
    @PostMapping("loadPage")
    public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params) {

        // 动态查询条件
        Specification<Member> spec = getWhere(params);

        if (params != null) {
            if (params.getPage() == null || params.getSize() == null) {
                params.setPage(1);
                params.setPage(10);
            }
        }
        // PageRequest() 函数 page=0表示第一页 所以这里要减掉1
        Pageable pageable = new PageRequest(params.getPage() - 1, params.getSize());
        Page<Member> pageResult = repository.findAll(spec, pageable);

        // 返回分页数据
        return new PageResultDTO(pageResult.getTotalElements(), pageResult.getContent());
    }

    @ApiOperation(value = "删除会员", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "会员ID", required = true, dataType = "String", paramType = "path")
    @DeleteMapping("/{id}")
    public ExecuteDTO remove(@PathVariable String id) {
        repository.deleteById(id);
        return new ExecuteDTO(true, "删除成功", id);
    }

    /**
     * 条件查询时动态组装条件
     */
    private Specification<Member> getWhere(PageQueryParamDTO params) {
        return (Specification<Member>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            String name = params.getName();
            //名字
            if (StringUtils.isNotEmpty(name)) {
                predicates.add(cb.equal(root.get("name"), name));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
    }

}
