package com.xzj.builder;

import java.util.Date;

/**
 * Create by xuzhijun.online on 2019/9/3.
 */
public class Test {
    public static void main(String[] args) {
        Person.Builder builder = new Person.Builder("rico", "boy", new Date(), "rico@tju.edu.cn");
        Person p1 = builder.height(173).addr("天津市").nickName("书呆子").build();
    }
}
