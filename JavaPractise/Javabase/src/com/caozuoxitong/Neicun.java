package com.caozuoxitong;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Classname FF算法
 * @Description TODO
 * @Date 19-10-29 下午4:53
 * @Created by xns
 */
class Block {
    Integer id;
    /**
     * 存储区域长度
     */
    Integer length;
    /***
     * 开始位置
     */
    Integer start;
    Integer end;
    /**
     * 对于内存是否分配,对于进程是否分配编号
     */
    Integer status;

    public Block(Integer id, Integer length, Integer start, Integer end, Integer status) {
        this.id = id;
        this.length = length;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

public class Neicun {

    public static LinkedList<Block> memory;

    public static LinkedList<Block> process;

    static Scanner in = new Scanner(System.in);

    public static void pushProcess(int n, Integer flag, int start0, int length0) {
        int j = 1;
        if (flag != -1) {
            Block proc = new Block(n, length0, start0, start0 + length0, flag);
            process.add(proc);
        } else {
            Block proc = new Block(n, length0, start0, 0, flag);
            process.add(proc);
        }
    }

    public static void printMemory() {
        memory.forEach(item -> {
            if (item.getStatus() == 0) {
                System.out.println("区号  起始地址  长度  结束地址  ");
                System.out.println(item.getId() + "     " + item.getStart() + "      " + item.getLength() + "       " + item.getEnd());
            }
        });
    }


    public static void printProcess() {
        System.out.println("进程编号 分配分区编号  起始位置  长度   终止位置");
        process.forEach(item -> {
            System.out.println(item.getId() + "       " + item.getStatus() + "         " + item.getStart() + "        " + item.getLength() + "        " + item.getEnd());
        });
    }

    public static void Allocation(int num, int size) {
        int biao = 0;
        for (int i = 0; i < memory.size(); i++) {
            if (memory.get(i).getStatus() == 0 && memory.get(i).getLength() > size) {
                biao = 1;
                pushProcess(num, memory.get(i).getId(), memory.get(i).getStart(), size);
                if (memory.get(i).getStatus() == 0) {
                    memory.get(i).setStatus(0);
                    memory.get(i).setStart(memory.get(i).getStart() + size);
                    memory.get(i).setLength(memory.get(i).getLength() - size);
                }
                System.out.println("分配成功,所分配分区为" + memory.get(i).getId());
                break;
            }
        }
        if (biao == 0) {
            System.out.println("无可用空闲区，无法分配，请等待");
            pushProcess(num, -1, 0, size);
        }
    }

    public static void recycle(int num) {
        int t = 0, f = 0;
        for (int i = 0; i < process.size(); i++) {
            if (process.get(i).getId() == num) {
                t = i;
            }
        }
        for (int i = 0; i < memory.size(); i++) {
            if (memory.get(i).getId().equals(process.get(t).getStatus())) {
                f = i;
            }
        }
        if (memory.get(f).getEnd().equals(memory.get(f + 1).getStart())) {
            memory.get(f).setEnd(memory.get(f + 1).getEnd());
            memory.get(f).setLength(memory.get(f).getLength() + memory.get(f + 1).getLength());
            memory.get(f).setStatus(0);
            memory.remove(f + 1);
        } else if (f - 1 > 0) {
            Block h = memory.get(f - 1);
            Block p = memory.get(f);
            if (h.getStatus() == 1) {
                Block block = new Block(h.getId() + 1, process.get(t).getLength(), h.getEnd(), h.getEnd() + p.getLength(), 0);
                memory.add(f, block);
            } else {
                memory.get(f - 1).setEnd(p.getEnd());
                memory.get(f - 1).setLength(h.getLength() + p.getLength());
                memory.get(f - 1).setStatus(0);
                memory.remove(f);
            }
        } else {
            Block block = new Block(0, process.get(t).getLength(), 0, memory.get(f + 1).getStart(), 0);
            memory.add(f, block);
        }
        process.remove(t);
    }

    /**
     * 初始化
     *
     * @return
     */
    public static void initMemory() {
        int all,rest;
        int n, i, choose = 0;
        memory = new LinkedList<>();
        int start0 = 0, length0=0;
        System.out.println("请输入memory大小:");
        all = in.nextInt();
        System.out.println("请输入要分成区块数量:");
        n = in.nextInt();
        System.out.println("请选择划分区方法 1:等分  2:手动分配");
        choose = in.nextInt();
        switch (choose) {
            case 1:
                for (i = 0; i < n; i++) {
                    Block block = new Block(i, all/n, i*(all/n),i*(all/n)+ all/n, 0);
                    memory.add(block);
                }
                break;
            case 2:
                rest=all;
                int start = 0;
                for (i = 0; i < n-1; i++) {
                    System.out.println("起始地址"+start+",请输入第"+i+"块空闲分区大小:");
                    start0 = start;
                    length0 = in.nextInt();
                    Block block = new Block(i, length0, start0, start0 + length0, 0);
                    memory.add(block);
                    start+=length0;
                    all-=length0;
                }
                System.out.print("起始地址"+start+",请输入第"+i+"块空闲分区大小为:"+rest);
                Block block = new Block(i, rest,start0 , start0 + length0, 0);
                memory.add(block);
                break;
            default:
                System.out.println("请输入正确选择!");
                break;
        }
    }


    public static void main(String[] args) {
        int count, m = 0;
        String flag = "f";
        process = new LinkedList<>();
        int size, num;
        System.out.println("------------动态分区分配算法FF------------");
        initMemory();
        System.out.println("--------------空闲分区---------------");
        printMemory();
        while (!flag.equals("q")) {
            if (flag.equals("f")) {
                m++;
                System.out.println("请输入进程" + m + "所需要空间的大小");
                size = in.nextInt();
                Allocation(m, size);
            } else if (flag.equals("s")) {
                System.out.println("请输入要释放进程的编号");
                num = in.nextInt();
                recycle(num);
            }
            System.out.println("--------------空闲分区---------------");
            printMemory();
            System.out.println("--------------进程表---------------");
            printProcess();
            System.out.println("请选择 f:内存分配   s:回收内存   q:退出当前操作");
            flag = in.nextLine();
        }
    }
}
