package com.ptithcm.apihealthcare.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Medicine")
@Entity
@Getter
@Setter
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicineId", unique = true, nullable = false)
    private Integer medicineId;

    @Column(name = "medicineName", nullable = false)
    private String medicineName;

    @Column(name = "dosage", nullable = false)
    private String dosage;

    @Column(name = "uses", nullable = false)
    private String uses;
}
