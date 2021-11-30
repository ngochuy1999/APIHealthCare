package com.ptithcm.apihealthcare.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TestResult")
public class TestResult {
    @Id
    @Column(name = "resultId",unique = true,nullable = false)
    private Integer resultId;

    @Column(name = "conclude",nullable = false)
    private String conclude;

    @Column(name = "imageUrl",nullable = false)
    private String imageUrl;

    @Column(name = "fileUrl",nullable = false)
    private String fileUrl;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date")
    private Date date;

    @Column(name = "active")
    private Integer active;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "testFormId")
    private TestForm testForm;

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public String getConclude() {
        return conclude;
    }

    public void setConclude(String conclude) {
        this.conclude = conclude;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public TestForm getTestForm() {
        return testForm;
    }

    public void setTestForm(TestForm testForm) {
        this.testForm = testForm;
    }
}
