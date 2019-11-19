package com.bianyiyuanli.suanfuyouxian;

import java.util.*;

/**
 * @Classname analyze
 * @Description TODO
 * @Date 19-11-19 下午4:51
 * @Created by xns
 */
public class analyze {
    private static Map<Character, Set<Character>> firstVt = new HashMap<>();
    private static Map<Character, Set<Character>> lastVt = new HashMap<>();
    private static List<String> input = new ArrayList<>();

    private static Scanner in = new Scanner(System.in);


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
                if(i==str.length()-1||(i==str.length()-2&&str.charAt(i+1)>=65&&str.charAt(i+1)<=90&&str.charAt(i)!='|'&&(str.charAt(i)!='>'&&str.charAt(i)!='-'))){
                    lvt.add(str.charAt(i));
                }
                if(i<str.length()-2){
                    if(str.charAt(i + 1) == '|'||(str.charAt(i+2)=='|'&&str.charAt(i+1)>=65&&str.charAt(i+1)<=90)){
                        lvt.add(str.charAt(i));
                    }
                }
            }
            else{
                if(i==str.length()-1){
                    if (str.charAt(i) == str.charAt(0)) {
                        continue;
                    }
                    getLastVT(str.charAt(i), lvt);
                }else if(str.charAt(i+1) == '|'){
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
     * 判断其是不是算符文法
     *
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
        DisplayFirstVT_LastVT();
    }
}
