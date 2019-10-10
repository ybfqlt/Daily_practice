package com.Niuke.Threeweek;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用
 * 字符串表示。不能用系统自带的大整数类型。（题目来源：拼多多面试题）
 * 输入描述:空格分隔的两个字符串，代表输入的两个大整数
 * 输出描述:输入的乘积，用字符串表示
 * 输入: 72106547548473106236  982161082972751393
 * 输出:70820244829634538040848656466105986748
 */
public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigDecimal a = in.nextBigDecimal();
        BigDecimal b = in.nextBigDecimal();
        System.out.println(a.multiply(b));
    }
}
