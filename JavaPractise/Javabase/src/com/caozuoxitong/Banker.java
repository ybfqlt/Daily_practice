package com.caozuoxitong;

import java.util.Scanner;

/**
 * @Classname Banker
 * @Description TODO
 * @Date 19-10-21 上午10:57
 * @Created by xns
 */

public class Banker {

    int jin;
    /**
     * 系统可用资源，可利用资源向量Available
     */
    int[] Available= new int[3];
    /**
     * 各进程所需各类资源的最大需求，最大需求矩阵Max
     */
    int[][] Max;
    /**
     * 系统已分配资源，分配矩阵Allocation
     */
    int[][] Allocation;
    /**
     * 还需要资源，需求矩阵Need
     */
    int[][] Need;
    /**
     * 进程Pi的请求向量
     */
    int[][] Request;
    /**
     * 表示系统可提供给进程继续运行所需的各类资源数目，它含有m个元素，在执行算法开始时，Work:=Available
     */
    int[] Work = new int[3];

    int processnum = 0;
    /**
     * Max矩阵
     */
    public void setMax() {
        Scanner in = new Scanner(System.in);
        System.out.println("最大需求矩阵Max：");
        for (int i = 0; i < jin; i++) {
            System.out.println("请输入进程P" + i + "对资源(A B C)的最大资源需求量：");
            for (int j = 0; j < 3; j++) {
                Max[i][j] = in.nextInt();
            }
        }
    }

    /**
     * 已分配矩阵Allocation，并求出可用资源Available和需求矩阵Need
     */
    public void setAllocation() {
        Scanner in = new Scanner(System.in);
        System.out.println("分配矩阵Allocation：");
        for (int i = 0; i < jin; i++) {
            System.out.println("请输入进程P" + i + "当前已分配资源(A B C)的量：");
            for (int j = 0; j < 3; j++) {
                Allocation[i][j] = in.nextInt();
            }
        }
        /**
         * Available矩阵
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < jin; j++) {
                Available[i] = Available[i] - Allocation[j][i];
            }
        }
        /**
         * Need矩阵
         */
        for (int i = 0; i < jin; i++) {
            for (int j = 0; j < 3; j++) {
                Need[i][j] = Max[i][j] - Allocation[i][j];
            }
        }
    }

    /**
     * 打印资源分配
     */
    public void printVariable(){
        System.out.println("此时资源分配情况如下：");
        System.out.println("进程"+"   Max   "+"    Allocation "+"    Need  "+"   Available ");
        System.out.println("  "+"  A   B  C "+"   A   B  C   "+" A   B  C "+"   A   B  C  ");
        for(int i=0;i<jin;i++){
            System.out.print("P"+i+"  ");
            for(int j=0;j<3;j++){
                System.out.print(Max[i][j]+"  ");
            }
            System.out.print("   ");
            for(int j=0;j<3;j++){
                System.out.print(Allocation[i][j]+"  ");
            }
            System.out.print("   ");
            for(int j=0;j<3;j++){
                System.out.print(Need[i][j]+"  ");
            }
            System.out.print("   ");
            if(i==0){
                for(int j=0;j<3;j++){
                    System.out.print(Available[j]+"  ");
                }
            }
            System.out.println();
        }
    }


