package cn.exercise.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * NIO面向通道Channel和缓冲区Buffer的输入输出编程
 * 1。 缓冲区，在NIO中负责数据存储，底层是数组，用于存储不同数据类型的数据，根据数据类型不同（boolean除外），提供了响应类型的缓冲区
 *    ByteBuffer
 *    CharBuffer
 *    ShortBuffer
 *    IntBuffer
 *    LOngBuffer
 *    FloatBuffer
 *    DoubleBuffer
 *
 *    通过allocate（）获取缓冲区
 *
 *  2. 核心方法：
 *    put（）将数据存入缓冲区
 *    get（）获取缓冲区的数据
 *
 *
 *  4. 缓冲区四个核心属性：mark, pos, lim, cap
 *     capacity:最大存储数据容量，一旦声明，不能改变
 *     limit：界限，表示缓冲区中可以操作数据的大小
 *     position: 位置，表示缓冲区正在操作数据的位置position<=limit<=capacity
 *     mark：记录当前position的位置，可以通过reset（）回复到mark的位置
 *
 */
public class TestBuffer {




    @Test
    public void test1(){

        String str = "Hello,World";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        System.out.println("---------缓冲区数据allocated-----------");
        System.out.println(buf.position()+" ");
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println();

        //切换读数据模式
        buf.flip();
        System.out.println("---------切换读数据模式flip()-----------");
        System.out.println(buf.position()+" ");
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));

        System.out.println(buf.position()+" ");
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //rewind()：可重复读
        buf.rewind();

        //清空缓冲区clear（），但缓冲区的数据依然存在，数据处于"被遗忘状态"
        buf.clear();

    }

}
