package com.design.builder;

/**
 * @Classname VegBurger
 * @Description TODO
 * @Date 19-12-16 下午6:06
 * @Created by xns
 */
public class VegBurger extends Burger {

    @Override
    public float price(){
        return 25.0f;
    }

    @Override
    public String name(){
        return "Veg Burger";
    }
}
