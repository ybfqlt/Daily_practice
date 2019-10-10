package com.huisu;

import java.util.Scanner;

/**
 * @Classname Bianhuan
 * @Description TODO
 * @Date 19-6-23 上午11:22
 * @Created by xns
 */
public class Bianhuan {
    private static int bcount=100;
    private static int m;
    private static int lcount=0;
    private static int[] aa = new int[100];
    private static int[] aaa = new int[100];

    public static void fun(int n){
        if(n==m){
            if(lcount<bcount){
                bcount=lcount;
            }
            return ;
        }
        int temp=n/2;
        lcount++;
        if(lcount<bcount && n>0){
            aa[lcount]=1;
            fun(temp);
        }
        lcount--;
        temp=3*n;
        lcount++;
        if(lcount<bcount){
            aa[lcount]=2;
            fun(temp);
        }
        lcount--;
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n;
        System.out.println("请输入n和m:");
        n=in.nextInt();
        m=in.nextInt();
        lcount=0;
        fun(n);
        System.out.println(bcount);
        for(int i=bcount;i>=1;i--){
            if(aa[i]==2){
                System.out.print("f");
            }
            if(aa[i]==1){
                System.out.print("g");
            }
        }
        System.out.println();
    }
}
