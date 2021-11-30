package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Table(name = "MedicalRecord")
@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordId",unique = true,nullable = false)
    private Integer recordId;

    @Column(name = "diagnostic",nullable = false)
    private String diagnostic;

    @Column(name = "drugAllergy",nullable = false)
    private String drugAllergy;

    @Column(name = "active",nullable = false)
    private Integer active;

    @ManyToOne(optional = false)
    @JoinColumn(name = "billId")
    private MedicalBill medicalBill;

    @OneToOne(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TreatmentRegimen treatmentRegimen;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

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
}
