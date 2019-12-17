package cn.exercise.chat_house_v2;

import java.util.ArrayList;
import java.util.List;

public class ChatTools {
    private static List<ServerThread> stList = new ArrayList<>();

    public ChatTools() {

    }

    public static void addClient(ServerThread ct){
       castMsg(ct.getOwerUser(),"我上线了，目前在线人数"+stList.size()+1);
        stList.add(ct);
    }

    public static void castMsg(UserInfo sender, String msg) {
        msg = sender.getName()+"说："+msg;
        for (int i=0;i<stList.size();i++){
            ServerThread st = stList.get(i);
            st.sendMsg2Me(msg);
        }
    }

    public static void removeClient(UserInfo user) {
        stList.remove(user);
    }
}
