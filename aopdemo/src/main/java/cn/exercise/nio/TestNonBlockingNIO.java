package cn.exercise.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;


/**
 * 一、使用NIO完成网络通讯的三个核心
 *  1. 通道（Channel）：负责连接
 *    java.nio.channels.Channel接口
 *       |-- SelectableChannel
 *          |--SocketChannel
 *          |--ServerSocketChannel
 *          |--DatagramChannel
 *
 *          |--Pipe.SinkChannel
 *          |--Pipe.SourceChannel
 *
 *  2. 缓冲区Buffer：负责数据的存取
 *  3. 选择器（Selector）：是SelectableChannel的多路复用器，用于监控SelectableChannel的IO状况
 *
 *  本类测试阻塞式NIO网络传输通讯
 */
public class TestNonBlockingNIO {


    //客户端
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
//        FileChannel inChannel = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/JSTM2.txt"), StandardOpenOption.READ);

        //切换成非阻塞模式
        sChannel.configureBlocking(false);

        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //读取本地文件，并发送到服务器
//        while (inChannel.read(buf)!=-1){
        buf.put( new Date().toString().getBytes());
        buf.flip();
        sChannel.write(buf);
        buf.clear();
//        }
        //关闭通道
//        inChannel.close();
        sChannel.close();

    }


    @Test
    public void server() throws IOException {
        //1. 获取通道
        ServerSocketChannel  ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/JSTM2-2.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //切换成非阻塞模式
        ssChannel.configureBlocking(false);

        ssChannel.bind(new InetSocketAddress(9898));

        //4 获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器上,并且指定监听接收事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT,null);

        //6。 轮循式获取选择器上已经"准备就绪"的事件
        while(selector.select()>0){
            //获取当前选择器中所有注册的选择器（已就绪的监听事件）
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                //获取准备就绪的事件
                SelectionKey sk = it.next();
                if(sk.isAcceptable()){
                    //若接收就绪，获取客户端连接
                    SocketChannel sChannel = ssChannel.accept();
                    //切换非阻塞模式
                    sChannel.configureBlocking(false);
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //获取"读就绪"状态的通道
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    int len =0;
                    while ((len = sChannel.read(buf))>0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }

                }
                //取消选择键SelectionKey
                it.remove();

            }
        }



        /*SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (sChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }*/
        ssChannel.close();
        outChannel.close();
//        sChannel.close();
    }


}
