package com.bzy.service.other.DongTaiDaiLi.daili;

public class RentHouse implements IRentHouse {

    @Override
    public void rentHouse() {
        
        //实现租房子，但是想打点日志 ，其他人租房子有不想打日志   这个时候代理来了
        System.out.println("实现租房");
    }
}
