package cn.exercise.mode.flyweight;

import java.util.Hashtable;

/**
 * 网站工厂类
 */
public class WebsiteFactory {

    private Hashtable flyweights = new Hashtable();

    /**
     * 根据key获取网站分类信息
     * @param key
     * @return
     */
    public Website getWebSiteCategory(String key){
        if(!flyweights.containsKey(key)){
            flyweights.put(key,new ConcreteWebsite(key));
        }
        return (Website)flyweights.get(key);
    }

    /**
     * 获得网站分类总数
     * @return
     */
    public int getWebSiteCount(){
        return flyweights.size();
    }

}
