package cn.exercise.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、使用
 *
 */
public class TestBlockingNIO {


    //客户端
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        FileChannel inChannel = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/JSTM2.txt"), StandardOpenOption.READ);

        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //读取本地文件，并发送到服务器
        while (inChannel.read(buf)!=-1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        //关闭通道
        inChannel.close();
        sChannel.close();

    }


    @Test
    public void server() throws IOException {
        //1. 获取通道
        ServerSocketChannel  ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/JSTM2-2.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);


        ssChannel.bind(new InetSocketAddress(9898));

        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (sChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        ssChannel.close();
        outChannel.close();
        sChannel.close();
    }


}
