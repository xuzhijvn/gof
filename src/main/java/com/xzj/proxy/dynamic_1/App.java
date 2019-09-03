package com.xzj.proxy.dynamic_1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        //外界通过代理才能让小明唱歌
        XiaoMingProxy xiaoMingProxy = new XiaoMingProxy();
        Person proxy = xiaoMingProxy.getProxy();

        proxy.sing("我爱你");

    }
}
