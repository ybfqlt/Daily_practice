package com.sufacode;

/**
 * @Classname Huichang
 * @Description TODO
 * @Date 19-6-18 下午5:32
 * @Created by xns
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname huichanganpai
 * @Description TODO
 * @Date 19-6-16 上午10:56
 * @Created by xns
 */
public class Huichang{
    public static void Fun(int n,int[] start,int[] end,int[] space){
        int count=0;
        int flag=0;
        Arrays.sort(space,0,2*n);
        for(int i=0;i<2*n;i++){
            if(flag==n){
                break;
            }
            for(int t=0;t<n;t++){
                if(space[i]==start[t]){
                    flag++;
                    count++;
                    break;
                }
                if(space[i]==end[t]){
                    count--;
                    break;
                }
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
        int[] space = new int[2*n];
        System.out.println("请输入对应的"+n+"组活动开始结束的时间:");
        for(int i=0,j=0;i<n;i++){
            start[i]=in.nextInt();
            end[i]=in.nextInt();
            space[j++]=start[i];
            space[j++]=end[i];
        }
        Fun(n,start,end,space);
    }
}
