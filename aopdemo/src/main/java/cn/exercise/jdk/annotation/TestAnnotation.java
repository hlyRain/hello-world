package cn.exercise.jdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



/**
 * Java以反射的形势读取注解中内容
 */
public class TestAnnotation {

    public static void main(String[] args) {
        Class<User> clazz = User.class;

        //获得clazz（User）里面所有方法信息
        Method[] methods = clazz.getDeclaredMethods();

        //获得clazz（User）里面所有属性信息
        Field[] declaredFields = clazz.getDeclaredFields();


        System.out.println("methods注解个数："+methods.length);
        System.out.println("declaredFields注解个数："+declaredFields.length);

        //遍历循环所有方法信息
        for (Method method : methods) {
            //判断method是否含有指定元素的注解
            if (method.isAnnotationPresent(ReqMapping.class)) {
                //返回当前方法上的注解对象
                ReqMapping reqMapping = method.getAnnotation(ReqMapping.class);
                //获得注解的值
                System.out.print("\n方法注解值：");
                ReqMethod[] m1s = reqMapping.method();
                for(ReqMethod rm:m1s) {
                    System.out.print( rm.toString()+" ");
                }

                //如果一个注解有多个值，通过遍历取出（特别注意：reqMapping.val()，这个val()是你定义注解的成员）
                String[] values = reqMapping.val();
                for (String value : values) {
                    System.out.print(value+" ");
                }
            }
        }

        //获得类里面所有方法的注解信息
        for (Field declaredField : declaredFields) {
            if(declaredField.isAnnotationPresent(ReqValue.class)){
                ReqValue reqValue = declaredField.getAnnotation(ReqValue.class);
                System.out.println("\n属性注解值："+reqValue.value1());
                System.out.println("属性注解值："+reqValue.value2());
            }
        }

        //获得类上的所有注解
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println("类注解值:"+ declaredAnnotation);

        }
        if(clazz.isAnnotationPresent(ReqMapping.class)){
            ReqMapping reqmap = clazz.getDeclaredAnnotation(ReqMapping.class);
            ReqMethod[] s = reqmap.method();
            String[] t = reqmap.val();
            System.out.println(s[0]+" "+s[1]);
            System.out.println(t[0]);
        }

    }
}