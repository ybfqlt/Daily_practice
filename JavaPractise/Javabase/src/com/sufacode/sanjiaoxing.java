package com.sufacode;

import java.io.*;
import java.util.Scanner;

/**
 * @Classname sanjiaoxing
 * @Description TODO
 * @Date 19-5-27 下午8:32
 * @Created by ltt
 */
public class sanjiaoxing {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(new FileInputStream(("/home/ltt/input.txt")));
            int n = sc.nextInt();
            int[][] num = new int[n][n];
            for(int i=0; i<n;i++){
                for(int j=0;j<=i;j++)
                    num[i][j] = sc.nextInt();
            }
            for(int i=n-2;i>=0;i--){
                for(int j=0;j<=1;j++){
                    num[i][j]=num[i][j]+Math.max(num[i+1][j],num[i+1][j+1]);
                }
            }
            System.out.println(num[0][0]);
            DataOutputStream out = new DataOutputStream(new FileOutputStream("/home/ltt/output.txt"));
            out.writeChar(num[0][0]);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
