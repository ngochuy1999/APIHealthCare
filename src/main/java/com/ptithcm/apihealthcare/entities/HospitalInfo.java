package com.ptithcm.apihealthcare.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "HospitalInfo")
@Entity
@Getter
@Setter
public class HospitalInfo {

    @Id
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name",nullable = false)
    private String email;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "addressDetail",nullable = false)
    private String addressDetail;

    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "versionApp",nullable = false)
    private String versionApp;
}
