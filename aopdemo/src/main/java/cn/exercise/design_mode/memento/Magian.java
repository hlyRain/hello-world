package cn.exercise.design_mode.memento;

/**
 * 游戏角色魔法师
 */
public class Magian {
    private int vit;
    private int atk;
    private int def;

    public Magian() {
    }

    public Magian(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public void getInitState(){
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public void fight(){
        System.out.println("大战boss");
        this.atk = 0;
        this.def = 0;
        this.vit = 0;
    }

    public void stateDisplay(){
        System.out.println("角色当前状态：");
        System.out.println("体力："+this.vit);
        System.out.println("攻击力："+this.atk);
        System.out.println("防御力："+this.def);
        System.out.println();
    }


    /**
     * 保存备忘录
     * @return
     */
    public MagianMemento saveState(){
        return new MagianMemento(vit,atk,def);
    }

    /**
     * 读取备忘录
     * @param memento
     */
    public void reccoveryState(MagianMemento memento){
        this.vit = memento.getVit();
        this.atk = memento.getAtk();
        this.def = memento.getDef();

    }



    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
