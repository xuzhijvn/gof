package com.xzj.singleton;
/**
 * 
  *  用CAS的好处在于不需要使用传统的锁机制来保证线程安全, CAS是一种基于忙等待的算法, 依赖底层硬件的实现,
  *  相对于锁它没有线程切换和阻塞的额外消耗,可以支持较大的并行度。

 * CAS的一个重要缺点在于如果忙等待一直执行不成功(一直在死循环中),会对CPU造成较大的执行开销。
  *  另外，如果N个线程同时执行到singleton = new Singleton();的时候，会有大量对象创建，很可能导致内存溢出。
 * 
  *  所以，不建议使用这种实现方式。
 * 
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月25日 下午4:25:13
*/

import java.util.concurrent.atomic.AtomicReference;

public class Singleton4 {
	
	private static final AtomicReference<Singleton4> INSTANCE = new AtomicReference<Singleton4>();
	
	private Singleton4() {}
	
	public static Singleton4 getInstance() {
		for(;;) {
			Singleton4 singleton4 = INSTANCE.get();
			if(singleton4 != null) {
				return singleton4;
			}
			singleton4 = new Singleton4();
			if(INSTANCE.compareAndSet(null, singleton4)) {
				return singleton4;
			}
		}
	}

}
