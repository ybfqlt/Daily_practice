package com.design.Abstract_factory;

/**
 * @Classname FactoryProducer
 * @Description TODO
 * @Date 19-12-14 下午7:48
 * @Created by xns
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }else if(choice.equalsIgnoreCase("color")){
            return new ColorFactory();
        }
        return null;
    }
}
