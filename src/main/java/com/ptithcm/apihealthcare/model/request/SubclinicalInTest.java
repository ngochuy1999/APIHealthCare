package com.ptithcm.apihealthcare.model.request;

public class SubclinicalInTest {
    private Integer subclinicalId;
    private String note;

    public SubclinicalInTest() {
    }

    public SubclinicalInTest(Integer subclinicalId, String note) {
        this.subclinicalId = subclinicalId;
        this.note = note;
    }

    public Integer getSubclinicalId() {
        return subclinicalId;
    }

    public String getNote() {
        return note;
    }

    public void setSubclinicalId(Integer subclinicalId) {
        this.subclinicalId = subclinicalId;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
