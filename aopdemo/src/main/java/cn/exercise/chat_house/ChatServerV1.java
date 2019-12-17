package cn.exercise.chat_house;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个聊天室的简易程序
 * 聊天室服务端
 */
public class ChatServerV1 {


    /**
     * 将客户端读取的数据输出在console上面(服务端输出字符的ascii码)
     * 服务器端是一个字节一个字节的读数据，读到换行关闭客户端
     * @param port
     */
    public void setUpServer(int port){
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("服务器创建成功！");
            while(true) {
                Socket client = server.accept();
                OutputStream out = client.getOutputStream();
                InputStream ins = client.getInputStream();
                String s = "你好！这里是JavaKe\r\n";
                byte[] data = s.getBytes();
                out.write(data);
                out.flush();
                int in = ins.read();
                while (in!=13){
                    in = ins.read();
                    System.out.println("读到的一个是："+in);
                }
                System.out.println("客户端按了回车键，退出："+in);
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 实现客户端向服务端多次发送任何数据，服务端打印出该数据
     * 服务器一次读取一行，读到bye 关闭客户端
     * @param port
     */
    public void setUpServer2 (int port){
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("服务器创建成功！\r\n");
            while(true) {
                Socket client = server.accept();
                System.out.println("Incoming client: "+client.getRemoteSocketAddress());
                processChat(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void processChat(Socket client) throws Exception{
        OutputStream out= client.getOutputStream();
        InputStream ins = client.getInputStream();
        String s = "你好，欢迎来到服务器！";
        byte[] data = s.getBytes();
        out.write(data);
        out.flush();
        String inputS = readString(ins);
        while (!inputS.equals("bye")){
            System.out.println("客户端说："+inputS);
            s = "服务器收到："+inputS+"\r\n";
            data = s.getBytes();
            out.write(data);
            out.flush();
            inputS = readString(ins);   //读取客户端下一次输入
        }
        s = "你好，欢迎再来！\r\n";
        data = s.getBytes();
        out.write(data);
        out.flush();
        client.close();
    }

    private String readString(InputStream ins) throws IOException {
        StringBuffer str = new StringBuffer();
        char c = 0;
        while (c!=13){    //回车键作为字符的结束
            int i = ins.read();
            c = (char) i;
            str.append(c);
        }
        String inputS = str.toString().trim();
        return inputS;
    }

    public static void main(String[] args) {
        ChatServerV1 cs = new ChatServerV1();
        cs.setUpServer(9090);
    }
}
