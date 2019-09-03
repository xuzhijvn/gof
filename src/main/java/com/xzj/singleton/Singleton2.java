package com.xzj.singleton;

import java.io.Serializable;

/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月25日 下午3:27:08
*/
class Singleton2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private static volatile Singleton2 INSTANCE = null;

    private Singleton2() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static Singleton2 getInstance() {
        if (INSTANCE == null) { // Check 1
            synchronized (Singleton2.class) {
                if (INSTANCE == null) { // Check 2
                    INSTANCE = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unused")
    private Singleton2 readResolve() {
        return INSTANCE;
    }
}
