package cn.exercise.mode.visitor;

public class MarriageAction extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println(man.getClass().getName()+"结婚时，感慨道：恋爱游戏终结，有妻徒刑遥遥无期。");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println(woman.getClass().getName()+"结婚时，欣慰曰：爱情长跑路慢慢，婚姻保险保平安。");
    }
}
