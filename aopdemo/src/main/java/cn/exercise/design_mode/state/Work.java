package cn.exercise.mode.state;


public class Work {

    private int hour;
    private boolean workFinish;
    private State current;

    /**
     * 初始状态为上午
     */
    public Work() {
        current = new ForenoonState();
    }

    /**
     * 执行current中内容，初始为ForenoonState, >12点为NoonState
     */
    public void writeProgram(){
        current.writeProgram(this);
    }


    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public boolean isWorkFinish() {
        return workFinish;
    }

    public void setWorkFinish(boolean workFinish) {
        this.workFinish = workFinish;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;

    }
}
