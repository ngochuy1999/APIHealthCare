package com.ptithcm.apihealthcare.model.request;

import java.util.Date;

public class TreatmentRegimenParam {

    private Integer treatmentId;

    private Date dateBegin;

    private Date dateEnd;

    private String needs;

    private String prohibited;

    private Date reExaminationDate;

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
}
