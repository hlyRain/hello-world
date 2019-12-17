package cn.exercise.chat_house_v2;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{

    private Socket client;
    private OutputStream ous;
    private UserInfo user;

    public ServerThread(Socket client) {
        this.client = client;
    }
    public UserInfo getOwerUser(){
        return this.user;
    }

    @Override
    public void run(){
        processSocket();
    }

    private void processSocket() {
        try {
            InputStream ins = client.getInputStream();
            ous = client.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            sendMsg2Me("欢迎来到聊天室，请输入您的用户名：");
            String userName = reader.readLine();
            sendMsg2Me("欢迎来到聊天室，请输入您的密码：");
            String pwd = reader.readLine();
            user = new UserInfo();
            user.setName(userName);
            user.setPwd(pwd);
            if(!DaoTools.checkLogin(user)){
               this.closeMe();
               return;
            }
            ChatTools.addClient(this);
            String input = reader.readLine();
            while (!"bye".equals(input)){
                System.out.println("服务器收到信息："+input);
                ChatTools.castMsg(this.user, input);
                input = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ChatTools.castMsg(this.user,"我下线了，再见！");
        this.closeMe();
        ChatTools.removeClient(this.user);
    }

    private void closeMe() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 提取发送消息方法
     * @param msg
     * @throws IOException
     */
    public void sendMsg2Me(String msg)  {
        try {
            msg+="\r\n";
            ous.write(msg.getBytes());
            ous.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
