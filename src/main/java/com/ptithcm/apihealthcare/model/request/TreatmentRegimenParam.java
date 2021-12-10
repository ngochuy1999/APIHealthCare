package com.ptithcm.apihealthcare.model.request;

import java.util.Date;
import java.util.List;

public class TreatmentRegimenParam {

    private Integer medicalBillId;

    private String diagnostic;

    private Date dateBegin;

    private Date dateEnd;

    private String needs;

    private String prohibited;

    private Date reExaminationDate;

    private List<PrescriptionParam> prescriptionParamList;

    public Integer getMedicalBillId() {
        return medicalBillId;
    }

    public void setMedicalBillId(Integer medicalBillId) {
        this.medicalBillId = medicalBillId;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public List<PrescriptionParam> getPrescriptionParamList() {
        return prescriptionParamList;
    }

    public void setPrescriptionParamList(List<PrescriptionParam> prescriptionParamList) {
        this.prescriptionParamList = prescriptionParamList;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public String getProhibited() {
        return prohibited;
    }

    public void setProhibited(String prohibited) {
        this.prohibited = prohibited;
    }

    public Date getReExaminationDate() {
        return reExaminationDate;
    }

    public void setReExaminationDate(Date reExaminationDate) {
        this.reExaminationDate = reExaminationDate;
    }
}
