package com.sufacode;


import java.util.Scanner;

/**
 * @Classname juli
 * @Description TODO
 * @Date 19-5-27 下午11:17
 * @Created by ltt
 */
public class juli {
    public static void main(String[] args) {
        int[][] f = new int[1000][1000];
        Scanner in = new Scanner(System.in);
        StringBuilder a=new StringBuilder("");
        StringBuilder b=new StringBuilder("");
        String ar=in.nextLine();
        String br=in.nextLine();
        a.append(ar);
        b.append(br);
        int m=ar.length();
        int n=br.length();
        for(int i=1;i<=m;i++)
            f[i][0]=i;
        for(int j=1;j<=n;j++)
            f[0][j]=j;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                if(a.charAt(i-1)==b.charAt(j-1))
                    f[i][j]=f[i-1][j-1];
                else
                    f[i][j]=Math.min(Math.min(f[i-1][j-1],f[i-1][j]),f[i][j-1])+1;
                System.out.println(f[m][n]);
    }
}

