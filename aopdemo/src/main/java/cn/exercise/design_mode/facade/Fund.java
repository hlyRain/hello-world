package cn.exercise.design_mode.facade;

public class Fund {
    Stock1 gu1;
    Stock2 gu2;
    Stock3 gu3;
    Realty1 rt1;
    NationalDebt1 nd1;

    public Fund() {
        gu1 = new Stock1();
        gu2 = new Stock2();
        gu3 = new Stock3();
        rt1 = new Realty1();
        nd1 = new NationalDebt1();
    }
    public void buyFund(){
        gu1.buy();
        gu2.buy();
        gu3.buy();
        rt1.buy();
        nd1.buy();
    }
    public void sellFund(){
        gu1.sell();
        gu2.sell();
        gu3.sell();
        rt1.sell();
        nd1.sell();
    }
}
