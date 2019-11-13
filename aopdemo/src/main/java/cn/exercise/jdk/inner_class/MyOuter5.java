package cn.exercise.jdk.inner_class;

public class MyOuter5 {
    private int size=5;
    private int id;

    public interface OnClickListener{
        void onClick(int id);
    }

    public void onClick(OnClickListener obj){
        obj.onClick(this.id);
    }

    public Object makeInner(int localvar){
        final int finallocalvar = localvar;
        return new Object(){
            public String toString(){
                return "OuterSize="+size+"\nfinalLocalvar="+finallocalvar;
            }
        };
    }

    public static void main(String args[]){
        Object obj=new MyOuter5().makeInner(67);
        System.out.println(obj.toString());

        MyOuter5 m = new MyOuter5();
        m.onClick(new OnClickListener() {

            @Override
            public void onClick(int id) {
                System.out.println(id);
            }
        });
    }
}
