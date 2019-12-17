package cn.exercise.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 1. 通道的主要实现类
 *    Java.nio.channels.Channel接口
 *      FileChannel
 *      SocketChannel
 *      ServerSocketChannel
 *      DatagramChannel
 *  2. 获取通道  getChannel()方法
 *    本地IO:
 *      FileInputStream/FileOutputStream
 *      RandomAccessFile
 *
 *    网络IO：
 *    Socket
 *    ServerSocket
 *    DatagramSocket
 *
 *  4. 通道之间的数据传输
 *
 *  5. 分散鱼聚集 Scatter  Gather
 *    分散读取 Scatter Reads
 *    聚集写入 Gather Writes
 *
 *  6. 字符集Charset
 *    编码：字符串 -》 字节数组
 *    解码  字节数组 -》字符串
 *
 *
 *  7. NIO 非阻塞式网络通讯
 */
public class TestChannel {

    @Test
    public void test6() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();
        CharBuffer cbuff = CharBuffer.allocate(1024);
        cbuff.put("黄林玉威武！");
        cbuff.flip();

        //编码
        ByteBuffer bbuff = ce.encode(cbuff);
        for (int i=0;i<12;i++){
            System.out.println(bbuff.get());
        }

        //解码
        bbuff.flip();
        CharBuffer cbuf2 = cd.decode(bbuff);
        System.out.println(cbuf2.toString());
        System.out.println("-----------------");

        //采用utf-8解码，会出现乱码
        Charset cs2 = Charset.forName("UTF-8");
        bbuff.flip();
        CharBuffer cbuf3 = cs2.decode(bbuff);
        System.out.println(cbuf3.toString());


    }



    @Test
    public void test4() throws IOException{
        RandomAccessFile raf1 = new RandomAccessFile("/Users/linyuhuang/Downloads/JSTM2.txt","rw");
        FileChannel channel1 = raf1.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(200);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //分散读取
        ByteBuffer[] bufs = {buf1,buf2};

        channel1.read(bufs);
        for(ByteBuffer byteBuffer: bufs){
            byteBuffer.flip();
        }


        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("------------------------");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));


        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("/Users/linyuhuang/Downloads/2.txt","rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);


    }


    /**
     * 通道之间的数据传输(之间缓冲区)
     */
    public void test3() throws IOException{
        FileChannel inChannel  = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/ubuntu-18.04.3-desktop-amd64.iso"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/ubuntu-18.04.3-desktop-amd64-3.iso"),StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);

        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());

        inChannel.close();
        outChannel.close();
    }


    /**
     * 使用直接缓冲区完成文件的复制（内存映射文件）
     * @throws IOException
     */
    @Test
    public void test2() throws IOException{
        long start = System.currentTimeMillis();

//        FileChannel inChannel  = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/spring-boot-reference.pdf"), StandardOpenOption.READ);
        FileChannel inChannel  = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/ubuntu-18.04.3-desktop-amd64.iso"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/linyuhuang/Downloads/ubuntu-18.04.3-desktop-amd64-3.iso"),StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());
        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为："+(end-start)+" 毫秒");
    }


    @Test
    public void test1()  {
        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel  = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("/Users/linyuhuang/Downloads/ubuntu-18.04.3-desktop-amd64.iso");

            fos = new FileOutputStream("/Users/linyuhuang/Downloads/ubuntu-18.04.3-desktop-amd64-2.iso");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inChannel.read(buf)!=-1){
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为："+(end-start)+" 毫秒");

    }
}
