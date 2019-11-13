package cn.exercise.mode.iterator;

/**
 * 迭代器模式，此模式构造一个类似于Java中的Iterator的迭代器，
 * 然后构造一个类似于Java中List的数组，遍历数组中的内容
 */
public class IteratorMain {

    public static void main(String[] args) {
        Aggregate list = new ConcreteAggregate();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhangliu");
        list.add("zhouqi");
        list.add("wangba1");

        for(Iterator it = list.iterator();it.hasNext();)   {
            System.out.println(it.next());
        }
        System.out.println();
        Iterator iterator = list.iterator();
        while(iterator.hasNext())   {
            System.out.println(iterator.next());
        }
    }
}
