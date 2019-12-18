package com.bianyiyuanli.suanfuyouxian;

import java.util.*;



/**
 * E->TE'
 * E'->+TE'|ε
 * T->FT'
 * T'->*FT'|ε
 * F->(E)|i
 */

/**
 * E->E+T|T
 * T->T*F|F
 * F->P^F|P
 * P->(E)|i
 */
/**
 * @Classname analyze
 * @Description TODO
 * @Date 19-11-19 下午4:51
 * @Created by xns
 */
public class analyze {

    /**
     * FIRSTVT集合
     */
    private static Map<Character, Set<Character>> firstVt = new HashMap<>();
    /**
     * LASTVT集合
     */
    private static Map<Character, Set<Character>> lastVt = new HashMap<>();
    /**
     * 输入的文法
     */
    private static List<String> input = new ArrayList<>();

    /**
     * 终结符
     */
    private static Set<Character> End = new LinkedHashSet<>();

    /**
     *非终结符
     */
    private static Set<Character> NoEnd = new LinkedHashSet<>();

    /**
     * 算符矩阵
     */
    private static Map<String, Character> matrix = new HashMap<>();

    private static Scanner in = new Scanner(System.in);

    /**
     * 文法的左右分割一一对应
     */
    private static Map<Character, List<String>> produce = new HashMap<>();


    /**
     * 获得firstVt集合
     */
    private static void getFirstVT(Character s, Set<Character> fvt) {
        String str = null;
        int i = 0;
        for (i = 0; i < input.size(); i++) {
            if (input.get(i).charAt(0) == s) {
                str = input.get(i);
            }
        }
        for (i = 3; i < str.length(); i++) {
            if (str.charAt(i) < 65 || str.charAt(i) > 90) {
                if ((str.charAt(i - 1) == '>' && str.charAt(i - 2) == '-') || str.charAt(i - 1) == '|') {
                    fvt.add(str.charAt(i));
                }
                if ((str.charAt(i - 2) == '|' || (str.charAt(i - 2) == '>' && str.charAt(i - 3) == '-')) && str.charAt(i - 1) >= 65 && str.charAt(i - 1) <= 90) {
                    fvt.add(str.charAt(i));
                }
            }
            if (str.charAt(i - 1) == '|' && str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                if (str.charAt(i) == str.charAt(0)) {
                    continue;
                }
                getFirstVT(str.charAt(i), fvt);
            }
        }
    }

    /**
     * 获得lastVt集合
     */
    private static void getLastVT(Character s, Set<Character> lvt) {
        String str = null;
        int i = 0;
        for (i = 0; i < input.size(); i++) {
            if (input.get(i).charAt(0) == s) {
                str = input.get(i);
            }
        }
        for (i = 3; i < str.length(); i++) {
            if (str.charAt(i) < 65 || str.charAt(i) > 90) {
                if (i == str.length() - 1 || (i == str.length() - 2 && str.charAt(i + 1) >= 65 && str.charAt(i + 1) <= 90 && str.charAt(i) != '|' && (str.charAt(i) != '>' && str.charAt(i) != '-'))) {
                    lvt.add(str.charAt(i));
                }
                if (i < str.length() - 2) {
                    if (str.charAt(i + 1) == '|' || (str.charAt(i + 2) == '|' && str.charAt(i + 1) >= 65 && str.charAt(i + 1) <= 90)) {
                        lvt.add(str.charAt(i));
                    }
                }
            } else {
                if (i == str.length() - 1) {
                    if (str.charAt(i) == str.charAt(0)) {
                        continue;
                    }
                    getLastVT(str.charAt(i), lvt);
                } else if (str.charAt(i + 1) == '|') {
                    if (str.charAt(i) == str.charAt(0)) {
                        continue;
                    }
                    getLastVT(str.charAt(i), lvt);
                }
            }
        }
    }

