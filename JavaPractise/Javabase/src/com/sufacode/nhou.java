package com.sufacode;

import java.util.Scanner;

/**
 * @Classname nhou
 * @Description n皇后问题
 * @Date 19-5-28 下午7:48
 * @Created by ltt
 */
public class nhou {
    static int count;
    static int[] arr;
    static int n;
    public static int[] swap(Integer a,Integer b){
        int temp =a;
        a=b;
        b=temp;
        return new int[]{a,b};
    }

    public static boolean place(int t){
        for(int i=1;i<t;i++) {
            if ((Math.abs(arr[t] - arr[i]) == Math.abs(t - i))) {
                return false;
            }
        }
        return true;
    }
    public static void backtrack(int k){
        if(k>n)
            count++;
        else
            for(int j=k;j<=n;j++) {
                int[] sw=swap(arr[j], arr[k]);
                arr[j]=sw[0];
                arr[k]=sw[1];
                if (place(k))
                    backtrack(k + 1);
                int[] sww=swap(arr[j], arr[k]);
                arr[j]=sww[0];
                arr[k]=sww[1];
            }
            return ;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入皇后数量n：");
        n = in.nextInt();
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;//第i个皇后放在第i列
        }
        count = 0;
        backtrack(1);//从第一个皇后开始，即第一行开始搜索排列树解空间
        System.out.println("总共有"+count+"种方案来排列皇后");
    }
}
