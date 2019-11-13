package cn.exercise.jdk.annotation;

import java.lang.annotation.*;

/**
 * Description:
 * Created by gaowei on 2018/1/3.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqMapping {

    ReqMethod [] method() default {};

    String[] val() default "";
}