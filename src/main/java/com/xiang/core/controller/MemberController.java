package com.xiang.core.controller;

import com.xiang.core.dao.MemberRepository;
import com.xiang.core.entity.Member;
import com.xiang.core.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import utils.https.ExecuteDTO;
import utils.page.PageQueryParamDTO;
import utils.page.PageResultDTO;

import java.util.Date;
import java.util.List;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 会员控制器
 *
 * <p>
 * Created by xiangjiangcheng on 2018/7/14 11:05.
 */
@Api(description = "会员API")
@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberRepository repository;

    @ApiOperation(value="获取会员详细信息", notes="根据url的id来获取会员详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @GetMapping("get/{id}")
    public Member get(@PathVariable String id) {
        return repository.findById(id).get();
    }

    @ApiOperation(value="创建会员", notes="根据Member对象创建会员")
    @ApiImplicitParam(name = "entity", value = "用户详细实体member", required = true, dataType = "Member")
    @PostMapping("save")
    public ExecuteDTO save(@RequestBody Member entity) {
        if (entity.date == null) {
            entity.date = new Date();
        }
        repository.save(entity);
        return new ExecuteDTO(true, "保存成功", entity.id);
    }

    @ApiOperation(value="分页 查询会员", notes="查询")
    @ApiImplicitParam(name = "params", value = "PageQueryParamDTO", required = true, dataType = "PageQueryParamDTO")
    @PostMapping("loadPage")
    public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params) {

        // 动态查询条件
        Specification<Member> spec = (root, query, cb) -> {
            if (params.getQuery() != null) {
                // 筛选 会员姓名
                query.where(cb.equal(root.get("name"), params.getQuery().toString()));
            }

            return null;
        };
        Pageable pageable = new PageRequest(params.getPage() - 1, params.getSize());
        Page<Member> pageResult = repository.findAll(spec, pageable);

        // 返回分页数据
        return new PageResultDTO(pageResult.getTotalElements(), pageResult.getContent());
    }

    @ApiOperation(value="删除会员", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "会员ID", required = true, dataType = "String", paramType = "path")
    @DeleteMapping("/{id}")
    public ExecuteDTO remove(@PathVariable String id) {
        repository.deleteById(id);
        return new ExecuteDTO(true, "删除成功", id);
    }

}
