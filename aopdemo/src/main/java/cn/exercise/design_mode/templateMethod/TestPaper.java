package cn.exercise.design_mode.templateMethod;

/**
 * 试卷类
 * 模版方法模式，在父类中定义好算法的骨架，将具体的步骤延迟到子类中实现
 */
public abstract class TestPaper {
    public String username;

    public abstract void setStudentName();


    public void question1(){
        System.out.println("问题1：杨过得到，后来给了郭靖，炼成倚天剑，屠龙刀的玄铁可能是【 】\n " +
                "A. 球磨铸铁 B. 马口铁 C.高速合金钢  D. 碳素纤维");
        System.out.println("答案："+answer1());
    }


    public void question2(){
        System.out.println("问题2：杨过，程英，陆无双铲除了情花，造成【 】\n " +
                "A. 使这种植物不再害人 B. 使一种珍稀物种灭绝 C.破坏了那个生态圈的生态平衡  D. 造成该地区的沙漠化");
        System.out.println("答案："+answer2());

    }
    public void question3(){
        System.out.println("问题3：蓝凤凰导致华山试图、桃谷六仙呕吐不止，如果你是大夫，会给他们开什么药【 】\n " +
                "A.阿司匹林 B. 流黄解毒片 C.氟哌酸  D. 让他们喝大量的生牛奶 E. 以上全不对");
        System.out.println("答案："+answer3());

    }
    protected abstract String answer1();
    protected abstract String answer2();
    protected abstract String answer3();



}
