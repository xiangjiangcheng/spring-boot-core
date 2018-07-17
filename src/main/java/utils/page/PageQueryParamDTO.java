package utils.page;

import io.swagger.models.auth.In;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 分页查询参数DTO
 *
 * <p>
 * Created by xiangjiangcheng on 2018/7/14 11:39.
 */
public class PageQueryParamDTO {
    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer size;

    /**
     * 查询条件
     */
    private Object query;

    private String name;

    public PageQueryParamDTO() {
    }

    public PageQueryParamDTO(Integer page, Integer size, Object query) {
        this.page = page;
        this.size = size;
        this.query = query;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }
}
