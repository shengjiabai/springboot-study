package com.bzy.service.other.DongTaiDaiLi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类，
 * 必须实现InvocationHandler接口
 * 
 */
public class P_Class implements InvocationHandler {
	
	private Car car;
	
	public P_Class(Car car){
		this.car = car;
	}
	
	public Car createProxy(){
		Car car_proxy = (Car) Proxy.newProxyInstance(car.getClass().getClassLoader(), 
				car.getClass().getInterfaces(), this);
		return car_proxy;
	}
 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("run".equals(method.getName())){
			System.out.println("开车不喝酒，喝酒不开车");
			method.invoke(car, args);
			System.out.println("安全伴我行");
			System.out.println(proxy.getClass().getName());			
		}
		return null;
	}
}