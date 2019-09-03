传统网络IO模型中，线程处理连接时，大部分时间浪费在等待网络资源准备就绪，accept(), read(), write()都是阻塞操作。

实际上，如果能省去这99%的等待时间，单个线程的并发性能也能很高。

采用nio使得只有资源准备就绪才去处理（“可接收”，“可读”，“可写”，Linux 2.6之前是select、poll，2.6之后是epoll，Windows是IOCP），省去了空等时间。

单线程Reactor模型，用一个线程完成所有的accept(), read(), write()操作，效率一样有保障。

多线程Reactor模型，主线程只负责accept()连接，不同连接的read(), write()操作交由线程池处理，进一步提高并发性能。


[参考链接](https://blog.csdn.net/u010168160/article/details/53019039)

[参考链接](https://tech.meituan.com/2016/11/04/nio.html)

[参考链接](http://afghl.github.io/2016/12/18/java-nio-03-nio-socket-server.html)
