package cn.exercise.mode.memento;


/**
 * 角色状态管理者
 */
public class MagicCaretaker {
    private MagianMemento memento;

    public MagianMemento getMemento() {
        return memento;
    }

    public void setMemento(MagianMemento memento) {
        this.memento = memento;
    }
}
