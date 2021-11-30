package com.ptithcm.apihealthcare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Table(name = "Speciality")
@Entity
public class Speciality {
    @Id
    @Column(name = "specialityId",unique = true,nullable = false)
    private Integer specialityId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "active")
    private Integer active;


    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "speciality", fetch = FetchType.LAZY)
    private List<Subclinical> subclinical;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "speciality", fetch = FetchType.LAZY)
    private List<Doctor> doctors;

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getActive() {
        return active;
    }


    public List<Subclinical> getSubclinical() {
        return subclinical;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSubclinical(List<Subclinical> subclinical) {
        this.subclinical = subclinical;
    }
}
