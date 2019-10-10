package com.Niuke.Firstweek;

import java.util.Scanner;

/**
 * @Classname Chocolate
 * @Description TODO
 * @Date 19-7-21 下午8:46
 */
public class Chocolate {
    public static int judge(int f,int d){
        int total=0;
        for(int i=0;i<d;i++){
            total+=f;
            f=(f+1)/2;
        }
        return total;
    }
    public static int binarysearch(int a,int b){
        int low = 1;
        int high = b;
        if(a==1) return b;
        while(low<=high){
            int middle = (low+high+1)/2;
            if(judge(middle,a)==b)
                return middle;
            else if(judge(middle,a)<b){
               low=middle+1;
            }else{
                high=middle-1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        int num = in.nextInt();
        System.out.println(binarysearch(d,num));
    }
}
