package cn.exercise.design_mode.templateMethod;

/**
 * 答题券
 */
public class AnswerPaperB extends TestPaper{

    @Override
    public void setStudentName() {
        super.username = "StudentB";
        System.out.println("学生姓名："+username);
    }
    @Override
    protected String answer1() {
        return "D";
    }

    @Override
    protected String answer2() {
        return "C";
    }

    @Override
    protected String answer3() {
        return "A";
    }
}
