package cn.exercise.mode.state;

public class AfternoonState extends State {

    @Override
    void writeProgram(Work work) {
        if(work.getHour()<17){
            System.out.println("当前时间："+work.getHour()+"点，下午状态还不错，继续努力。");
        }else{
            work.setCurrent(new EveningState());
            work.writeProgram();
        }
    }
}
