package com.bianyiyuanli;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname cifa
 * @Description TODO
 * @Date 19-10-10 下午7:32
 * @Created by xns
 */
public class cifa {
    private String keyWord[] = {"标识符","常数","auto", "break", "case", "char", "const", "continue", "default",
            "do", "double", "else", "enum", "float", "for", "goto", "if", "int", "long", "register", "return", "short",
            "signed", "sizeof", "static", "struct","switch", "typedef", "union", "unsigned", "void", "volatile", "while",
            ",",".",":",";","'","'","#",">","<","]","[","{","}","*","%","=","|","&","~","!","?","\"",
            "||","&&","++","--","/","(",")","+=","-=","*=","/*"};


    private char ch;

    private Integer biao = 1;

    private Integer chang = 1;

    private int flag = 2;

    /**
     * 判断是否是关键字或者界符和算符，并且返回 种别码
     *
     * @param str
     * @return
     */
    int isKey(String str) {
        for (int i = 0; i < keyWord.length; i++) {
            if (keyWord[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    void printTable() {
        System.out.println("=============单词分类表===============");
        System.out.printf("%-10s%8s\n", "单词符号", "种别编码");
        for (int i = 0; i < keyWord.length; i++) {
            System.out.printf("%-10s%8d\n", keyWord[i], i);
        }
    }


    /**
     * 判断是否是字母
     *
     * @param ch
     * @return
     */
    boolean isLetter(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否是数字
     *
     * @param num
     * @return
     */
    boolean isDigit(char num) {
        if (num >= '0' && num <= '9') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 预处理，处理注释
     * @param str
     * @return
     */
    String filter(char[] str) {
        System.out.println("预处理前代码为:");
        System.out.println(str);
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '/' && str[i + 1] == '/') {
                while (str[i] != '\n') {
                    i++;
                }
            }
            if (str[i] == '/' && str[i + 1] == '*') {
                i += 2;
                while (str[i] != '*' || str[i + 1] != '/') {
                    i++;
                    if (i == str.length) {
                        System.out.println("注释出错，不能正确分析!");
                        System.exit(0);
                    }
                }
                i += 2;
            }
            buf.append(str[i]);
        }
        System.out.println("预处理之后:");
        System.out.println(buf.toString());
        return buf.toString();
    }

    /**
     * 词法分析
     *
     * @param str
     */
    void analyze(char[] str) {
//        printTable();
        String buf = filter(str);
        char[] str1=buf.toCharArray();
        int flag;
        String arr = "";
        for (int i = 0; i < str.length; i++) {
            ch = str[i];
            arr = "";
            if (ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r') {
            } else if (isLetter(ch)) {
                while (isLetter(ch) || isDigit(ch)) {
                    arr += ch;
                    ch = str[++i];
                }
                //回退一个字符
                i--;
                if ((flag = isKey(arr))!=-1) {
                    //关键字或者界符或者运算符或者逻辑运算符
                    System.out.printf("%-10s[%-5d%5s]\n", arr, flag, "null");
                } else {
                    //标识符
                    System.out.printf("%-10s[%-5d%5d]\n", arr, 0, biao++);
                }
            } else if (isDigit(ch) || (ch == '.')) {
                while (isDigit(ch) || (ch == '.' && isDigit(str[++i]))) {
                    if (ch == '.') {
                        i--;
                    }
                    arr = arr + ch;
                    ch = str[++i];
                }
                //属于无符号常数
                System.out.printf("%-10s[%-5d%5d]\n", arr, 1, chang++);
            } else {
                arr+=ch;
                if((flag=isKey(arr))!=-1){
                    System.out.printf("%-10s[%-5d%5s]\n", arr, flag,"null");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入文件名称:");
        String strFile = in.next();
        cifa a = new cifa();
        /**
         * 定义一个file对象，用来初始化FileReader
         */
        try {
            File file = new File(strFile);
            /**
             * 定义一个fileReader对象，用来初始化BufferedReader
             */
            FileReader reader = new FileReader(file);
            int length = (int) file.length();
            /**
             * 这里定义字符数组的时候需要多定义一个,因为词法分析器会遇到超前读取一个字符的时候，如果是最后一个
             * 字符被读取，如果在读取下一个字符就会出现越界的异常
             */
            char[] buf = new char[length];
            reader.read(buf);
            reader.close();
            a.analyze(buf);
        } catch (FileNotFoundException e) {
            System.out.println("没有那个文件或目录!");
        }
    }
}
