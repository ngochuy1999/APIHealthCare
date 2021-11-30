package com.ptithcm.apihealthcare.model.request;

import java.util.Date;

public class DoctorParam {
    private Integer doctorId;
    private String address;
    private String firstName;
    private String lastName;
    private String birthday;
    private String yearExperience;
    private Integer timeAdvise;
    private String description;
    private Integer consultingRoomId;
    private Integer specialityId;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public Integer getConsultingRoomId() {
        return consultingRoomId;
    }

    public void setConsultingRoomId(Integer consultingRoomId) {
        this.consultingRoomId = consultingRoomId;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }
}
