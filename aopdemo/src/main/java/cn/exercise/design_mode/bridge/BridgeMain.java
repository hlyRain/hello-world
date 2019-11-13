package cn.exercise.design_mode.bridge;

/**
 * 桥接模式
 */
public class BridgeMain {
    public static void main(String[] args) {
        HandsetBrand ab;

        ab = new HandsetBrandM();
        ab.setHandsetSoft(new HandsetGame());
        ab.run();

        ab.setHandsetSoft(new HandsetAddressList());
        ab.run();

        ab = new HandsetBrandN();
        ab.setHandsetSoft(new HandsetGame());
        ab.run();

        ab.setHandsetSoft(new HandsetAddressList());
        ab.run();


    }
}
