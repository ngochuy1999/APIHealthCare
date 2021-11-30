package com.ptithcm.apihealthcare.entities;

import javax.persistence.*;

@Table(name = "QRCode")
@Entity
public class QRCode {
    @Id
    @Column(name = "id",unique = true,nullable = false)
    private Integer id;

    @Column(name = "imageUrl",nullable = false)
    private String imageUrl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @Column(name = "active")
    private Integer active;
}
