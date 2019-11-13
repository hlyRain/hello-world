package cn.exercise.mode.state;

public class ForenoonState extends State {

    @Override
    void writeProgram(Work work) {
        if(work.getHour()<12){
            System.out.println("当前时间："+work.getHour()+"点，上午工作，精神百倍");
        }else {
            /**
             * 大于12点时，将current 状态置为中午状态，
             */
            work.setCurrent(new NoonState());
            //执行中午工作内容
            work.writeProgram();
        }
    }
}
