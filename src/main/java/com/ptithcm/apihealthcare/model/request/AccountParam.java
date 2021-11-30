package com.ptithcm.apihealthcare.model.request;

public class AccountParam {

    private String phone;

    private String email;

    private String password;

    private String userName;

    private String token;

    private Integer active;

    public AccountParam() {
    }

    public AccountParam(String phone, String email, String password, String userName, Integer active) {
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.active = active;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
