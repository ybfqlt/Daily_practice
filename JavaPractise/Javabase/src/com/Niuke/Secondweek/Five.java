package com.Niuke.Secondweek;

import java.util.Scanner;

/**
 * 小易有一个长度为N的正整数数列A={A[1],A[2],A[3]...,A[N]}。
 * 牛博士给小易出了一个难题:对数列A进行重新排列,使数列A满足所有的A[i]*A[i+1](1≤i≤N-1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 * 输入描述:输入的第一行为数列的个数t(1≤t≤10),接下来每两行描述一个数列A,第一行为数列长度n(1≤n≤10^5)第二行为n个正整数A[i](1≤A[i]≤10^9)
 * 输出描述:对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
 *
 * 示例:输入:
 * 2
 * 3
 * 110100
 * 4
 * 1234
 * 输出:Yes
 * No
 */
public class Five {
    /***
    * 情况如下:
    * 1.只能被2整除不能被4整除的的只能和能被2整除的数放在一起才能成为4的倍数
    * 2.奇数要和能被4整除的放在一起
     * 所以4要放在连个奇数之间以及奇数与偶数的连接处,所以,只要(能被4整除的数的个数<奇数个数-1,则NO)
     * 还有就是满足了(能被4整除的数的个数>=奇数个数-1,则NO,那么就看能被2整除但不能被4整除的数的个数了,等于0,则Yes,否则,
     * 就看前面求出的能被4整除的数的个数是否大于奇数个数-1,大于Yes,否则No
    **/
    public static boolean judge(int n,int[] b){
        int[] temp = {0,0,0};
        for(int i=0;i<b.length;i++){
            if(b[i]%2!=0||b[i]==1){
                temp[0]++;
            }
            else if(b[i]%4!=0){
                temp[1]++;
            }
            else{
                temp[2]++;
            }
        }
        if(temp[2]<temp[0]-1 ||(temp[1]!=0&&temp[2]<temp[0])){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t--!=0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]= in.nextInt();
            }
            System.out.println(judge(n,arr)?"Yes":"No");
        }
    }
}
