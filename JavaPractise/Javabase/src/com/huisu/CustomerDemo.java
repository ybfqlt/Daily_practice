package com.huisu;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname CustomerDemo
 * @Description TODO
 * @Date 19-12-21 下午9:07
 * @Created by xns
 */
public class CustomerDemo {
    public static void main(String[] args) {
        List<Customer> customer = new ArrayList<>();
        customer.add(new Customer("Justin", "Lin", 804));
        customer.add(new Customer("Monica", "Huanf", 804));
        customer.add(new Customer("Irene", "Lin", 804));
        Comparator<Customer> bylastName = Comparator.comparing(Customer::getLastName);

        customer.sort(bylastName.thenComparing(Customer::getFirstName).thenComparing(Customer::getZipCode));
        customer.forEach(out::println);
    }
}
