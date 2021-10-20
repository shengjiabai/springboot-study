package com.bzy.service.design.command.cuisine.impl;


import com.bzy.service.design.command.cook.ICook;
import com.bzy.service.design.command.cuisine.ICuisine;

/**
 *
 * 四川（川菜）
 */
public class SiChuanCuisine implements ICuisine {

    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}