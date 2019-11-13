package cn.exercise.mode.state;

public class EveningState extends State {

    @Override
    void writeProgram(Work work) {
        if(work.isWorkFinish()){
            work.setCurrent(new RestState());
            work.writeProgram();
        }else {
            if(work.getHour()<21){
                System.out.println("当前时间："+work.getHour()+"点，加班哦，疲惫至极");
            }else{
                work.setCurrent(new SleepState());
                work.writeProgram();
            }
        }

    }
}
