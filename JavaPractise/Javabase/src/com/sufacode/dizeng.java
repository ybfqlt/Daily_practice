package com.sufacode;

import java.util.Scanner;

/**
 * @Classname dizeng
 * @Description TODO
 * @Date 19-5-21 上午8:24
 * @Created by ltt
 */
public class dizeng {
    public static int binarysearch(int[] brr,int key,int len){
        int low=0;
        int high = len-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(brr[mid] == key)
                return mid;
            else if(brr[mid]>key)
                high=mid-1;
            else
                low=high+1;
        }
        return low;
    }
    public static int nlogn(int[] arr,int n ){
        int[] brr =new int[n];
        int len=1;//记录当前最长递增子序列的长度
        brr[0]=arr[0];//记录最长递增子序列长度为i的序列的末尾元素的值

        for(int i=1;i<n;i++){
            if(arr[i]>brr[len-1]){
                brr[len]=arr[i];
                len++;
            }
            else
            {
                int po = binarysearch(brr,arr[i],len);
                brr[po]=arr[i];
            }
        }
        return len;
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("请输入多少个数n:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("请输入n个数:");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("最长单调递增子序列长度为:"+nlogn(arr,n));
    }
}
