package com.design.builder;

/**
 * @Classname Burger
 * @Description TODO
 * @Date 19-12-16 下午6:01
 * @Created by xns
 */
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
