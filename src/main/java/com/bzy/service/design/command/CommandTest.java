package com.bzy.service.design.command;

import com.bzy.service.design.command.cook.impl.GuangDongCook;
import com.bzy.service.design.command.cook.impl.JiangSuCook;
import com.bzy.service.design.command.cook.impl.ShanDongCook;
import com.bzy.service.design.command.cook.impl.SiChuanCook;
import com.bzy.service.design.command.cuisine.ICuisine;
import com.bzy.service.design.command.cuisine.impl.GuangDoneCuisine;
import com.bzy.service.design.command.cuisine.impl.JiangSuCuisine;
import com.bzy.service.design.command.cuisine.impl.ShanDongCuisine;
import com.bzy.service.design.command.cuisine.impl.SiChuanCuisine;
import org.junit.Test;

/**
 * Created by  on 2021/10/20.
 */
public class CommandTest {

    @Test
    public void test(){

        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // 下单
        xiaoEr.placeOrder();

    }
}
