package cn.exercise.mode.templateMethod;

/**
 * 答题券
 */
public class AnswerPaperA extends TestPaper{

    @Override
    public void setStudentName() {
        super.username = "StudentA";
        System.out.println("学生姓名："+username);

    }

    @Override
    protected String answer1() {
        return "a";
    }

    @Override
    protected String answer2() {
        return "b";
    }

    @Override
    protected String answer3() {
        return "c";
    }
}
