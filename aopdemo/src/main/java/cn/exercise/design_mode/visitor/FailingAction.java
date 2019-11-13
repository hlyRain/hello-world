package cn.exercise.design_mode.visitor;

public class FailingAction extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println(man.getClass().getName()+"失败时，闷头喝酒，谁也不用劝。");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println(woman.getClass().getName()+"失败时，眼泪汪汪，谁也劝不了。");
    }
}
