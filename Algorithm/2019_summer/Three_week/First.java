package com.Niuke.Threeweek;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数
 * 的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * 输入描述:无序整数数组A[n]输出描述:满足条件的最大乘积
 * 示例:输入: 3 4 1 2
 * 输出:24
 */
public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        int n = in.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        if(n==3){
            System.out.println(arr[0]*arr[1]*arr[2]);
        }else{
            Arrays.sort(arr);
            for(int i=0;i<n;i++){
                if(arr[i]<0){t=i;}
            }
            if(arr[0]*arr[1]>arr[n-2]*arr[n-3] && arr[n-1] > 0){
                System.out.println(arr[n-1]*arr[0]*arr[1]);
            }
            else if(arr[n-1]<=0 && arr[n-2] > 0) {
                System.out.println(arr[n-1]*arr[0]*arr[1]);
            }
            else{
                System.out.println(arr[n - 2] * arr[n - 1] * arr[n - 3]);
            }
        }
    }
}
