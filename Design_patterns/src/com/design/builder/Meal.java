package com.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Meal
 * @Description TODO
 * @Date 19-12-16 下午6:12
 * @Created by xns
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for(Item item : items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for(Item item:items){
            System.out.print("Item : "+item.name());
            System.out.print(",Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
