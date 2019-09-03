package com.xzj.reactor;

import java.io.IOException;
import java.nio.channels.SocketChannel;
/**
 * Create by xuzhijun.online on 2019/4/5.
 */
public class Acceptor implements Runnable{
    private Reactor reactor;
    public Acceptor(Reactor reactor){
        this.reactor=reactor;
    }
    @Override
    public void run() {
        try {
            SocketChannel socketChannel=reactor.serverSocketChannel.accept();
            if(socketChannel!=null)
                //调用Handler来处理channel
                new SocketReadHandler(reactor.selector, socketChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}