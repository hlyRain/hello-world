package cn.exercise.chat_house_v2;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 多人在线聊天简易版
 * 预先在内存中存入10个用户，分别是user0/pwd0,..,user9/pwd9
 * 使用telnet命令即可实现聊天功能
 * 1. 命令行  telnet localhost 9090
 * 2. 提示输入用户名密码：user0/pwd0
 * 3. 进入聊天室，开始聊天
 * 4. 输入bye退出聊天室
 */
public class ChatServer {

    public static void main(String[] args) {
        ChatServer cs = new ChatServer();
        cs.setUpServer(9090);
    }

    public void setUpServer(int port) {

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("服务器创建成功！"+port);
            while(true) {
                Socket client = server.accept();
                System.out.println("进入了一个客户端连接: "+client.getRemoteSocketAddress().toString());
                ServerThread ct = new ServerThread(client);
                ct.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
