package com.ptithcm.apihealthcare.model.reponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptithcm.apihealthcare.entities.Prescription;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreatmentRegimentResponse {

    @JsonProperty("treatmentId")
    private Integer treatmentId;

    @JsonProperty("dateBegin")
    private Date dateBegin;

    @JsonProperty("dateEnd")
    private Date dateEnd;

    @JsonProperty("needs")
    private String needs;

    @JsonProperty("prohibited")
    private String prohibited;

    @JsonProperty("reExaminationDate")
    private Date reExaminationDate;

    @JsonProperty("prescriptions")
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

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
