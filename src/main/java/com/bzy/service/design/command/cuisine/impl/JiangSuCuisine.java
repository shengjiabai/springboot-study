package com.bzy.service.design.command.cuisine.impl;


import com.bzy.service.design.command.cook.ICook;
import com.bzy.service.design.command.cuisine.ICuisine;

/**

 *
 * 江苏（苏菜）
 */
public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}