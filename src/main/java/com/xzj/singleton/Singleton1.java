package com.xzj.singleton;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 上午9:03:03
 */
public class Singleton1 {
	
	static {
		System.out.println("外部类-静态代码块");
	}
	
	private static class Holder {
		
		static {
			System.out.println("静态内部类-静态代码块");
		}
		private static Singleton1 singleton = new Singleton1();
	}

	private Singleton1() {
	}

	public static Singleton1 getSingleton() {
		return Holder.singleton;
	}
	
	public static void main(String[] args) {
		//外部类-静态代码块
		//外部类-main方法
		System.out.println("外部类-main方法");
		//外部类-静态代码块
		//外部类-main方法
		//静态内部类-静态代码块
		Singleton1.getSingleton();
	}
}
