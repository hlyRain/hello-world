package cn.exercise.jdk;

import java.net.URL;

public class TestUrl {

    public static void main(String[] args) {
        TestUrl tu = new TestUrl();

        tu.callUrl1();

    }

    private void callUrl1() {

        ClassLoader loader = (TestUrl.class).getClassLoader();
        String s = "generator/mybatis-generator.xml";
        URL url =null;
        if(loader!=null){
            url = loader.getResource(s);
            System.out.println("111111:"+url.getPath());
        }
        if(url ==null){
            url = ClassLoader.getSystemResource(s);
            System.out.println("222222:"+url.getPath());
        }

    }


}
