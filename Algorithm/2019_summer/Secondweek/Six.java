package com.Niuke.Secondweek;

import java.util.Scanner;

/**
 * 小招喵喜欢在数轴上跑来跑去，假设它现在站在点n处，它只会3种走法，分别是：
 * 1.数轴上向前走一步，即n=n+1
 * 2.数轴上向后走一步,即n=n-1
 * 3.数轴上使劲跳跃到当前点的两倍，即n=2*n
 * 现在小招喵在原点，即n=0，它想去点x处，快帮小招喵算算最快的走法需要多少步？
 * 输入描述:小招喵想去的位置x
 * 输出描述:小招喵最少需要的步数
 *
 * 示例:输入:3输出:3
 */
public class Six {
    public static int min(int x){
        x=Math.abs(x);
        if(x == 0){ return 0;}
        if(x == 1){ return 1;}
        if(x%2==0){
            return min(x/2)+1;
        }
        else{
            return Math.min(min(x-1)+1,min(x+1)+1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(min(x));
    }
}
