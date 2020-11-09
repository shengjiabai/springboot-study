package com.bzy.service.other.DongTaiDaiLi;

/**
 * 被代理接口实现类
 */
public class BenChi implements Car {
	
	@Override
	public void run() {
		System.out.println("奔驰启动快");
	}
	
	@Override
	public void laba(String str) {
		System.out.println("过路口要减速鸣笛"+str);
	}
}