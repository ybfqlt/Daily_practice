package com.bianyiyuanli;

/**
 * @Classname ce
 * @Description TODO
 * @Date 19-10-10 下午8:13
 * @Created by xns
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ce {

    static String[] rwtab=new String[]{"main","if","then","while","do","static",
            "int","double","struct","break","else",
            "long","switch","case","typedef","char",
            "return","const","float","short","continue",
            "for","void","sizeof"};   //已经定义的24个关键字，种别码从1开始
    static String storage="";   //存储源程序字符串
    static StringBuilder token=new StringBuilder("");     //存储单词自身组成的字符串

    static char ch;
    static int index;
    static int syn, sum=0, row;

    //分析器
    static void analyzer(){
        token.delete(0, token.length());                //置空token对象，清除
        ch=storage.charAt(index++);
        while(ch==' '){
            ch=storage.charAt(index++);      //去除空格符号
        }

        if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){         //可能是关键字或者自定义的标识符
            while((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
                token.append(ch);
                ch=storage.charAt(index++);
            }
            index--;      //此次识别的最后一个字符未识别入，需要将标记退原处
            syn=25;       //默认为识别出的字符串为自定义的标识符，种别码为25
            String s=token.toString();
            for(int i=0; i<rwtab.length; i++){
                if(s.equals(rwtab[i])){
                    syn=i+1;
                    break;        //识别出是关键字
                }
            }
        }
        else if((ch>='0'&&ch<='9')){
            sum=0;
            while((ch>='0'&&ch<='9')){
                sum=sum*10+ch-'0';
                ch=storage.charAt(index++);
            }
            index--;
            syn=26;
        }
        else {
            switch(ch){

                    case '<':
                        token.append(ch);
                        ch=storage.charAt(index++);
                        if(ch=='='){
                            token.append(ch);
                            syn=35;
                        }
                        else if(ch=='>'){
                            token.append(ch);
                            syn=34;
                        }
                        else{
                            syn=33;
                            index--;
                        }
                        break;
                    case '>':
                        token.append(ch);
                        ch=storage.charAt(index++);
                        if(ch=='='){
                            token.append(ch);
                            syn=37;
                        }
                        else{
                            syn=36;
                            index--;
                        }
                        break;
                    case '*':
                        token.append(ch);
                        ch=storage.charAt(index++);
                        if(ch=='*'){
                            token.append(ch);
                            syn=31;
                        }
                        else{
                            syn=13;
                            index--;
                        }
                        break;
                    case '=':
                        token.append(ch);
                        ch=storage.charAt(index++);
                        if(ch=='='){
                            syn=32;
                            token.append(ch);
                        }
                        else{
                            syn=38;
                            index--;
                        }
                        break;
                    case '/':
                        token.append(ch);
                        ch=storage.charAt(index++);
                        if(ch=='/'){
                            while(ch!=' '){
                                ch=storage.charAt(index++);  //忽略掉注释，以空格为界定
                            }
                            syn=-2;
                            break;
                        }
                        else{
                            syn=30;
                            index--;
                        }
                        break;
                    case '+':
                        syn=27;
                        token.append(ch);
                        break;
                    case '-':
                        syn=28;
                        token.append(ch);
                        break;
                    case ';':
                        syn=41;
                        token.append(ch);
                        break;
                    case '(':
                        syn=42;
                        token.append(ch);
                        break;
                    case ')':
                        syn=43;
                        token.append(ch);
                        break;
                    case '#':
                        syn=0;
                        token.append(ch);
                        break;
                    case '\n':
                        syn=-2;
                        token.append(ch);
                        break;
                    default:
                        syn=-1;
                }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        index=0;
        row=1;
        String tempString;
        System.out.println("请输入C语言源程序字符串（以#结尾）：");

        //输入过程
        try{
            do{
                tempString=stdin.readLine();
                storage+=tempString;
                ch=tempString.charAt(tempString.length()-1);  //得到一行中最后一个字符
            }while(ch!='#');        //输入以#字符结尾
        }catch(IOException e){
            e.printStackTrace();
        }

        index=0;
        //输出过程
        do{
            analyzer();
            switch(syn){
                case 26:
                    System.out.println("("+syn+","+sum+")");
                    break;
                case -1:
                    System.out.println("Error in row"+row+"!");
                    break;
                case -2:
                    break;
                default:
                    System.out.println("("+syn+","+token+")");
            }
        }while(syn!=0);
    }

}

