package com.ptithcm.apihealthcare.model.request;

public class MedicalBillRequest {
    private Integer doctorId;
    private Integer PID;

    public MedicalBillRequest(Integer doctorId, Integer PID) {
        this.doctorId = doctorId;
        this.PID = PID;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }
}
