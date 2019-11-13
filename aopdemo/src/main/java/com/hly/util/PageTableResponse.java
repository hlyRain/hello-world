package com.hly.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据返回 通用模型 由于使用PageInfo封装返回list,使用ResultVO封装PageInfo，该类不再使用
 * @author linyuhuang
 */
@Deprecated
public class PageTableResponse implements Serializable {

    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<?> data;

    public PageTableResponse(Integer recordsTotal, Integer recordsFiltered, List<?> data) {
        super();
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

}
