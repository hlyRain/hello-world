package cn.exercise.design_mode.command;

/**
 * 烤肉串者
 */
public class Barbecuer {
    private String username;

    public Barbecuer(String username) {
        this.username = username;
    }

    public void bakeMutton()  {
        System.out.println(username+"在烤羊肉串");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void bakeFish()  {
        System.out.println(username+"在烤鱼");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
