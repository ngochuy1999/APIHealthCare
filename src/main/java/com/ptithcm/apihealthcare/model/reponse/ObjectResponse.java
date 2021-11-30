package com.ptithcm.apihealthcare.model.reponse;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptithcm.apihealthcare.entities.Account;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectResponse {

    @JsonProperty("code")
    private String code;
    @JsonProperty("detail")
    private String message;
    @JsonProperty("status")
    private boolean status;
    @JsonProperty("data")
    private Object data;

    // A default constructor is required for serialization/deserialization to work
    public ObjectResponse() {
    }

    public ObjectResponse(String code, String message, boolean status, Object data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Account data) {
        this.data = data;
    }

    // Getters and Setters ....
}
