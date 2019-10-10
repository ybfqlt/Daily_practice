package com.binayiyuanli;


import java.io.*;

/**
 * @Classname cifa
 * @Description TODO
 * @Date 19-10-10 下午7:32
 * @Created by xns
 */
public class cifa {
    private String keyWord[] = {"auto","break","case","char","const","continue","default","do","double","else","enum","float","for","goto","if","int","long","register","return","short","signed","sizeof","static","struct", "switch","typedef","union","unsigned","void","volatile","while"};;
    private char ch;

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
                    System.out.println(arr+"\t4"+"\t关键字");
                }
                else{
                    //标识符
                    System.out.println(arr+"\t4"+"\t标识符");
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
                System.out.println(arr+"\t5"+"\t常数");
            }
            else {
                switch(ch){
                        /**
                        * 运算符
                        */
                        case '+':System.out.println(ch+"\t2"+"\t运算符");break;
                        case '-':System.out.println(ch+"\t2"+"\t运算符");break;
                        case '*':System.out.println(ch+"\t2"+"\t运算符");break;
                        case '/':System.out.println(ch+"\t2"+"\t运算符");break;
                        /**
                        * 分界符
                        */
                        case '#':System.out.println(ch+"\t3"+"\t界符");break;
                        case '(':System.out.println(ch+"\t3"+"\t界符");break;
                        case ')':System.out.println(ch+"\t3"+"\t界符");break;
                        case '[':System.out.println(ch+"\t3"+"\t界符");break;
                        case ']':System.out.println(ch+"\t3"+"\t界符");break;
                        case ';':System.out.println(ch+"\t3"+"\t界符");break;
                        case '{':System.out.println(ch+"\t3"+"\t界符");break;
                        case '}':System.out.println(ch+"\t3"+"\t界符");break;
                        /**
                        * 运算符
                        */
                        case '=':{
                            ch = str[++i];
                            if(ch == '=') {
                                System.out.println("=="+"\t2"+"\t运算符");
                            } else {
                                System.out.println("="+"\t2"+"\t运算符");
                                i--;
                            }
                        }break;
                        case ':':{
                            ch = str[++i];
                            if(ch == '=') {
                                System.out.println("="+"\t2"+"\t运算符");
                            } else {
                                System.out.println("(:"+"\t2"+"\t运算符");
                                i--;
                            }
                        }break;
                        case '>':{
                            ch = str[++i];
                            if(ch == '=') {
                                System.out.println("("+ch+","+"\t运算符");
                            } else {
                                System.out.println("("+ch+","+"\t运算符");
                                i--;
                            }
                        }break;
                        case '<':{
                            ch = str[++i];
                            if(ch == '=') {
                                System.out.println("("+ch+","+"\t运算符)");
                            } else {
                                System.out.println("("+ch+","+"\t运算符)");
                                i--;
                            }
                        }break;
                        /**
                        * 无识别
                        */
                        default: System.out.println("("+ch+","+"\t无识别符");
                    }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        /**
         * 定义一个file对象，用来初始化FileReader
         */
        File file = new File("/home/ltt/IdeaProjects/JavaPractise/Javabase/src/com/binayiyuanli/s.txt");
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

    }
}
