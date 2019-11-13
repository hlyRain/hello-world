package cn.exercise.design_mode.observer1;


public class BossNotifier extends Notifier {



    public BossNotifier() {

    }

    @Override
    public void addListener(Object object, String methodName, Object... args) {
        eventList.add(new Event(object,methodName,args));
    }

    @Override
    public void notifyX() {
        for(Event e : eventList){
            try {
                e.invoke();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
