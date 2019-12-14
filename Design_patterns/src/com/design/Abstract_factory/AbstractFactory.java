package com.design.Abstract_factory;

/**
 * @Classname AbstractFactory
 * @Description TODO
 * @Date 19-12-14 下午7:40
 * @Created by xns
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
