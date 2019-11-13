package cn.exercise.design_mode.memento;

/**
 * 备忘录模式
 */
public class MementoMain {

    public static void main(String[] args) {

        /**
         * 大战boss前
         */
        Magian liuqian = new Magian();
        liuqian.getInitState();
        liuqian.stateDisplay();

        /**
         * 保存进度
         */
        MagicCaretaker caretaker = new MagicCaretaker();
        caretaker.setMemento(liuqian.saveState());

        /**
         * 大战boss，损耗严重
         */
        liuqian.fight();
        liuqian.stateDisplay();

        liuqian.reccoveryState(caretaker.getMemento());
        liuqian.stateDisplay();



    }

}
