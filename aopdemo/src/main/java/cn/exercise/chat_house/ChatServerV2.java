package cn.exercise.chat_house;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 采用线程来改进该聊天室
 */
public class ChatServerV2 extends Thread {
    private Socket client;
    private OutputStream out;

    public ChatServerV2(Socket client) {
        this.client = client;
    }


    public static void main(String[] args) {
        Socket client = new Socket();
        ChatServerV2 cs = new ChatServerV2(client);
        cs.setUpServer(9090);
    }


    public void setUpServer (int port){
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("服务器创建成功！\r\n");
            while(true) {
                Socket client = server.accept();
                System.out.println("Incoming client: "+client.getRemoteSocketAddress());
                ChatServerV2 thread = new ChatServerV2(client);
                thread.start();
                System.out.println("已经启动了一个现成去处理这个连接对象了");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        processChat(this.client);
    }

    private void processChat(Socket client) {
        try {
            out = client.getOutputStream();
            InputStream ins = client.getInputStream();
            String s = "你好，欢迎来到服务器！";
            sendMsg2Me(s);
            String inputS = readString(ins);
            while (!inputS.equals("bye")){
                System.out.println("客户端说："+inputS);
                s = "服务器收到："+inputS+"\r\n";
                sendMsg2Me(s);
                inputS = readString(ins);   //读取客户端下一次输入
            }
            s = "你好，欢迎再来！\r\n";
            sendMsg2Me(s);
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

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


    /**
     * 提取发送消息方法
     * @param s
     * @throws IOException
     */
    private void sendMsg2Me(String s) throws IOException {
        byte[] data = s.getBytes();
        out.write(data);
        out.flush();
    }
}
