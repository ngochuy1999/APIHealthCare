package com.ptithcm.apihealthcare.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class FavoriteDoctorKey implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PID",referencedColumnName = "PID")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorId",referencedColumnName = "doctorId")
    private Doctor doctor;
}
