package com.ptithcm.apihealthcare.model.request;

import com.ptithcm.apihealthcare.entities.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Setter
@Getter
public class NotificationParam {


    private String contentNoti;


    private Integer accId;

    public NotificationParam(String contentNoti, Integer accId) {
        this.contentNoti = contentNoti;
        this.accId = accId;
    }
}
