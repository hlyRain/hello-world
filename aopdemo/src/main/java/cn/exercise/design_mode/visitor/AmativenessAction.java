package cn.exercise.design_mode.visitor;

public class AmativenessAction extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println(man.getClass().getName()+"恋爱时，凡事不懂也要装懂。");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println(woman.getClass().getName()+"恋爱时，遇事懂也要装作不懂。");
    }
}