    /**
     * 设置请求资源量Request
     */
    public void setRequest() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入请求资源的进程编号：");
        /**
         * 设置请求资源的进程编号
         */
        processnum = in.nextInt();
        System.out.println("请输入请求资源(A B C)对应的的数量：");
        for (int j = 0; j < 3; j++) {
            Request[processnum][j] = in.nextInt();
        }
        bankerAlgorithm();
    }

    /**
     * 银行家算法
     */
    public void bankerAlgorithm() {
        boolean flag=true;

        if (Request[processnum][0] <= Need[processnum][0] && Request[processnum][1] <= Need[processnum][1] && Request[processnum][2] <= Need[processnum][2]) {
            if (Request[processnum][0] <= Available[0] && Request[processnum][1] <= Available[1] && Request[processnum][2] <= Available[2]) {
                for (int i = 0; i < 3; i++) {
                    Available[i] -= Request[processnum][i];
                    Allocation[processnum][i] += Request[processnum][i];
                    Need[processnum][i] -= Request[processnum][i];
                }

            } else {
                System.out.println("当前没有足够的资源可分配，进程P" + processnum + "需等待。");
                flag=false;
            }
        } else {
            System.out.println("进程P" + processnum + "请求已经超出最大需求量Need.");
            flag=false;
        }

        if(flag==true){
            printVariable();
            System.out.println("安全性分析：");
            securityAlgorithm();
        }
    }


    /**
     * 安全算法
     */
    public void securityAlgorithm() {
        boolean[] finish = new boolean[jin];
        for(int i=0;i<jin;i++){
            finish[i]=false;
        }
        int count = 0;
        int ci=0;
        int[] safe=new int[5];
        for (int i = 0; i < 3; i++) {
            Work[i] = Available[i];
        }
        boolean flag = true;
        while (count < jin) {
            if(flag){
                System.out.println("进程"+"   Work  "+"     Need "+"     Allocation  "+"Work+Allocation ");
                System.out.println("   "+" A   B  C "+"   A   B  C "+"   A   B  C   "+" A   B  C       ");
                flag = false;
            }
            for (int i = 0; i < jin; i++) {

                if (finish[i]==false&&Need[i][0]<=Work[0]&&Need[i][1]<=Work[1]&&Need[i][2]<=Work[2]) {
                    System.out.print("P"+i+"  ");
                    for (int k = 0; k < 3; k++){
                        System.out.print(Work[k]+"  ");
                    }
                    System.out.print("   ");
                    for(int j=0;j<3;j++){
                        System.out.print(Need[i][j]+"  ");
                    }

                    System.out.print("   ");
                    for (int j = 0; j<3;j++){
                        Work[j]+= Allocation[i][j];
                    }
                    finish[i]=true;
                    safe[count]=i;

                    count++;
                    for(int j=0;j<3;j++){
                        System.out.print(Allocation[i][j]+"  ");
                    }

                    System.out.print("   ");
                    for(int j=0;j<3;j++){
                        System.out.print(Work[j]+"  ");
                    }
                    System.out.println();
                }
            }
            ci++;

            if(count==5){
                System.out.print("此时存在一个安全序列：{");
                for (int i = 0; i<jin;i++){
                    System.out.print("P"+safe[i]+" ");
                }
                System.out.println("}所以可分配。");
                break;
            }
            if(count<ci){
                count=jin;
                System.out.println("当前系统处于不安全状态，所以不存在安全序列。");
                break;
            }
        }
    }

    public  void init(){
        Scanner in = new Scanner(System.in);
        System.out.println("有几个进程:");
        jin = in.nextInt();
        System.out.println("三种资源的数量分别为:");
        for(int i=0;i<3;i++){
            Available[i]=in.nextInt();
        }
        Max = new int[jin][3];
        Allocation = new int[jin][3];
        Need = new int[jin][3];
        Request = new int[jin][3];
    }
    public static void main(String[] args) {
        Banker banker = new Banker();
        System.out.println("初始化进程个数，资源个数，以及各资源数量:");
        banker.init();
        boolean choose = true;
        String str;
        Scanner in = new Scanner(System.in);
        System.out.println("进程数："+ banker.jin+ "  资源(A,B,C)为:{"+banker.Available[0]+", "+banker.Available[1]+", "+banker.Available[2]+"}");

        banker.setMax();
        banker.setAllocation();
        banker.printVariable();
        banker.securityAlgorithm();
        while (choose == true) {
            banker.setRequest();
            System.out.println("是否继续请求(y/n):");
            str = in.nextLine();
            if (str.endsWith("n")) {
                choose = false;
            }
        }
    }
}

