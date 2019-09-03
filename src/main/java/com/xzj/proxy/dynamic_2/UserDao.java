package com.xzj.proxy.dynamic_2;

public class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}