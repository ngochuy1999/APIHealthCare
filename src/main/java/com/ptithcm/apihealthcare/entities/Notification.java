package com.ptithcm.apihealthcare.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Table(name = "Notifiication")
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNoti",unique = true,nullable = false)
    private Integer idNoti;

    @Column(name = "contentNoti")
    private String contentNoti;


    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "dateNoti")
    private ZonedDateTime dateNoti;

    @Column(name = "isAdmin",nullable = false)
    private int isAdmin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idaccount",nullable = false)
    private Account account;

    public Integer getIdNoti() {
        return idNoti;
    }

    public void setIdNoti(Integer idNoti) {
        this.idNoti = idNoti;
    }

    public String getContentNoti() {
        return contentNoti;
    }

    public void setContentNoti(String contentNoti) {
        this.contentNoti = contentNoti;
    }

    public ZonedDateTime getDateNoti() {
        return dateNoti;
    }

    public void setDateNoti(ZonedDateTime dateNoti) {
        this.dateNoti = dateNoti;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }


    public void setAccount(Account account) {
        this.account = account;
    }
}
