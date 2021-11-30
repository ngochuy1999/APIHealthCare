package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Table(name = "Subclinical")
@Entity
public class Subclinical {
    @Id
    @Column(name = "subclinicalId",unique = true,nullable = false)
    private Integer subclinicalId;

    @Column(name = "testName",nullable = false)
    private String testName;

    @Column(name = "price",nullable = false)
    private Float price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "specialityId")
    private Speciality speciality;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "subclinical")
    List<TestFormDetail> testFormDetails;

    public Integer getSubclinicalId() {
        return subclinicalId;
    }

    public void setSubclinicalId(Integer subclinicalId) {
        this.subclinicalId = subclinicalId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

}
