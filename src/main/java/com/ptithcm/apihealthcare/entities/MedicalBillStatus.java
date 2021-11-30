package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Table(name = "MedicalBillStatus")
@Entity
public class MedicalBillStatus {
    @Id
    @Column(name = "statusId",unique = true,nullable = false)
    private Integer statusId;

    @Column(name = "statusName",nullable = false)
    private String statusName;

    @Column(name = "description",nullable = false)
    private String description;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MedicalBill> getMedicalBills() {
        return medicalBills;
    }

    public void setMedicalBills(List<MedicalBill> medicalBills) {
        this.medicalBills = medicalBills;
    }

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "medicalBillStatus", fetch = FetchType.LAZY)
    private List<MedicalBill> medicalBills;
}
