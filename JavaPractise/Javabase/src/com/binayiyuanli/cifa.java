package com.binayiyuanli;


import java.io.*;
import java.util.Scanner;

/**
 * @Classname cifa
 * @Description TODO
 * @Date 19-10-10 下午7:32
 * @Created by xns
 */
public class cifa {
    private String keyWord[] = {"auto","break","case","char","const","continue","default",
            "do","double","else","enum","float","for","goto","if","int","long","register","return","short",
            "signed","sizeof","static","struct", "switch","typedef","union","unsigned","void","volatile","while"};;
    private char ch;

    private String format[]={"％d","％o","％x","％u","％c","％s","％f","％e","％g"};

    /**
     * 判断是否是关键字
     * @param str
     * @return
     */
    boolean isKey(String str)
    {
        for(int i = 0;i < keyWord.length;i++)
        {
            if(keyWord[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是字母
     * @param ch
     * @return
     */
    boolean isLetter(char ch)
    {
        if((ch >= 'a' && ch <= 'z')||(ch >= 'A' && ch <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否是数字
     * @param num
     * @return
     */
    boolean isDigit(char num)
    {
        if(num >= '0' && num <= '9') {
            return true;
        } else {
            return false;
        }
    }

    void filter(char[] str) {
        String buf = "";
        int count = 0;
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
            buf = buf + str[i];
        }
    }

    /**
     * 词法分析
     * @param str
     */
    void analyze(char[] str)
    {
        String arr = "";
        for(int i = 0;i< str.length;i++) {
            ch = str[i];
            arr = "";
            if(ch == ' '||ch == '\t'||ch == '\n'||ch == '\r'){}
            else if(isLetter(ch)){
                while(isLetter(ch)||isDigit(ch)){
                    arr += ch;
                    ch = str[++i];
                }
                //回退一个字符
                i--;
                if(isKey(arr)){
                    //关键字
                    System.out.println("<"+arr+" ,"+"  关键字>");
                }
                else{
                    //标识符
                    System.out.println("<"+arr+" ,"+"  标识符>");
                }
            }
            else if(isDigit(ch)||(ch == '.'))
            {
                while(isDigit(ch)||(ch == '.'&&isDigit(str[++i])))
                {
                    if(ch == '.') {
                        i--;
                    }
                    arr = arr + ch;
                    ch = str[++i];
                }
                //属于无符号常数
                System.out.println("<"+arr+" ,"+"  常数>");
            }
            else {
                switch(ch){
                        /**
                        * 运算符
                        */
                        case '%':
                            String temp1="";
                            int t=i;
                            char c = str[t++];
                            while(c!=')'){
                                temp1+=c;
                                c = str[t++];
                            }
                            if(temp1.contains("\"")){
                                String temp2 = ""+ch+str[++i];
                                System.out.println("<"+temp2+" ,"+" 格式表明符>");
                            }
                            else{
                                System.out.println("<"+ch+" ,"+"  运算符>");
                            }
                            break;
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                            String temp;
                            temp=""+ch;
                            ch=str[++i];
                            if(ch == '=') {
                                temp=temp+ch;
                            } else {
                                ch = str[--i];
                                System.out.println("<"+ch+" ,"+"  运算符>");
                            }
                            System.out.println("<"+temp+" ,"+"  运算符>");break;
                        /**
                        * 分界符
                        */
                        case ',':
                        case '"':
                        case '#':
                        case '(':
                        case ')':
                        case '[':
                        case ']':
                        case ';':
                        case '{':
                        case '}':System.out.println("<"+ch+" ,"+"  界符>");break;
                        /**
                        * 运算符
                        */
                        case '=':{
                            ch = str[++i];
                            if(ch == '=') {
                                System.out.println("<=="+" ,"+"  运算符>");
                            } else {
                                System.out.println("<"+"="+" ,"+"  运算符>");
                                i--;
                            }
                        }break;
                        case ':':{
                            ch = str[++i];
                            if(ch == '=') {
                                System.out.println("<"+":="+" ,"+"  运算符>");
                            } else {
                                System.out.println("<"+":"+" ,"+"  运算符>");
                                i--;
                            }
                        }break;
                        case '>':{
                            ch = str[++i];
                            if(ch == '=') {
                                System.out.println("<"+">="+" ,"+"  运算符>");
                            } else {
                                System.out.println("<"+">"+" ,"+"  运算符>");
                                i--;
                            }
                        }break;
                        case '<':{
                            ch = str[++i];
                            if(ch == '=') {
                                System.out.println("<"+"<="+" ,"+"  运算符>");
                            } else {
                                System.out.println("<"+"<"+" ,"+"  运算符>");
                                i--;
                            }
                        }break;
                        /**
                        * 无识别
                        */
                        default: System.out.println("<"+ch+" ,"+"  无识别符>");
                    }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入文件名称:");
        String strFile = in.next();
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
            char buf[] = new char[length+1];
            reader.read(buf);
            reader.close();
            new cifa().analyze(buf);
        }catch (FileNotFoundException e){
            System.out.println("没有那个文件或目录!");
        }finally {

        }
    }
}
