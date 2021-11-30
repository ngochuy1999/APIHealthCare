package com.ptithcm.apihealthcare.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TestFormDetail")
public class TestFormDetail {
    @EmbeddedId
    private TestFormDetailKey id;

    @ManyToOne
    @MapsId("testFormId")
    @JoinColumn(name = "testFormId")
    private TestForm testForm;

    @ManyToOne
    @MapsId("subclinicalId")
    @JoinColumn(name = "subclinicalId")
    private Subclinical subclinical;

    @Column(name = "assignTime", nullable = false)
    private Date assignTime;

    @Column(name = "note", nullable = false)
    private String note;

    public TestFormDetailKey getId() {
        return id;
    }

    public void setId(TestFormDetailKey id) {
        this.id = id;
    }

    public TestForm getTestForm() {
        return testForm;
    }

    public void setTestForm(TestForm testForm) {
        this.testForm = testForm;
    }

    public Subclinical getSubclinical() {
        return subclinical;
    }

    public void setSubclinical(Subclinical subclinical) {
        this.subclinical = subclinical;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
