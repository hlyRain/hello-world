package cn.exercise.mode.state;

public class RestState extends State {

    @Override
    void writeProgram(Work work) {
        System.out.println("当前时间："+work.getHour()+"点,下班回家了");
    }
}
