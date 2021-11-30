package com.ptithcm.apihealthcare.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PrescriptionKey implements Serializable {

    @Column(name = "treatmentId",nullable = false)
    private int treatmentId;

    @Column(name = "medicineName",nullable = false)
    private String medicineName;

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
