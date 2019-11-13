package cn.exercise.jdk.inner_class;


/**
 * MyOuter  常规内部类
 * MyOuter2  静态内部类
 * MyOuter3  局部内部类
 * MyOuter4  匿名内部类
 * MyOuter5  内部接口
 *
 *
 *
 * 常规内部类：常规内部类没有用static修饰且定义在在外部类类体中。
 * 1.常规内部类中的方法可以直接使用外部类的实例变量和实例方法。
 * 2.在常规内部类中可以直接用内部类创建对象
 */
public class MyOuter {
    private int x = 100;

    class MyInner{
        private String y="Hello!";
        public void innerMethod(){
            System.out.println("内部类中 String ="+y);
            System.out.println("外部类中的x ="+x);
            outerMethod();
            System.out.println("x is "+MyOuter.this.x);
        }
    }

    public void outerMethod(){
        x++;
    }

    public void makeInner(){
        //在外部类方法中创建内部类实例
        MyInner in = new MyInner();
    }

    public static void main(String[] args){
        MyOuter mo = new MyOuter();
        //使用外部类构造方法创建 mo 常规内部类需要通过外部类实例来new
        MyInner inner = mo.new MyInner();
        inner.innerMethod();
    }
}