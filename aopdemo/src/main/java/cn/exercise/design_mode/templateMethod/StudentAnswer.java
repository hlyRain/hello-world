package cn.exercise.mode.templateMethod;

/**
 * 模版方法模式，在方法抽象类TestPaper的 quersion1中定义好了工作模版，子类只需实现模版中的可变部分
 * 学生答题调用主类
 */
public class StudentAnswer {


    public static void main(String[] args) {
        TestPaper studentA = new AnswerPaperA();
        studentA.setStudentName();
        studentA.question1();
        studentA.question2();
        studentA.question3();

        TestPaper studentB = new AnswerPaperB();
        studentB.setStudentName();
        studentB.question1();
        studentB.question2();
        studentB.question3();



    }

}
