package cn.exercise.jdk.inner_class;


/*匿名内部类：定义类的最终目的是创建一个类的实例，但是如果某个类的实例只是用一次，则可以将类的定义与类的创建，放到与一起完成，或者说在定义类的同时就创建一个类
  以这种方法定义的没有名字的类成为匿名内部类。
   声明和构造匿名内部类的一般格式如下：
   new ClassOrInterfaceName(){
    类体 }
   1.匿名内部类可以继承一个类或实现一个接口，这里的ClassOrInterfaceName是匿名内部类所继承的类名或实现的接口名。但匿名内部类不能同时实现一个接口和继承一个类，<br>也不能实现多个接口。如果实现了一个接口，该类是Object类的直接子类，匿名类继承一个类或实现一个接口，不需要extends和implements关键字。

   2.由于匿名内部类没有名称，所以类体中不能定义构造方法，由于不知道类名也不能使用关键字来创建该类的实例。实际上匿名内部类的定义、构造、和第一次使用都发生在同样一个地方。<br>此外，上式是一个表达式，返回的是一个对象的引用，所以可以直接使用或将其复制给一个对象变量。例：

   TypeName obj=new Name（）{
   此处为类体
      }
  同样，也可以将构造的对象作为调用的参数。例：

   someMethod(new Name(){
   此处为类体  });
*/
public class MyOuter4 {
    private int size=5;

    public Object makeInner(int localvar){
        final int finallocalvar = localvar;
        return new Object(){
            public String toString(){
                return "OuterSize="+size+"\nfinalLocalvar="+finallocalvar;
            }
        };
    }

    public static void main(String args[]){
        Object obj=new MyOuter4().makeInner(67);
        System.out.println(obj.toString());
    }
}