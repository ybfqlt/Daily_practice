package com.sufacode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname fuwu
 * @Description TODO
 * @Date 19-6-16 下午2:45
 * @Created by xns
 */
public class fuwu {
    public static void waitaverage(int n,int s,int[] wait){
        double total=0;
        int[] ss = new int[s];//s个服务处服务时间记录
        Arrays.sort(wait,0,n-1);//将顾客的服务时间从短到长排序
        int i=0,j=0;
        while(i<n){
            ss[j]+=wait[i];
            total+=ss[j];
            i++;
            j++;
            if(j==s)
                j=0;
        }
        System.out.println("\n最小平均等待时间:");
        System.out.println(total/n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入等待服务的顾客数和服务个数:");
        int n= in.nextInt();
        int s = in.nextInt();
        int[] a = new int[n+1];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();//存储每个顾客需要的服务时间
        }
       waitaverage(n,s,a);
    }
}
