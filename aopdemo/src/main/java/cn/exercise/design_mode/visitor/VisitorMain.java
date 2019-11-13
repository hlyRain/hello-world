package cn.exercise.design_mode.visitor;

public class VisitorMain {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.attach(new Man());
        os.attach(new Woman());

        SuccessAction v1 = new SuccessAction();
        os.display(v1);

        FailingAction v2 = new FailingAction();
        os.display(v2);

        AmativenessAction v3 = new AmativenessAction();
        os.display(v3);

        MarriageAction v4  = new MarriageAction();
        os.display(v4);

    }


}
