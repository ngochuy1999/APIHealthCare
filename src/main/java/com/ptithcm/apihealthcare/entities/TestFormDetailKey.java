package com.ptithcm.apihealthcare.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TestFormDetailKey implements Serializable {

    @Column(name = "testFormId")
    private int testFormId;

    @Column(name = "subclinicalId")
    private int subclinicalId;

    public int getTestFormId() {
        return testFormId;
    }

    public void setTestFormId(int testFormId) {
        this.testFormId = testFormId;
    }

    public int getSubclinicalId() {
        return subclinicalId;
    }

    public void setSubclinicalId(int subclinicalId) {
        this.subclinicalId = subclinicalId;
    }
}
