package cn.exercise.mode.composite;

/**
 * Company
 */
public abstract class Company {
    protected String name;

    public abstract void add(Company c);
    public abstract  void remove(Company c);
    public abstract void display(int depth);
    public abstract void lineOfDuty();





    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }


}
