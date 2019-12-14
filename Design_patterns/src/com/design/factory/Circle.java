package com.design.factory;

/**
 * @Classname Circle
 * @Description TODO
 * @Date 19-12-14 下午6:50
 * @Created by xns
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method");
    }
}
