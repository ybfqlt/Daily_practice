package com.Test;

import org.w3c.dom.ls.LSOutput;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname test1
 * @Description TODO
 * @Date 19-12-18 下午6:49
 * @Created by xns
 */
public class test1 {


    public static void main(String[] args) {
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put(null, "aa");
//        concurrentHashMap.put("key", null);
//        concurrentHashMap.containsKey(null);
//
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put(null, "aa");
        hashMap.put("key", null);


//        Hashtable<String, String> hashtable = new Hashtable<>(1);
//        hashtable.put("aa", "aa");
//        hashtable.put("aaa", "a");
//        int i=0;
//        Enumeration<String> enumeration = hashtable.keys();
//        Enumeration<String> enumeration1;
//        Enumeration<String> enumeration2;
////        (enumeration1 = hashtable.keys())
//        while(enumeration.hasMoreElements()){
//            System.out.println(enumeration);
//            i++;
////            (enumeration2 = hashtable.keys())
//            System.out.println(enumeration.nextElement());
//           System.out.println(enumeration);
//            if(i==10){
//                return;
//            }
//        }
    }
}
