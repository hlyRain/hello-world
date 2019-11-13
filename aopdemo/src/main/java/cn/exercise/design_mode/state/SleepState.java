package cn.exercise.mode.state;

public class SleepState extends State {

    @Override
    void writeProgram(Work work) {
        System.out.println("当前时间："+work.getHour()+"点，不行了，睡觉。");
    }
}
