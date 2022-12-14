package com.bzy.service.other.DongTaiDaiLi.daili;

//client测试类
public class TestStaticProxy {
    
    public static void main(String[] args) {
        //定义租房
        IRentHouse iRentHouse = new RentHouse();
        //定义中介
        IRentHouse intermediaryProxy = new IntermediaryProxy(iRentHouse);
        //中介租房
        intermediaryProxy.rentHouse();
    }
    
}
