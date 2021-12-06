package com.ptithcm.apihealthcare.model.request;

import java.util.Date;
import java.util.List;

public class SubclinicalParam {
    private String diagnostic;
    private Integer medicalBillId;
    private List<SubclinicalInTest> listSubclinicalInTests;

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Integer getMedicalBillId() {
        return medicalBillId;
    }

    public void setMedicalBillId(Integer medicalBillId) {
        this.medicalBillId = medicalBillId;
    }

    public List<SubclinicalInTest> getListSubclinicalInTests() {
        return listSubclinicalInTests;
    }

    public void setListSubclinicalInTests(List<SubclinicalInTest> listSubclinicalInTests) {
        this.listSubclinicalInTests = listSubclinicalInTests;
    }
}
