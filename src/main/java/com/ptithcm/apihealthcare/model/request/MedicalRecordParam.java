package com.ptithcm.apihealthcare.model.request;

public class MedicalRecordParam {
    private String diagnostic;
    private String drugAllergy;
    private Integer medicalBillId;

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getDrugAllergy() {
        return drugAllergy;
    }

    public void setDrugAllergy(String drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    public Integer getMedicalBillId() {
        return medicalBillId;
    }

    public void setMedicalBillId(Integer medicalBillId) {
        this.medicalBillId = medicalBillId;
    }
}