    /**
     * 显示firstVt集合和lastVt集合
     */
    private static void DisplayFirstVT_LastVT() {
        for (int i = 0; i < input.size(); i++) {
            Set<Character> fvt = new HashSet<>();
            getFirstVT(input.get(i).charAt(0), fvt);
            firstVt.put(input.get(i).charAt(0), fvt);
        }
        for (int i = 0; i < input.size(); i++) {
            Set<Character> lvt = new HashSet<>();
            getLastVT(input.get(i).charAt(0), lvt);
            lastVt.put(input.get(i).charAt(0), lvt);
        }
        System.out.println("firstVt集合如下:");
        for (Map.Entry<Character, Set<Character>> entry : firstVt.entrySet()) {
            System.out.print("firstVt(" + entry.getKey() + "): {");
            int flag = 0;
            for (Character value : entry.getValue()) {
                flag++;
                System.out.print(value);
                if (flag != entry.getValue().size()) {
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
        System.out.println("lastVt集合如下:");
        for (Map.Entry<Character, Set<Character>> entry : lastVt.entrySet()) {
            System.out.print("lastVt(" + entry.getKey() + "): {");
            int flag = 0;
            for (Character value : entry.getValue()) {
                flag++;
                System.out.print(value);
                if (flag != entry.getValue().size()) {
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
    }


    /**
     * 获取所有终结符
     */
    private static void getEnd() {
        for (int i = 0; i < input.size(); i++) {
            String temp = input.get(i);
            for (int j = 3; j < temp.length(); j++) {
                if (temp.charAt(j) < 65 || temp.charAt(j) > 90 && temp.charAt(j) != '|') {
                    End.add(temp.charAt(j));
                }
            }
        }
        End.add('#');
    }

    /**
     * 获取所有非终结符
     */
    private static void getNoEnd() {
        for (int i = 0; i < input.size(); i++) {
            String temp = input.get(i);
            for (int j = 3; j < temp.length(); j++) {
                if (temp.charAt(j) >= 65 && temp.charAt(j) <= 90) {
                    NoEnd.add(temp.charAt(j));
                }
            }
        }
    }

    /**
     * 将每一行的文法分离,如E->E+T|T分离成E和E+T,T
     */
    private static void getProduce() {
        for (int i = 0; i < input.size(); i++) {
            List<String> list = new ArrayList<>();
            String str = input.get(i);
            StringBuffer a = new StringBuffer();
            for (int j = 3; j < str.length(); j++) {
                if (str.charAt(j) != '|') {
                    a.append(str.charAt(j));
                } else {
                    list.add(a.toString());
                    //清空a
                    a.delete(0, a.length());
                }
            }
            list.add(a.toString());
            produce.put(str.charAt(0), list);
        }
    }

    /**
     * 错误
     */
    public static void partError() {
        matrix.put(")(", 'b');
        matrix.put("((", 'b');
        matrix.put("(#", 'a');
    }


    /**
     * 构造算符优先矩阵并打印
     *　用Map<String,Character>存,String中存优先变得行值和列值,Character表示String中所存行列的大小关系如"++"表示行为'+',列为'+'的时候,关系为Character中的值
     * @return
     */
    private static void priorityMatrix() {
        for (int i = 0; i < input.size(); i++) {
            String str = input.get(i);
            for (int j = 3; j < input.get(i).length(); j++) {
                if ((str.charAt(j) < 65 || str.charAt(j) > 90) && (str.charAt(j) != '|')) {
                    if (j < str.length() - 1 && (str.charAt(j + 1) < 65 || str.charAt(j + 1) > 90)) {
                        String temp = str.charAt(j) + "" + str.charAt(j + 1);
                        matrix.put(temp, '=');
                    } else {
                        if (j < str.length() - 2 && (str.charAt(j + 2) < 65 || str.charAt(j + 2) > 90) && (str.charAt(j + 2) != '|')) {
                            matrix.put(str.charAt(j) + "" + str.charAt(j + 2), '=');
                        }
                    }
                    if (j < str.length() - 1 && str.charAt(j + 1) >= 65 && str.charAt(j + 1) <= 90) {
                        Set<Character> coll = firstVt.get(str.charAt(j + 1));
                        for (Character value : coll) {
                            matrix.put(str.charAt(j) + "" + value, '<');
                        }
                    }
                    if (j - 1 != 2 && str.charAt(j - 1) >= 65 && str.charAt(j - 1) <= 90) {
                        Set<Character> coll = lastVt.get(str.charAt(j - 1));
                        for (Character value : coll) {
                            matrix.put(value + "" + str.charAt(j), '>');
                        }
                    }
                }
            }
        }
        Set<Character> coll = firstVt.get(input.get(0).charAt(0));
        for (Character value : coll) {
            matrix.put('#' + "" + value, '<');
        }
        Set<Character> coll1 = lastVt.get(input.get(0).charAt(0));
        for (Character value : coll1) {
            matrix.put(value + "" + '#', '>');
        }
        partError();
        for (Character value : End) {
            for (Character value1 : End) {
                if (matrix.get(value + "" + value1) == null) {
                    matrix.put(value + "" + value1, 'b');
                }
            }
        }
        matrix.put("##", '=');

/*        for (Map.Entry<String, Character> entry : matrix.entrySet()) {
            System.out.println(entry.getKey()+"   "+entry.getValue());
        }*/
        getEnd();
        System.out.println("\n构造的算符优先关系表如下:");
        int kong = 0;
        for (Character value : End) {
            if (kong == 0) {
                System.out.print("   ");
            }
            kong++;
            System.out.print(value);
            if (kong != End.size()) {
                System.out.print("  ");
            }
        }
        System.out.println();
        for (Character value : End) {
            System.out.print(value);
            for (Character value1 : End) {
                Character ch = matrix.get(value + "" + value1);
                if (ch != null) {
                    System.out.print("  " + ch);
                } else {
                    System.out.print("  " + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 判断其是不是算符文法
     *如果没有连个连续非终结符号相连的就是算符优先文法
     * @return
     */
    private static boolean isOperator() {
        int i;
        for (i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length() - 1; j++) {
                String str = input.get(i);
                if (str.charAt(j) >= 65 && str.charAt(j) <= 90) {
                    if ((str.charAt(j + 1) >= 65 && str.charAt(j + 1) <= 90)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 判断其是不是终结符
     *
     * @return
     */
    private static boolean isEnd(Character ch) {
        for (Character value : End) {
            if (value.equals(ch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断其是不是非终结符
     *
     * @return
     */
    private static boolean isNoEnd(Character ch) {
        for (Character value : NoEnd) {
            if (value.equals(ch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据产生式右部分返回左边
     *
     * @return
     */
    private static char retLeft(String str) {
        char ch = 0;
        for (Map.Entry<Character, List<String>> map : produce.entrySet()) {
            ch = map.getKey();
            for (String value : map.getValue()) {
                if (value.length() != str.length()) {
                    continue;
                }
                int i;
                for (i = 0; i < str.length(); i++) {

                    if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                        if (value.charAt(i) >= 65 && value.charAt(i) <= 90) {
                        } else {
                            break;
                        }
                    } else {
                        if (value.charAt(i) != str.charAt(i)) {
                            break;
                        }
                    }
                }
                if (i == str.length()) {
                    return ch;
                }
            }
        }
        return 0;
    }

    /**
     * 将字符数组转换成字符串
     * @param list
     * @return
     */
    public static String replaceToString(List<Character> list) {
        StringBuffer a = new StringBuffer();
        for (Character value : list) {
            if (value != ',' && value != '[' && value != ']') {
                a.append(value);
            }
        }
        return a.toString();
    }

    /**
     * 错误处理
     * @param a
     * @param listStack
     * @param str
     * @param i
     */
    public static void error(Character a,List<Character> listStack,String str,int i){
        switch (a){
            case 'a':
                System.out.println("非法左括号!");
                listStack.remove(listStack.size());
                break;
            case 'b':
                System.out.println("缺少运算符!");
                StringBuilder sb = new StringBuilder(str);
                sb.insert(i,'+');
                str = sb.toString();
                break;
            case 'c':
                System.out.println("缺少表达式!");
                break;
            default:
                break;
        }
    }
    /**
     * 算符优先分析过程
     * 使用一个符号栈，用它寄存终结符和非终结符,k代表符号栈的深度
     * 在正常情况下，算法工作完毕时，符号栈S应呈现:#N#
     */
    public static void analysisProcess() {
        int status = 0;
        int count = 0;
        int k = 0;
        int j = 0;
        int step = 0;
        String gui = null;
        System.out.println("请输入要分析的句子(注意:记得以'#'结束)");
        String sentence = null;
        sentence = in.nextLine();
        if (sentence.charAt(sentence.length() - 1) != '#') {
            sentence = sentence + "#";
        }
        List<Character> listStack = new ArrayList<>();
        System.out.printf("%-8s%-20s%-8s%-10s%-8s\n", "步骤", "栈", "a读入", "剩余串", "操作");
        listStack.add('#');
        char a = sentence.charAt(step++);
        do {
            if (status == 0) {
                if (count != 0) {
                    System.out.printf("%-8s\n%-8d %-20s %-8c %-10s", "移进", count, replaceToString(listStack), a, sentence.substring(step));
                } else {
                    System.out.printf("%-8d %-20s %-8c %-10s", count, replaceToString(listStack), a, sentence.substring(step));
                }
            } else {
                System.out.printf("%-8s\n%-8d %-20s %-8c %-10s", gui, count, replaceToString(listStack), a, sentence.substring(step));
            }
            char ch = listStack.get(k);
            if (isEnd(ch)) {
                j = k;
            } else if (j >= 1) {
                j = k - 1;
            }
            char temp = 0;
            if (matrix.get(listStack.get(j) + "" + a) != null) {
                //规约
                while (matrix.get(listStack.get(j) + "" + a).equals('>')) {
                    if (listStack.size() == 2 && a == '#') {
                        break;
                    }
                    StringBuffer judge = new StringBuffer();
                    do {
                        temp = listStack.get(j);
                        if (isEnd(listStack.get(j - 1))) {
                            j = j - 1;
                        } else {
                            j = j - 2;
                        }
                    } while (!matrix.get(listStack.get(j) + "" + temp).equals('<'));
                    for (int i = j + 1; i < listStack.size(); i++) {
                        judge.append(listStack.get(i));
                    }
                    int te = listStack.size();
                    for (int t = j + 1; t < te; t++) {
                        listStack.remove(j + 1);
                    }
                    char res = retLeft(judge.toString());
                    if (res != 0) {
                        count++;
                        k = j + 1;
                        listStack.add(res);
                        status = 1;
                        gui = "用" + res + "->" + judge.toString() + "规约";
                        if (status == 0) {
                            System.out.printf("%-8s\n%-8d %-20s %-8c %-10s", "移进", count, replaceToString(listStack), a, sentence.substring(step));
                        } else {
                            System.out.printf("%-8s\n%-8d %-20s %-8c %-10s", gui, count, replaceToString(listStack), a, sentence.substring(step));
                        }
                    }
                }
            }
            //移进
            if (matrix.get(listStack.get(j) + "" + a).equals('<') || matrix.get(listStack.get(j) + "" + a).equals('=')) {
                count++;
                k++;
                status = 0;
                listStack.add(a);
            }else{
                switch (matrix.get(listStack.get(j) + "" + a)){
                    case 'a':
                        System.out.print("非法左括号! ");
                        listStack.remove(listStack.size());
                        break;
                    case 'b':
                        System.out.print("缺少运算符! ");
                        StringBuilder sb = new StringBuilder(sentence);
                        sb.insert(step-1,'+');
                        --step;
                        sentence = sb.toString();
                        break;
                    case 'c':
                        System.out.print("缺少表达式! ");
                        return;
                    default:
                        break;
                }
//                error(matrix.get(listStack.get(j) + "" + a),listStack,sentence,step);
            }
            if (listStack.size() == 2 && a == '#') {
                break;
            }
            if (step < sentence.length()) {
                a = sentence.charAt(step++);
            } else {
                break;
            }
        } while (listStack.size() != 2 || a != '#');
        System.out.printf("%-8s\n", "分析成功");
    }


    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        int flag = 1;
        String a;
        System.out.println("请输入文法:");
        while (flag != 0) {
            while (!(a = in.nextLine()).equals("")) {
                input.add(a);
            }
            if (isOperator()) {
                System.out.println("此文法是算符文法!");
                flag = 0;
            } else {
                System.out.println("此文法不是算符文法!请重新输入:");
                input.clear();
            }
        }
        getEnd();
        getNoEnd();
        getProduce();
        DisplayFirstVT_LastVT();
        priorityMatrix();
        analysisProcess();
    }
}
