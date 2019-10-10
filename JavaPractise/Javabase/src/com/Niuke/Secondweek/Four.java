package com.Niuke.Secondweek;

import java.util.Scanner;

/**
 * 对于字符串x和y,如果擦除x中的某些字母(有可能全擦掉或者都不擦)
 * 能够得到y,我们就称y是x的子序列。例如."ncd"是"nowcoder"的子序列,而"xt"不是。
 * 现在对于给定的一个字符串s,请计算出字典序最大的s的子序列。
 * 输入描述:输入包括一行,一个字符串s,字符串s长度length(1≤length≤50).s中每个字符都是小写字母
 * 输出描述:输出一个字符串,即字典序最大的s的子序列。
 *
 * 示例:输入:test 输出:tt
 */
public class Four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder a = new StringBuilder(in.next());
        for(int i=a.length()-2;i>=0;i--){
            if(a.charAt(i)<a.charAt(i+1)){
                a.delete(i,i+1);
            }
        }
        System.out.println(a.toString());
    }
}
