package com.bzy.service.design.command.cuisine.impl;

import com.bzy.service.design.command.cook.ICook;
import com.bzy.service.design.command.cuisine.ICuisine;

/**
 * 广东（粤菜）
 * Created by  on 2021/10/20.
 */
public class GuangDoneCuisine implements ICuisine {
    
    private ICook iCook;
    
    public GuangDoneCuisine(ICook iCook){
        this.iCook = iCook;
    }
    
    @Override
    public void cook() {
        iCook.doCooking();
    }
}
