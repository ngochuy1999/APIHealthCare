package com.ptithcm.apihealthcare.model.request;

import java.util.Date;

public class SubclinicalParam {
    private Integer testFormId;
    private Integer subclinicalId;
    private String note;

    public Integer getTestFormId() {
        return testFormId;
    }

    public void setTestFormId(Integer testFormId) {
        this.testFormId = testFormId;
    }

    public Integer getSubclinicalId() {
        return subclinicalId;
    }

    public void setSubclinicalId(Integer subclinicalId) {
        this.subclinicalId = subclinicalId;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
