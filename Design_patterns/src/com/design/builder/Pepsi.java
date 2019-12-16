package com.design.builder;

/**
 * @Classname Pepsi
 * @Description TODO
 * @Date 19-12-16 下午6:11
 * @Created by xns
 */
public class Pepsi extends ColdDrink{

    @Override
    public float price(){
        return 35.0f;
    }

    @Override
    public String name(){
        return "Pepsi";
    }
}
