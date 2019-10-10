package com.sufacode;

import java.util.*;

public class quanpai {
    public static void swap(char[] ss, int i, int j){
        char temp;
        temp=ss[i];
        ss[i]=ss[j];
        ss[j]=temp;
    }
    public static void Perm(char[] s,int k){
        if(k==s.length-1) {
            System.out.println(Arrays.toString(s));
        }
        for(int i=k;i<=s.length-1;i++){
            if(i==k||s[i]!=s[k]) {
                swap(s, i, k);
                Perm(s, k + 1);
                swap(s, i, k);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String g;
        char[] a;
        System.out.println("请输入字符串:");
        g=in.next();
        a=g.toCharArray();
        System.out.println("全排列结果为:\n");
        quanpai.Perm(a,0);
    }
}
