package com.design.Abstract_factory;

/**
 * @Classname ShapeFactory
 * @Description TODO
 * @Date 19-12-14 下午7:41
 * @Created by xns
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if(shape == null){
            return null;
        }if(shape.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shape.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }else if(shape.equalsIgnoreCase("square")){
            return new Square();
        }
        return null;
    }
}
