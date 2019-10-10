package com.sufacode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Classname shanshu
 * @Description TODO
 * @Date 19-5-20 下午8:50
 * @Created by ltt
 */
public class shanshu {
    public static void shan(BigInteger n, int k){
        StringBuilder a= new StringBuilder(""+n);
        for(int i=0;i<k;i++){
            int j=0;
            /**找当前比下一位数大的**/
            while(j<a.length()-1 && a.charAt(j)<=a.charAt(j+1))
                j++;
            a.delete(j,j+1);
        }
        //Integer.parseInt((a.toString())
        System.out.println("删去"+k+"个数字后得到的最小数为:"+a.toString());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        BigInteger n;
        System.out.print("请输入数字: ");
        n=in.nextBigInteger();
        System.out.print("请输入要删除的位数: ");
        m=in.nextInt();
        shan(n,m);
    }
}
