package com.sufacode;

import java.util.Scanner;

/**
 * ClassName    suanfa-ziran
 * Description
 *
 * @author: ltt
 * @date: 19-4-23 上午9:13
 * @since: JDK 1.8
 */
public class ziran {
    public static int fenzu(int[] a,int[] b,int n){
        int temp=a[0];
        int j=0;
        int i;
        b[j++]=0;
        for(i=1;i<n;i++){
            if(temp<=a[i]){
                temp=a[i];
            }else{
                b[j++]=i;
                temp=a[i];
            }
        }
        b[j++]=n;
        return j;
    }
    public static void merge(int a[],int lef,int mid,int rig,int n){
        int i=lef,j=mid+1,p=lef;
        int[] arr=new int[n];
        while(i<=mid&&j<=rig){
            if(a[i]<a[j]){
                arr[p++]=a[i++];
            }else{
                arr[p++]=a[j++];
            }
        }
        if(i!=mid+1){
            for(int k=i;k<=mid;k++){
                arr[p++]=a[k];
            }
        }
        if(j!=rig+1){
            for(int k=j;k<=rig;k++){
                arr[p++]=a[k];
            }
        }
        for(int k=lef;k<=rig;k++){
            a[k]=arr[k];
        }
    }
    public static void mergeSort(int[] a,int[] b,int n){
        int len = fenzu(a,b,n);
        int i;
        while(len!=2){
            for(i=0;i<len-2;i+=2){
                merge(a,b[i],b[i+1]-1,b[i+2]-1,n);
            }
            len=fenzu(a,b,n);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("please input n:");
        int n= in .nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        System.out.println("请输入a[n]: ");
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        mergeSort(a,b,n);
        System.out.println("after sort: ");
        for (int u:a) {
            System.out.print(u+" ");
        }
    }

}
