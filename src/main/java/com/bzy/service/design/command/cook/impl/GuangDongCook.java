package com.bzy.service.design.command.cook.impl;

import com.bzy.service.design.command.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GuangDongCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("广东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
    }

}
