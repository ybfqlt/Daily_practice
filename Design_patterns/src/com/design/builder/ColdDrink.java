package com.design.builder;

/**
 * @Classname ColdDrink
 * @Description TODO
 * @Date 19-12-16 下午6:03
 * @Created by xns
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing(){
        return new Bottle();
    }

    @Override
    public abstract float price();
}
