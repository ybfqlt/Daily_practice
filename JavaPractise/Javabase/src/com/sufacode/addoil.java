package com.sufacode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import static java.lang.Integer.min;

/**
 * ClassName    suanfa-addoil
 * Description
 *
 * @author: ltt
 * @date: 19-4-22 下午4:27
 * @since: JDK 1.8
 */

class Foo{
    Foo(){
    }
    private int x;
    private int y;
    private int v;
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setV(int v){
        this.v=v;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getV(){
        return v;
    }
}

public class addoil {
    static int n,k,a,bb,c;
    static int[][][] f = new int[101][101][11];
    static int[][] d=new int[101][101];
    static int[][][] b=new int[101][101][11];
    static int[] xa={0,0,1,-1};
    static int[] ya={1,-1,0,0};
    static int ans=0x3f3f3f3f;
    static Queue<Foo> qt=new LinkedList<Foo>();


    public static void zhuti(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(f[i][j],0x3f);
            }
        }
        Foo r=new Foo();
        r.setX(1);
        r.setY(1);
        r.setV(k);
        b[1][1][k]=1;
        f[1][1][k]=0;
        qt.offer(r);
        while(qt.size()!=0){
           int x,y,v;
           x=qt.element().getX();
           y=qt.element().getY();
           v=qt.element().getV();
           qt.poll();
           b[x][y][v]=0;
           for(int i=0;i<4;i++){
               if(!(x+xa[i]!=0 && y+ya[i]!=0 &&(x+xa[i]<=n) && (y+ya[i]<=n)))
                   continue;
               int e=f[x][y][v];
               int w=v-1;
               if(xa[i]<0||ya[i]<0) e+=bb;
               if(d[x+xa[i]][y+ya[i]]!=0) {
                   e += a;
                   w = k;
               }
               if(w==0 && (x+xa[i]!=n || y+ya[i]!=n)) {
                   w = k;
                   e +=(a + c);
               }
               if(f[x+xa[i]][y+ya[i]][w]>e){
                   Foo t = new Foo();
                   f[x+xa[i]][y+ya[i]][w]=e;
                   t.setX(x+xa[i]);
                   t.setY(y+ya[i]);
                   t.setV(w);
                   if(b[t.getX()][t.getY()][t.getV()]==0)
                       qt.offer(t);
                   b[t.getX()][t.getY()][t.getV()]=1;
               }
           }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        k=in.nextInt();
        a=in.nextInt();
        bb=in.nextInt();
        c= in.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                d[i][j]=in.nextInt();
            }
        }
        zhuti();
        for(int i=1;i<=k;i++) {
            ans = min(ans, f[n-1][n-1][i]);
        }
        System.out.println(ans);
    }
}
