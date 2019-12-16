package com.design.builder;

/**
 * @Classname Coke
 * @Description TODO
 * @Date 19-12-16 下午6:10
 * @Created by xns
 */
public class Coke extends ColdDrink{

    @Override
    public float price(){
        return 30.0f;
    }

    @Override
    public String name(){
        return "Coke";
    }
}
