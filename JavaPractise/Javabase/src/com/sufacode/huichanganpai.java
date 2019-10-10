package com.sufacode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname huichanganpai
 * @Description TODO
 * @Date 19-6-16 上午10:56
 * @Created by xns
 */
public class huichanganpai {
    public static void Fun(int n,int[] start,int[] end,int[] mark,int[] space){
        for(int i=0;i<n;i++){
            space[i]=0;
            mark[i]=0;
        }
        int count=0;
        for(int i=0;i<n;i++){
            Arrays.sort(space,0,0+count+1);
            for(int j=0;j<=count;j++){
                if(start[i]>space[j]){
                    mark[i]=1;
                    space[j] = end[i];
                    break;
                }
            }
            if(mark[i]!=1){
                count++;
                space[count]=end[i];
            }
        }
        System.out.println("最少使用会场的个数:"+(count+1));
    }

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入会场个数:");
        n=in.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        System.out.println("请输入对应的"+n+"组活动开始结束的时间:");
        for(int i=0;i<n;i++){
           start[i]=in.nextInt();
           end[i]=in.nextInt();
        }
        int[] mark = new int[n];
        int[] space = new int[n]; //记录会场当前结束时间

        Fun(n,start,end,mark,space);
    }
}




/*
import java.util.Arrays;
import java.util.Scanner;

*/
/**
 * @Classname huichanganpai
 * @Description TODO
 * @Date 19-6-16 上午10:56
 * @Created by xns
 *//*

public class huichanganpai {
    public static void Fun(int n,int[] start,int[] end,int[] mark,int[] space){
        for(int i=0;i<n;i++){
            space[i]=0;
            mark[i]=0;
        }
        int count=0;
        for(int i=0;i<n;i++){
            System.out.println("count= "+count);
            System.out.println("会场当前结束时间: ");
            for(int k=0;k<=count;k++)
                System.out.println(space[k]+ " ");
            Arrays.sort(space,0,0+count+1);
            System.out.println("\n会场当前结束时间排序后: ");
            for(int k=0;k<=count;k++){
                System.out.println(space[k]+" ");
            }

            for(int j=0;j<=count;j++){
                if(start[i]>space[j]){
                    mark[i]=1;
                    space[j] = end[i];
                    System.out.println("end["+i+"]=" +end[i]+"    space["+j+"]="+space[j]);
                    break;
                }
            }
            if(mark[i]!=1){
                count++;
                space[count]=end[i];
                System.out.println("end["+i+"]"+end[i]+"      space["+count+"]="+" "+space[count]);
            }
        }
        System.out.println("使用会场的个数:"+(count+1));
        System.out.println("会场最后结束时间: ");
        for(int i=0;i<=count;i++){
            System.out.println(space[i]+"    ");
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入会场个数:");
        n=in.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        System.out.println("请输入对应的"+n+"组活动开始结束的时间:");
        for(int i=0;i<n;i++){
            start[i]=in.nextInt();
            end[i]=in.nextInt();
        }
        int[] mark = new int[n];
        int[] space = new int[n]; //记录会场当前结束时间

        Fun(n,start,end,mark,space);
    }
}
*/
