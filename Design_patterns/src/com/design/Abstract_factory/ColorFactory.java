package com.design.Abstract_factory;

/**
 * @Classname ColorFactory
 * @Description TODO
 * @Date 19-12-14 下午7:46
 * @Created by xns
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("red")){
            return new Red();
        }else if(color.equalsIgnoreCase("green")){
            return new Green();
        }else if(color.equalsIgnoreCase("blue")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
