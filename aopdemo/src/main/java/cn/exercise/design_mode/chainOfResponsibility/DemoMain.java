package cn.exercise.mode.chainOfResponsibility;


/**
 * 责任链模式
 */
public class DemoMain {

    public static void main(String[] args) {
        CommonManager jingli = new CommonManager("胡叶秋");
        Majordomo zongjian = new Majordomo("徐晓平");
        GeneralManager zongjingli = new GeneralManager("丁汉");
        jingli.setSuperior(zongjian);
        zongjian.setSuperior(zongjingli);

        Request request1 = new Request("请假","小菜请假",1);
        jingli.requestApplication(request1);

        Request request2 = new Request("请假","小菜请假",2);
        jingli.requestApplication(request2);

        Request request3 = new Request("请假","小菜请假",4);
        jingli.requestApplication(request3);

        Request request4 = new Request("请假","小菜请假",6);
        jingli.requestApplication(request4);

        Request request5 = new Request("加薪","小菜请求加薪",500);
        jingli.requestApplication(request5);

        Request request6 = new Request("加薪","小菜请求加薪",1000);
        jingli.requestApplication(request6);

        Request request7 = new Request("加薪","小菜请求加薪",2000);
        jingli.requestApplication(request7);

    }





}
