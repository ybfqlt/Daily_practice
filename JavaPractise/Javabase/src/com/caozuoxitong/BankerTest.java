package com.caozuoxitong;

import java.util.Scanner;

/**
 * @Classname BankerTest
 * @Description TODO
 * @Date 19-10-21 上午10:58
 * @Created by xns
 */


public class BankerTest {


    /**
     * 系统可用资源，可利用资源向量Available
     */
    int[] Available = {10, 5, 7};
    /**
     * 各进程所需各类资源的最大需求，最大需求矩阵Max
     */
    int[][] Max = new int[5][3];
    /**
     * 系统已分配资源，分配矩阵Allocation
     */
    int[][] Allocation = new int[5][3];
    /**
     * 还需要资源，需求矩阵Need
     */
    int[][] Need = new int[5][3];
    /**
     * 进程Pi的请求向量
     */
    int[][] Request = new int[5][3];
    /**
     * 表示系统可提供给进程继续运行所需的各类资源数目，它含有m个元素，在执行算法开始时，Work:=Available
     */
    int[] Work = new int[3];

    int num = 0;//进程编号
    Scanner in = new Scanner(System.in);

    public BankerTest() {
    }

    public void setVariable() {//设置各初始系统变量，并判断是否处于安全状态。
        setMax();
        setAllocation();
        printVariable();
        securityAlgorithm();
    }

    /**
     * 设置Max矩阵
     */
    public void setMax() {
        System.out.println("开始设置各进程的最大需求矩阵Max：");
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入进程P" + i + "对资源(A B C)的最大资源需求量：");
            for (int j = 0; j < 3; j++) {
                Max[i][j] = in.nextInt();
            }
        }
    }

    /**
     * 设置已分配矩阵Allocation，并求出可用资源Available和需求矩阵Need
     */
    public void setAllocation() {
        System.out.println("开始设置请各进程分配矩阵Allocation：");
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入进程P" + i + "当前已分配资源(A B C)的量：");
            for (int j = 0; j < 3; j++) {
                Allocation[i][j] = in.nextInt();
            }
        }
        /**
         * 设置 Available矩阵
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Available[i] = Available[i] - Allocation[j][i];
            }
        }
        /**
         * 设置Need矩阵
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Need[i][j] = Max[i][j] - Allocation[i][j];
            }
        }
    }

    /**
     * 打印资源分配
     */
    public void printVariable() {
        System.out.println("此时资源分配情况如下：");
        System.out.println("进程" + "   Max   " + "    Allocation " + "    Need  " + "   Available ");
        System.out.println("  " + "  A   B  C " + "   A   B  C   " + " A   B  C " + "   A   B  C  ");
        for (int i = 0; i < 5; i++) {
            System.out.print("P" + i + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(Max[i][j] + "  ");
            }
            System.out.print("|  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(Allocation[i][j] + "  ");
            }
            System.out.print("|  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(Need[i][j] + "  ");
            }
            System.out.print("|  ");
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(Available[j] + "  ");
                }
            }
            System.out.println();
        }
    }


    /**
     * 设置请求资源量Request
     */
    public void setRequest() {

        System.out.println("请输入请求资源的进程编号：");
        /**
         * 设置请求资源的进程编号
         */
        num = in.nextInt();
        System.out.println("请输入请求资源(A B C)对应的的数量：");
        for (int j = 0; j < 3; j++) {
            Request[num][j] = in.nextInt();
        }
        bankerAlgorithm();
    }

    /**
     * 银行家算法
     */
    public void bankerAlgorithm() {
        boolean flag = true;

        if (Request[num][0] <= Need[num][0] && Request[num][1] <= Need[num][1] && Request[num][2] <= Need[num][2]) {//判断Request是否小于Need
            if (Request[num][0] <= Available[0] && Request[num][1] <= Available[1] && Request[num][2] <= Available[2]) {//判断Request是否小于Alloction
                for (int i = 0; i < 3; i++) {
                    Available[i] -= Request[num][i];
                    Allocation[num][i] += Request[num][i];
                    Need[num][i] -= Request[num][i];
                }

            } else {
                System.out.println("当前没有足够的资源可分配，进程P" + num + "需等待。");
                flag = false;
            }
        } else {
            System.out.println("进程P" + num + "请求已经超出最大需求量Need.");
            flag = false;
        }

        if (flag == true) {
            printVariable();
            System.out.println("安全性分析：");
            securityAlgorithm();
        }
    }


    /**
     * 安全算法
     */
    public void securityAlgorithm() {
        boolean[] finish = {false, false, false, false, false};//初始化finish
        int count = 0;//完成进程数
        int circle = 0;//循环圈数
        int[] safe = new int[5];//安全序列
        for (int i = 0; i < 3; i++) {//设置工作向量
            Work[i] = Available[i];
        }
        boolean flag = true;
        while (count < 5) {
            if (flag) {
                System.out.println("进程" + "   Work  " + "     Need " + "     Allocation  " + "Work+Allocation ");
                System.out.println("   " + " A   B  C " + "   A   B  C " + "   A   B  C   " + " A   B  C       ");
                flag = false;
            }
            for (int i = 0; i < 5; i++) {

                if (finish[i] == false && Need[i][0] <= Work[0] && Need[i][1] <= Work[1] && Need[i][2] <= Work[2]) {//判断条件
                    System.out.print("P" + i + "  ");
                    for (int k = 0; k < 3; k++) {
                        System.out.print(Work[k] + "  ");
                    }
                    System.out.print("|  ");
                    for (int j = 0; j < 3; j++) {
                        System.out.print(Need[i][j] + "  ");
                    }

                    System.out.print("|  ");
                    for (int j = 0; j < 3; j++) {
                        Work[j] += Allocation[i][j];
                    }
                    finish[i] = true;//当前进程能满足时
                    safe[count] = i;//设置当前序列排号

                    count++;//满足进程数加1
                    for (int j = 0; j < 3; j++) {
                        System.out.print(Allocation[i][j] + "  ");
                    }

                    System.out.print("|  ");
                    for (int j = 0; j < 3; j++) {
                        System.out.print(Work[j] + "  ");
                    }
                    System.out.println();
                }
            }
            circle++;//循环圈数加1

            if (count == 5) {//判断是否满足所有进程需要
                System.out.print("此时存在一个安全序列：{");
                for (int i = 0; i < 5; i++) {//输出安全序列
                    System.out.print("P" + safe[i] + " ");
                }
                System.out.println("}所以可分配。");
                break;//跳出循环
            }
            if (count < circle) {//判断完成进程数是否小于循环圈数
                count = 5;
                System.out.println("当前系统处于不安全状态，所以不存在安全序列。");
                break;//跳出循环
            }
        }
    }

    public static void main(String[] args) {
        boolean Choose = true;
        String str;
        Scanner in = new Scanner(System.in);
        BankerTest banker = new BankerTest();
        System.out.println("假定有五个进程，初始系统可用三类资源为{10,5,7}的银行家算法：");

        banker.setVariable();
        while (Choose == true) {
            banker.setRequest();
            System.out.println("是否继续请求(y/n):");
            str = in.nextLine();
            if (str.endsWith("n")) {
                Choose = false;
            }
        }
    }
}
