package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.beans.BeanInfo;
import java.util.List;

@Table(name = "TestForm")
@Entity
public class TestForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testFormId",unique = true,nullable = false)
    private Integer id;

    @Column(name = "isPay",nullable = false)
    private Integer isPay;

    @Column(name = "diagnostic",nullable = false)
    private String diagnostic;

    @Column(name = "active")
    private Integer active;

    @ManyToOne(optional = false)
    @JoinColumn(name = "billId")
    private MedicalBill medicalBill;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "testForm", fetch = FetchType.LAZY)
    private List<TestResult> testResults;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "testForm")
    List<TestFormDetail> testFormDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public MedicalBill getMedicalBill() {
        return medicalBill;
    }

    public void setMedicalBill(MedicalBill medicalBill) {
        this.medicalBill = medicalBill;
    }

    public List<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }
}
