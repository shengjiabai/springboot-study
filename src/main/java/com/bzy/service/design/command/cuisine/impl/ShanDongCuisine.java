package com.bzy.service.design.command.cuisine.impl;


import com.bzy.service.design.command.cook.ICook;
import com.bzy.service.design.command.cuisine.ICuisine;

/**
 *
 * 山东（鲁菜）
 */
public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}