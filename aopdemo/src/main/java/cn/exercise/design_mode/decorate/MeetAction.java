package cn.exercise.mode.decorate;

/**
 * 装饰者模式主类
 * 约会类，实现穿什么衣服
 */
public class MeetAction {

    public static void main(String[] args) {
        Person person = new Person("黄林玉");

        System.out.println("第一种装扮：");
        Sneakers sneaker1 = new Sneakers();
        BigTrouser bigTrouser1 = new BigTrouser();
        TShirts tShirt1 = new TShirts();

        sneaker1.decorate(person);
        bigTrouser1.decorate(sneaker1);
        tShirt1.decorate(bigTrouser1);
        tShirt1.show();

        System.out.println();

        System.out.println("第二种装扮：");
        LeatherShoes leatherShoes = new LeatherShoes();
        Tie tie = new Tie();
        Suit suit = new Suit();

        leatherShoes.decorate(person);
        tie.decorate(leatherShoes);
        suit.decorate(tie);
        suit.show();


    }
}
