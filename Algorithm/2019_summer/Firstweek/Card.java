package com.Niuke.Firstweek;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Card
 * @Description TODO
 * @Date 19-7-21 下午9:11
 */
public class Card {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int nn=0,yy=0;
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            Arrays.sort(a);
            for(int j=n-1;j>=0;j--){
                nn+=a[j];
                if(j>0) {
                    j--;
                    yy += a[j];
                }
            }
            System.out.println(nn-yy);
    }
}
