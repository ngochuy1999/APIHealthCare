package com.ptithcm.apihealthcare.model.reponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptithcm.apihealthcare.entities.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestResultReponse {

    @JsonProperty("resultId")
    private Integer resultId;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("active")
    private Integer active;

    @JsonProperty("doctor")
    private Doctor doctor;

    @JsonProperty("testForm")
    private TestForm testForm;

    @JsonProperty("testResultDetail")
    private List<TestResultDetail> testResultDetails;


    public TestResultReponse() {
    }

    public TestResultReponse(Integer resultId, Date date, Integer active, Doctor doctor, TestForm testForm, List<TestResultDetail> testResultDetails) {
        this.resultId = resultId;
        this.date = date;
        this.active = active;
        this.doctor = doctor;
        this.testForm = testForm;
        this.testResultDetails = testResultDetails;
    }
}
