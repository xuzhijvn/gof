package com.xzj.singleton;
/**
 * 
 * 上述实现单例的方式，其实等同于，将 INSTANCE 设置为 public static final 的方式，不同之处在于，
 * 使用枚举的方式显得更为简洁，且默认提供了序列化机制，也保证了多线程访问的安全。
 * 虽然这种单例的实现方式还未被广泛使用，可实现单例的最好方式就是使用一个单元素的枚举。
 * 
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月25日 下午4:20:45
*/
public enum Singleton3 {
    INSTANCE;  
    public void whateverMethod() {  
    } 
}
