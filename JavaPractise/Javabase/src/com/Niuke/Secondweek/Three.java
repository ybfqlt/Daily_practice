package com.Niuke.Secondweek;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小度有一个小写字母组成的字符串s.字符串s已经被写在墙上了.
 * 小度还有很多卡片,每个卡片上有一个小写字母,组成一个字符串t。
 * 小度可以选择字符串t中任意一个字符,然后覆盖在字符串s的一个
 * 字符之上。小度想知道在选取一些卡片覆盖s的一些字符之后,可以得到的字典序最大的字符串是什么。
 * 输入描述:输入包括两行,第一行一个字符串s,字符串s长度length(1≤length≤50),s中每个字符都是小写字母第二行一个字符串t,字符串t长度length(1≤length≤50),t中每个字符都是小写字母
 * 输出描述:输出一个字符串,即可以得到的字典序最大字符串
 *
 * 示例:输入:
 * fedcba
 * ee
 * 输出:feeeba
 */
public class Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        Arrays.sort(b);
        for(int i=0,j=b.length-1;i<a.length&&j>=0;i++){
            if(a[i]<b[j]){
                a[i]=b[j];
                j--;
            }
        }
        System.out.println(new String(a));
    }
}
