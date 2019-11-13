package cn.exercise.design_mode.flyweight;


/**
 * 享元模式
 */
public class DemoMain {

    public static void main(String[] args) {
        WebsiteFactory f = new WebsiteFactory();

        Website fx = f.getWebSiteCategory("ProductShow");
        fx.use(new User("小菜"));
        Website fy = f.getWebSiteCategory("ProductShow");
        fy.use(new User("大鸟"));
        Website fz = f.getWebSiteCategory("ProductShow");
        fz.use(new User("欢欢"));

        Website fl = f.getWebSiteCategory("博客");
        fl.use(new User("韩鹏"));
        Website fm = f.getWebSiteCategory("博客");
        fm.use(new User("陈建"));
        Website fn = f.getWebSiteCategory("博客");
        fn.use(new User("张曼"));

        System.out.println("得到网站分类总数为："+f.getWebSiteCount());

    }


}
