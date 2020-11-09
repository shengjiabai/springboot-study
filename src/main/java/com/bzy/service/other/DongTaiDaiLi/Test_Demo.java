package com.bzy.service.other.DongTaiDaiLi;

public class Test_Demo {

	/**
	 * 动态代理是通过JDK的Proxy和一个调用处理器InvocationHandler来实现的，通过Proxy来生成代理类实例，而这个代理实例通过调用处理器InvocationHandler接收不同的参数灵活调用真实对象的方法。
	 *
	 * 因此： 我们需要做的是创建调用处理器，该调用处理器必须实现JDK的InvocationHandler
	 * @param args https://blog.csdn.net/qq30211478/article/details/77862121
	 */
	public static void main(String[] args) {
		
		Car benchi = new BenChi();
		Car benchi_proxy = new P_Class(benchi).createProxy();
		benchi_proxy.run();
		benchi_proxy.laba("666");
		benchi.laba("dididididi");	
	}
}
 
