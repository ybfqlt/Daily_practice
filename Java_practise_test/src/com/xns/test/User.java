package com.xns.test;

/**
 * @Classname User
 * @Description TODO
 * @Date 19-12-9 下午8:35
 * @Created by xns
 */
public class User extends Person{
    public String name;
    private int age;

    public User(String name,int age){
        super();
        this.name = name;
        this.age = age;
    }

    private User(int age){
        super();
        this.age = age;
    }

    public User(String name){
        super();
        this.name = name;
    }

    public User(){
        super();
    }

    @Override
    public String toString(){
        return "User [name=" +name+",age="+age+"]";
    }

    public void exit(){
        System.out.println(name+"退出系统");
    }

    public void login(String username,String password){
        System.out.println("用户名:"+username);
        System.out.println("密码:"+password);
    }

    private String CheckInfo(){
        return "年龄:"+age;
    }
}
