package com.xzj.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;


/**
 * Create by xuzhijun.online on 2019/4/5.
 */
public class SocketReadHandler implements Runnable{

    private SocketChannel socketChannel;

    /**
     * channel向selector注册
     * @param selector
     * @param socketChannel
     * @throws IOException
     */
    public SocketReadHandler(Selector selector,SocketChannel socketChannel) throws IOException{
        this.socketChannel=socketChannel;
        socketChannel.configureBlocking(false);
        //socketChannel向selector注册，ops: 0 代表不监听任何东西
        SelectionKey selectionKey=socketChannel.register(selector, 0);

        //将SelectionKey绑定为本Handler 下一步有事件触发时，将调用本类的run方法。
        //参看dispatch(SelectionKey key)
        selectionKey.attach(this);

        //覆盖注册时的ops: 0, 监听可读操作
        selectionKey.interestOps(SelectionKey.OP_READ);
        //唤醒阻塞(在本案例中多余，因为此时selector还没有进入新的一轮select的阻塞操作)
        selector.wakeup();
    }

    /**
     * 处理读取数据
     */
    @Override
    public void run() {
        ByteBuffer inputBuffer=ByteBuffer.allocate(1024);
        inputBuffer.clear();
        try {
            socketChannel.read(inputBuffer);
            //激活线程池 处理这些request
            //requestHandler(new Request(socket,btt));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}