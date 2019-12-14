package com.design.factory;

/**
 * @Classname Square
 * @Description TODO
 * @Date 19-12-14 下午6:50
 * @Created by xns
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
