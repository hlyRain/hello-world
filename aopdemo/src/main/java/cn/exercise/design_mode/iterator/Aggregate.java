package cn.exercise.mode.iterator;

public interface Aggregate {
    public void add(Object obj);

    public Object get(int index);

    public Iterator iterator();

    public int getSize();
}
