package com.ptithcm.apihealthcare.model.request;

public class TestResultParam {

    private Integer doctorId;

    private Integer testFormId;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getTestFormId() {
        return testFormId;
    }

    public void setTestFormId(Integer testFormId) {
        this.testFormId = testFormId;
    }
}
