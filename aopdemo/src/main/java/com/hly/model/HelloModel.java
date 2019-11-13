package com.hly.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author linyuhuang
 */
@ApiModel("hello实体")
public class HelloModel {

    @ApiModelProperty("hello id")
    private long id;

    @ApiModelProperty("hello title")
    private String title;

    @ApiModelProperty("hello text")
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
