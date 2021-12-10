package com.ptithcm.apihealthcare.model.request;

public class TestResultParam {

    private String imageUrl;

    private String fileUrl;

    private Integer doctorId;

    private String conclude;

    private Integer testFormId;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getConclude() {
        return conclude;
    }

    public void setConclude(String conclude) {
        this.conclude = conclude;
    }

    public Integer getTestFormId() {
        return testFormId;
    }

    public void setTestFormId(Integer testFormId) {
        this.testFormId = testFormId;
    }
}
