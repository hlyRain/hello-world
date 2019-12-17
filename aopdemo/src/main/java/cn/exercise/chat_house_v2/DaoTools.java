package cn.exercise.chat_house_v2;

import java.util.HashMap;
import java.util.Map;

public class DaoTools {

    /**
     * 内存用户信息数据库
     */
    private static Map<String,UserInfo> userDB = new HashMap<>();

    /**
     * 静态快，程序启动时，自动在内存中生成10条用户数据
     */
    static {
        for(int i = 0;i<10;i++){
            UserInfo user = new UserInfo();
            user.setName("user"+i);
            user.setPwd("pwd"+i);
            userDB.put(user.getName(),user);
        }
    }

    /**
     * 查看这个 用户是否可以登录
     * @return
     */
    public static boolean checkLogin(UserInfo user){
        if(userDB.containsKey(user.getName())){
            return true;
        }
        System.out.println("认证失败！"+user.getName());
        return false;
    }
}
