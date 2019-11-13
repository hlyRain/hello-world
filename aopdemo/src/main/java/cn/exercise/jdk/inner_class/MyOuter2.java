package cn.exercise.jdk.inner_class;

/**
 * 静态内部类：与类的其他成员相似，可以用static修饰内部类，
 * 这样的类称为静态内部类。静态内部类与静态内部方法相似，
 * 只能访问外部类的static成员，
 * 不能直接访问外部类的实例变量，与实例方法，只有通过对象引用才能访问。
 */
public class MyOuter2 {

    public static int x=100;
    public int amount = 200;

    public static class Myinner{
        private String y="Hello!";
        /**
         * 由于static内部类不具有任何对外部类实例的引用，
         * 因此static内部类中不能使用this关键字来访问外部类中的实例成员，
         * 但是可以访问外部类中的static成员。这与一般类的static方法相通
         */
        public void innerMethod(){
            System.out.println("x="+x);
            System.out.println("y="+y);
            //不能访问外部类中的非静态方法和变量
            //System.out.println("amount="+amount);
            subMethod();
            //addMethod();
            MyOuter2.callMutipleMethod(new MultipleHandle(){

                @Override
                public void multipleMethod() {
                    System.out.println("5*5=25");
                }
            });

        }
    }

    public static void main(String[] args){
        Myinner si = new Myinner();
        si.innerMethod();
    }

    /**
     * 普通方法
     */
    public void addMethod(){
        System.out.println("1+1=2");
    }

    /**
     * 静态方法
     */
    public static void subMethod(){
        System.out.println("10-5=5");
    }


    /**
     * 静态方法
     */
    public static void callMutipleMethod(MultipleHandle handle){
        handle.multipleMethod();
    }


    /**
     * 内部接口型，内部接口默认是static静态的，不管有没有申明
     */
    public interface MultipleHandle{
        void multipleMethod();
    }
}