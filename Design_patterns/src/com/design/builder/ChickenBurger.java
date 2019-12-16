package com.design.builder;

/**
 * @Classname ChickenBurger
 * @Description TODO
 * @Date 19-12-16 下午6:07
 * @Created by xns
 */
public class ChickenBurger extends Burger{
    @Override
    public float price(){
        return 50.5f;
    }

    @Override
    public String name(){
        return "Chicken Burger";
    }
}
