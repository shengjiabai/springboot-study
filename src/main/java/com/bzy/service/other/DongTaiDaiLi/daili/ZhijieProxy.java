package com.bzy.service.other.DongTaiDaiLi.daili;

/**
 * 这里可以直接调用这个类
 */
public class ZhijieProxy implements IRentHouse {
    
    private IRentHouse iRent = new RentHouse();
    
  
    @Override
    public void rentHouse() {
        System.out.println("交中介费");
        iRent.rentHouse();
        System.out.println("中介负责维修管理");
    }
}
