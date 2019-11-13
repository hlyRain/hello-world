package cn.exercise.design_mode.chainOfResponsibility;

/**
 * 请求类
 */
public class Request {

    //请求类型
    private String requestType;
    //请求内容
    private String requestContent;
    //请求数量
    private int number;

    public Request() {
    }

    public Request(String requestType, String requestContent, int number) {
        this.requestType = requestType;
        this.requestContent = requestContent;
        this.number = number;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
