package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Table(name = "MedicalBill")
@Entity
public class MedicalBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billId",unique = true,nullable = false)
    private Integer billId;

    @Column(name = "waitingTime")
    private Time waitingTime;


    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "date")
    private ZonedDateTime date;

    @Column(name = "examinationFee",nullable = false)
    private float examinationFee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PID")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "objectId")
    private MedicalObject medicalObject;

    @ManyToOne(optional = false)
    @JoinColumn(name = "statusId")
    private MedicalBillStatus medicalBillStatus;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "medicalBill", fetch = FetchType.LAZY)
    private List<TestForm> testForms;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "medicalBill", fetch = FetchType.LAZY)
    private List<MedicalRecord> medicalRecords;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Time getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Time waitingTime) {
        this.waitingTime = waitingTime;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public float getExaminationFee() {
        return examinationFee;
    }

    public void setExaminationFee(float examinationFee) {
        this.examinationFee = examinationFee;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicalObject getMedicalObject() {
        return medicalObject;
    }

    public void setMedicalObject(MedicalObject medicalObject) {
        this.medicalObject = medicalObject;
    }

    public MedicalBillStatus getMedicalBillStatus() {
        return medicalBillStatus;
    }

    public void setMedicalBillStatus(MedicalBillStatus medicalBillStatus) {
        this.medicalBillStatus = medicalBillStatus;
    }

    public List<TestForm> getTestForms() {
        return testForms;
    }

    public void setTestForms(List<TestForm> testForms) {
        this.testForms = testForms;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
