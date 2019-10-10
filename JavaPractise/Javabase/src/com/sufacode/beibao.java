package com.sufacode;

import java.util.Scanner;

/**
 * @Classname beibao
 * @Description TODO
 * @Date 19-5-27 下午10:24
 * @Created by ltt
 */
public class beibao {
    public static void bao(int[] w,int[] b,int[] v,int n,int c,int d){
        int i,j,k;
        int[][][] dp = new int[50][50][50];
        for(i=1;i<n+1;i++)
            for(j =1;j <=c;j++)
                for(k = 1 ;k <= d ; k++)
                {
                    if(w[i]<=j&&b[i]<=k)//当前物品重量小于当前容量，且体积小于容积时 ，才可以考虑装入物品的问题
                        dp[i][j][k] = Math.max(dp[i-1][j][k] , dp[i-1][j-w[i]][k-b[i]] + v[i]);
                    else
                        dp[i][j][k] = dp[i-1][j][k];
                }
        System.out.println("背包能放物品的最大价值为:"+dp[n][c][d]);
/*        int[] x = new int[999];
        for(i=n;i>1;i--)
            if(dp[i][c][d]==dp[i-1][c][d])
                x[i]=0;
            else{
                x[i]=1;
                c-=w[i];
                d-=b[i];
            }
        x[1]=(dp[1][c][d]==0)?1:0;
        *//*System.out.print("被选入背包的物品的编号,质量和体积,价值分别是:");
        for(i=1;i<=n+1;i++)
            if(x[i]==1)
                System.out.println("第"+i+"个物品:"+w[i]+" "+b[i]+" "+v[i]);*/
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i;
        int n, c, d;
        int[] w = new int[500];
        int[] b = new int[500];
        int[] v = new int[500];
        System.out.println("请输入物品个数:");
        n = in.nextInt();
        System.out.println("请输入背包的容量及容积");
        c = in.nextInt();
        d = in.nextInt();
        System.out.println("依次输入各个物品的重量,体积,价值:(共" + n + "个)");
        for (i = 1; i < n + 1; i++) {
            w[i] = in.nextInt();
            b[i] = in.nextInt();
            v[i] = in.nextInt();
        }
        bao(w,b,v,n,c,d);
    }
}
