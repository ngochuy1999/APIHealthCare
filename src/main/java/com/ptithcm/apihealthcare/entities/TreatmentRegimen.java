package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "TreatmentRegimen")
@Entity
public class TreatmentRegimen {

    @Id
    @Column(name = "treatmentId",unique = true,nullable = false)
    private Integer treatmentId;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dateBegin",nullable = false)
    private Date dateBegin;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dateEnd",nullable = false)
    private Date dateEnd;

    @Column(name = "needs",nullable = false)
    private String needs;

    @Column(name = "prohibited", nullable = false)
    private String prohibited;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "reExaminationDate", nullable = false)
    private Date reExaminationDate;

    @Column(name = "active")
    private Integer active;

    @OneToOne
    @MapsId
    @JoinColumn(name = "treatmentId")
    private MedicalRecord medicalRecord;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "treatmentRegimen", fetch = FetchType.LAZY)
    private List<Prescription> prescriptions;

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
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

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public String getProhibited() {
        return prohibited;
    }

    public void setProhibited(String prohibited) {
        this.prohibited = prohibited;
    }

    public Date getReExaminationDate() {
        return reExaminationDate;
    }

    public void setReExaminationDate(Date reExaminationDate) {
        this.reExaminationDate = reExaminationDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
