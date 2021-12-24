package com.ptithcm.apihealthcare.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PrescriptionKey implements Serializable {

    @Column(name = "treatmentId",nullable = false)
    private Integer treatmentId;

    @Column(name = "medicineId",nullable = false)
    private Integer medicineId;

}
