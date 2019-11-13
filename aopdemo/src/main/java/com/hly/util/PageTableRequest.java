package com.hly.util;


import java.io.Serializable;
import java.util.Map;

/**
 * 分页查询参数 通用标准
 * @author linyuhuang
 */
public class PageTableRequest  implements Serializable {


    private static final long serialVersionUID = -7439433919510536066L;
    private Integer offset;
    private Integer limit;
    private Map<String, Object> params;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
