package com.Niuke.Secondweek;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 牛牛有两个字符串A和B,其中A串是一个01串,B串中除了可能
 * 有0和1,还可能有'?',B中的'?'可以确定为0或者1。寻找一个字
 * 符串T是否在字符串S中出现的过程,称为字符串匹配。牛牛现在考
 * 虑所有可能的字符串B,有多少种可以在字符串A中完成匹配。
 * 例如:A="00010001",B="??"字符串B可能的字符串是"00","01","10","11",只有"11"没有出现在字符串A中,所以输出3
 * 输入包括两行,第一行一个字符串A,字符串A长度length(1≤length≤50),A中每个字符都是'0'或者'1'。第二行一个字符串B,字符串B长度length(1≤length≤50),B中的字符包括'0','1'和'?'。
 * 输出一个整数,表示能匹配的字符串种数。
 *
 * 示例:
 * 输入:
 * 00010001
 * ??
 * 输出
 * :3
 */
public class Second {
    public static void main(String[] args) {
        int k;
        Scanner in = new Scanner(System.in);
        StringBuilder a = new StringBuilder(in.next());
        StringBuilder b = new StringBuilder(in.next());
        HashSet<String> hh = new HashSet<>();
        for(int i=0;i<=a.length()-b.length();i++){
            StringBuilder c = new StringBuilder();
            k=i;
            for(int j=0;j<b.length();j++){
                if(b.charAt(j)=='?'||b.charAt(j)==a.charAt(k)){
                    c.append(a.charAt(k));
                    k++;
                }
            }
            if(c.length()==b.length()){
                hh.add(c.toString());
            }
        }
        System.out.println(hh.size());
    }
}
