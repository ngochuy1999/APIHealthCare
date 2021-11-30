package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Table(name = "Doctor")
@Entity
public class Doctor {
    @Id
    @Column(name = "doctorId",unique = true,nullable = false)
    private Integer doctorId;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "isWorking")
    private Integer isWorking;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birthday")
    private Date birthday;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dateBegin")
    private Date dateBegin;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dateEnd")
    private Date dateEnd;

    @Column(name = "yearExperience")
    private String yearExperience;

    @Column(name = "timeAdvise")
    private Integer timeAdvise;

    @Column(name = "description")
    private String description;


    @Column(name = "active")
    private Integer active;

    @OneToOne
    @MapsId
    @JoinColumn(name = "doctorId")
    private Account account;

    @ManyToOne(optional = false)
    @JoinColumn(name = "consultingRoomId")
    private ConsultingRoom consultingRoom;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<QRCode> qrCodes;


    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<MedicalBill> medicalBills;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<TestResult> testResults;


    @ManyToOne(optional = false)
    @JoinColumn(name = "specialityId")
    private Speciality speciality;

    @ManyToMany(mappedBy = "favoriteDoctor")
    Set<Patient> likes;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(Integer isWorking) {
        this.isWorking = isWorking;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ConsultingRoom getConsultingRoom() {
        return consultingRoom;
    }

    public void setConsultingRoom(ConsultingRoom consultingRoom) {
        this.consultingRoom = consultingRoom;
    }

    public List<QRCode> getQrCodes() {
        return qrCodes;
    }

    public void setQrCodes(List<QRCode> qrCodes) {
        this.qrCodes = qrCodes;
    }

    public List<MedicalBill> getMedicalBills() {
        return medicalBills;
    }

    public void setMedicalBills(List<MedicalBill> medicalBills) {
        this.medicalBills = medicalBills;
    }

    public List<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }

    public String getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(String yearExperience) {
        this.yearExperience = yearExperience;
    }

    public Integer getTimeAdvise() {
        return timeAdvise;
    }

    public void setTimeAdvise(Integer timeAdvise) {
        this.timeAdvise = timeAdvise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}