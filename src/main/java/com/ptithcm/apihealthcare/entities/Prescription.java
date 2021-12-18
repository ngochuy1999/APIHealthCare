package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "Prescription")
@Entity
public class Prescription {

    @EmbeddedId
    private PrescriptionKey id;

    @ManyToOne
    @MapsId("treatmentId")
    @JoinColumn(name = "treatmentId")
    private TreatmentRegimen treatmentRegimen;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "dosage",nullable = false)
    private String dosage;

    @Column(name = "active")
    private Integer active;

    public PrescriptionKey getId() {
        return id;
    }

    public void setId(PrescriptionKey id) {
        this.id = id;
    }



    public void setTreatmentRegimen(TreatmentRegimen treatmentRegimen) {
        this.treatmentRegimen = treatmentRegimen;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
    
}
