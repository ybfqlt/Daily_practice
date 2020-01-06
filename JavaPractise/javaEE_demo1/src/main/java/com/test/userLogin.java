package com.test;

/**
 * @Author: xns
 * @Date: 20-1-6 下午5:28
 */
public class userLogin {
    private String userName;

    private String password;

    private String email;

    public userLogin(String userName, String password, String email) {
        this.userName = "李萍";
        this.password = "123";
        this.email = "aaaqa@dsdsd.com" ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
