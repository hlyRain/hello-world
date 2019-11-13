package cn.exercise.lambda;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class LambdaDemo {


    public static void main(String[] args) {

        Function<String, String> function1 = string -> {
            System.out.println("function1 输出了：" + string);
            return string;
        };

        Function<String, String> function2 = string -> {
            System.out.println("function2 输出了：" + string);
            return string;
        };
        System.out.println("andThen 执行顺序：");
        function1.andThen(function2).apply("Hello world2!");

        System.out.println("\ncompose 执行顺序：");
        function2.compose(function1).apply("Hello world1!");


        /**
         * 排序例子：
         */
        LambdaDemo.testSort();


        LambdaDemo.testFuction();

        /**
         * demo1:线程例子
         */
        LambdaDemo.testThread();

    }

    private static void guava() {
        List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);
        nums.stream().filter(num -> num != null).count();
    }


    private static void testSort() {
        System.out.println("start sort string:");
        List<String> list = Arrays.asList(new String[]{"zhangsan", "lisi", "wangwu", "zhao", "qian"});
        Collections.sort(list, (str1, str2) -> str1.compareTo(str2));
        list.forEach(param -> System.out.print(param + " "));
        System.out.println();

    }


    private static void testThread() {

        System.out.println("start thread demo:");
        Thread thread = new Thread(() -> {
            System.out.println("Hello,Lambda Thread");
            System.out.println();
        });
        thread.start();

    }


    /**
     * Function  输入参数为类型T， 输出为类型R， 记作 T -> R
     * Consumer  输入参数为类型T， 输出为void， 记作 T -> void
     * Supplier  没有输入参数， 输出为类型T， 记作 void -> T
     * Predicate 输入参数为类型T， 输出为类型boolean， 记作 T -> boolean
     */
    private static void testFuction() {
        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
                collect(() -> new ArrayList<Integer>(),
                        (list, item) -> list.add(item),
                        (list1, list2) -> list1.addAll(list2));
        numsWithoutNull.forEach((x) -> System.out.print(x + " "));
        System.out.println();

    }


}
