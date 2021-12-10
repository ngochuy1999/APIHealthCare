package com.ptithcm.apihealthcare.model.request;


public class TestFormParam {


    private String diagnostic;

    private Integer medicalBillId;


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
}
