package cn.exercise.design_mode.iterator;


public class ConcreteIterator implements Iterator {

    private Aggregate list = null;
    private int index;


    public ConcreteIterator(Aggregate list) {
        super();
        this.list = list;
    }

    public ConcreteIterator() {
    }

    @Override
    public boolean hasNext() {
        if (index >= list.getSize()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object obj = null;
        if(index<=list.getSize()) {
            obj = list.get(index);
            index++;
        }
        return obj;

    }
}
