package cn.exercise.mode.adapter;


/**
 * 适配器模式
 */
public class AdapterMain {

    public static void main(String[] args) {
        Player a = new Forwards("Bardier");
        a.attack();

        Player b = new Guards("Mike Greed");
        b.defense();

        /**
         * 调用翻译适配器
         */
        Player ym = new Translator("姚明");
        ym.attack();
        ym.defense();


    }





}
