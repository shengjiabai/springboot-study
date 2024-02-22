package com.bzy.service.other.DongTaiDaiLi.daili;

/**
 * https://blog.csdn.net/weixin_43953283/article/details/125783249
 */
public class IntermediaryProxy implements IRentHouse {
    private IRentHouse iRent;
    
    public IntermediaryProxy(IRentHouse iRentHouse) {
        iRent=iRentHouse;
    }
    
    @Override
    public void rentHouse() {
        System.out.println("交中介费");
        iRent.rentHouse();
        System.out.println("中介负责维修管理");
    }
}
