package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Table(name = "MedicalObject")
@Entity
public class MedicalObject {
    @Id
    @Column(name = "id",unique = true,nullable = false)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "active")
    private Integer active;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "medicalObject", fetch = FetchType.LAZY)
    private List<MedicalBill> medicalBills;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public List<MedicalBill> getMedicalBills() {
        return medicalBills;
    }

    public void setMedicalBills(List<MedicalBill> medicalBills) {
        this.medicalBills = medicalBills;
    }
}
