package com.hly.util;

import io.swagger.annotations.ApiModelProperty;

/**
 * 返回结果 通用数据模型
 * @param <T>
 * @author linyuhuang
 */
public class ResultVO<T> {


    @ApiModelProperty("状态码 0失败 1成功 ")
    private Integer code;
    @ApiModelProperty("返回信息")
    private String msg;
    @ApiModelProperty("返回数据")
    private T data;


    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     * 请求成功  状态码 1
     *
     * @param msg 返回信息
     * @param <T> 类型
     * @return ResultVO
     */
    /*public static <T> ResultVO getSuccess(String msg) {
        return new ResultVO(1, msg);
    }*/

    /**
     * 请求成功  状态码 1， msg：Success
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultVO getSuccess(T data) {
        return new ResultVO(1, "Success", data);
    }

    /**
     * 请求成功  状态码 1， msg：Success
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultVO getUpdateSuccess() {
        return new ResultVO(1, "Update Success", null);
    }


    /**
     * 请求成功  状态码 1
     *
     * @param msg  返回信息
     * @param data 返回对象
     * @param <T>  类型
     * @return ResultVO
     */
    public static <T> ResultVO getSuccess(String msg, T data) {
        return new ResultVO(1, msg, data);
    }

    /**
     * 请求失败   状态码 0
     *
     * @param <T> 类型
     * @return ResultVO
     */
    public static <T> ResultVO getFailed() {
        return new ResultVO(0, "Failed");
    }

    /**
     * 请求失败   状态码 0
     *
     * @param msg 返回信息
     * @param <T> 类型
     * @return ResultVO
     */
    public static <T> ResultVO getFailed(String msg) {
        return new ResultVO(0, msg);
    }
    /**
     * 请求失败  状态 0
     *
     * @param msg  返回信息
     * @param data 返回数据
     * @param <T>  类型
     * @return ResultVO
     */
    public static <T> ResultVO getFailed(String msg, T data) {
        return new ResultVO(0, msg, data);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
