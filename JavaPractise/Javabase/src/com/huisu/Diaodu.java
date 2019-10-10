package com.huisu;

import java.util.Scanner;

/**
 * @Classname Diaodu
 * @Description TODO
 * @Date 19-6-23 下午12:17
 * @Created by xns
 */
public class Diaodu {
    private static int n,k,temp=21445656;
    private static int[] a = new int[1000];
    private static int[] aa = new int[1000];

    public static void backtrack(int b,int c){
        if(temp<=c)
            return;
        if(b==n+1){
            if(temp>c)
                temp=c;
            return;
        }
        for(int i=1;i<=k;i++) {
            if (aa[i] + a[b] < temp) {
                aa[i] += a[b];
                backtrack(b + 1, Math.max(c, aa[i]));
                aa[i] -= a[b];
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入任务个数n和机器个数k:");
        n=in.nextInt();
        k=in.nextInt();
        System.out.println("请输入每个任务的时间:");
        for(int i=1;i<=n;i++){
            a[i]=in.nextInt();
        }
        backtrack(1,0);
        System.out.println(temp);
    }
}
