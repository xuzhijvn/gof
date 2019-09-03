package com.xzj.proxy.dynamic_1;

public class XiaoMing implements Person {

    @Override
    public void sing(String name) {

        System.out.println("小明唱：" + name);
    }

    @Override
    public void dance(String name) {

        System.out.println("小明跳：" + name);

    }
}