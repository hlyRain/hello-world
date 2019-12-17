package cn.exercise.jdk.switch_test;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ByteDemo {

    public static void main(String[] args) {
        /*String str = "Hello";
        try {
            byte[] bytes = str.getBytes("ISO-8859-1");
            System.out.println(bytes.toString());
            for(byte b : bytes){
                System.out.println(b);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

        int a = 10;
        int b = 30;
        //for循环中的a，b值一直没有变，因为基础数据类型值是存在栈中，引用类型的引用存放在栈中，而引用类型指向的对象存放在堆中
        for(int i=0;i<4;i++){
            String  str = calculateMap(a,b);
            System.out.println(str);
        }

        //a,b的值在变动，，但代码太长
        int a1 = 10;
        int b1 = 30;
        a1=b1;
        b1=a1+b1;
        System.out.println("a1:"+a1+" b1:"+b1);
        a1=b1;
        b1=a1+b1;
        System.out.println("a1:"+a1+" b1:"+b1);
        a1=b1;
        b1=a1+b1;
        System.out.println("a1:"+a1+" b1:"+b1);
        a1=b1;
        b1=a1+b1;
        System.out.println("a1:"+a1+" b1:"+b1);


        //a，b值没有变，但map中的值（存放在JVM的堆中）一直在变动
        int a2 = 10;
        int b2 = 30;
        Map<String,Integer> map = new HashMap<>();
        map.put("a",a2);
        map.put("b",b2);


        for(int i=0;i<4;i++){
            String str = calculateMap(map);
            System.out.println(str);
        }

    }

    private static String calculateMap(Map<String,Integer> map) {
        int a = map.get("a");
        int b = map.get("b");

        map.put("a",b);
        map.put("b",a+b);
        return "a:"+a+" b:"+b;
    }

    public static String calculateMap(int a, int b){
        a=b;
        b=a+b;
        return "a:"+a+" b:"+b;
        
        
    }
    
    public void testClassLoader(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("");
        URL url2 = ClassLoader.getSystemResource("");
    }

}
