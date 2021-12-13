package com.ptithcm.apihealthcare.model.reponse;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptithcm.apihealthcare.entities.Account;
import com.ptithcm.apihealthcare.entities.TestFormDetail;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestFormResponse {

    @JsonProperty("diagnostic")
    private String diagnostic;
    @JsonProperty("id")
    private int id;
    @JsonProperty("isPay")
    private int isPay;
    @JsonProperty("testFormDetail")
    private List<TestFormDetail> testFormDetail;

    // A default constructor is required for serialization/deserialization to work


    public TestFormResponse() {
    }



    public TestFormResponse(String diagnostic, int id, int isPay, List<TestFormDetail> testFormDetail) {
        this.diagnostic = diagnostic;
        this.id = id;
        this.isPay = isPay;
        this.testFormDetail = testFormDetail;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }

    public List<TestFormDetail> getTestFormDetail() {
        return testFormDetail;
    }

    public void setTestFormDetail(List<TestFormDetail> testFormDetail) {
        this.testFormDetail = testFormDetail;
    }
// Getters and Setters ....
}
