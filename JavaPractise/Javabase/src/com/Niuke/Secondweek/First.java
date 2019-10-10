package com.Niuke.Secondweek;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 牛牛对整除非常感兴趣。牛牛的老师给他布置了一道题：牛牛的
 * 老师给出一个n,然后牛牛需要回答出能被1到n之间（包括1和n）
 * 所有整数整除的最小的数。牛牛犯了难，希望你能编程帮他解决这个问题
 * 输入包括一个整数n(1<=n<=100000)
 * 输出一个整数，即满足要求的最小整数。答案可能很大，请输出这个整数对于987654321取模的结果
 * 示例:输入:3输出:6
 */
public class First {
    private static long mod=987654321;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            int k=i;
            for(int j=2;j*j<=n;j++){
                int t=0;
                while(k%j==0){
                    t++;
                    k/=j;
                }
                arr[j]=Math.max(arr[k],t);
            }
            if(k>1){arr[k]=Math.max(arr[k],1);}
        }
        BigInteger res = new BigInteger("1");
        for(int i=1;i<=n;i++){
            for(int j=0;j<arr[i];j++){
                res = (res.multiply(BigInteger.valueOf(i))).remainder(BigInteger.valueOf(mod));
            }
        }
        System.out.println(res);
    }
}
