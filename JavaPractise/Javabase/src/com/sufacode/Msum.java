package com.sufacode;

import java.util.Scanner;

/**
 * @Author: ltt
 * @Date: 2019/5/4 下午8:11
 * @since: JDK 1.8
 */
public class Msum {
    public static int solve(int m,int n,int[] a,int[][] f){
        for(int i=1;i<=n;i++){
            f[i][1]=f[i-1][1]+a[i];
        }
        for(int i=1;i<=n;i++){
            for(int j=2;j<=m;j++){
                int min=Integer.MAX_VALUE;
                for(int k=1;k<i;k++){
                    int temp = (f[i][1]-f[k][1]>f[k][j-1]?f[i][1]-f[k][1]:f[k][j-1]);
                    if(temp<min){
                        min=temp;
                    }
                }
                f[i][j]=min;
            }
        }
        return f[n][m];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int m;
        System.out.println("请输入数组个数n :");
        n=in.nextInt();
        System.out.println("请输入m :");
        m=in.nextInt();
        int[] a = new int[n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            a[i]=in.nextInt();
        }
        int res = solve(m,n,a,dp);
        System.out.println(m+"段子序列的和的最大值最小为: "+res);
    }
}
