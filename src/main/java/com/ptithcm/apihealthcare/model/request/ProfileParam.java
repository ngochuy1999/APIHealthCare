package com.ptithcm.apihealthcare.model.request;

public class ProfileParam {
    private Integer pid;
    private String name;
    private String avatar ;
    private String cover ;
    private String identityCard;
    private Integer gender;
    private String birthday;
    private String address;
    private Integer active;

    public ProfileParam() {
    }

    public ProfileParam(Integer pid, String name, String avatar, String cover, String identityCard, Integer gender, String birthday, String address, Integer active) {
        this.pid = pid;
        this.name = name;
        this.avatar = avatar;
        this.cover = cover;
        this.identityCard = identityCard;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.active = active;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
