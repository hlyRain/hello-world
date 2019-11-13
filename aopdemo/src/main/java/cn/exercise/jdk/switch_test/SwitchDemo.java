package cn.exercise.jdk.switch_test;

public class SwitchDemo {


    /**
     * JDK1.8之后switch支持String类型
     * @param args
     */
    public static void main(String[] args) {

        String str="A B";

        switch (str){
            case "A":
                System.out.println("This is A!");
                break;
            case "AA":
                System.out.println("This is AA!");
                break;
            case "AAA":
                System.out.println("This is AAA!");
                break;
            case "A B":
                System.out.println("This is A B!");
                break;
        }
    }
}
