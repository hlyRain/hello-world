package cn.exercise.jdk.annotation;

@ReqMapping(method = {ReqMethod.POST,ReqMethod.GET},val = "类")
public class User  {

    @ReqValue(value1 = "张三")
    private String userName;

    @ReqValue(value2 = "密码")
    private String pswd;


    @ReqMapping(method = ReqMethod.GET)
    public void get(){

    }

    @ReqMapping(method = ReqMethod.POST)
    public void post(){

    }

    @ReqMapping(val={"a","b"})
    public void other(){

    }

}