package com.sufacode;

import java.util.Scanner;

/**
 * ClassName    suanfa-yinzifenjie
 * Description
 *
 * @author: ltt
 * @date: 19-4-23 上午9:05
 * @since: JDK 1.8
 */
public class yinzifenjie {
    public static int count;

    public static void part(int n){
        int i;
        if(n==1) count++;
        for(i=2;i<=n;i++){
            if(n%i==0)
                part(n/i);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("please input n:");
        while(in.hasNext()){
            n=in.nextInt();
            count=0;
            part(n);
            System.out.println("count: "+count);
            System.out.println("please input n:");
        }
    }
}