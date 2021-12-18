package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.AccountDAO;
import com.ptithcm.apihealthcare.dao.NotificationDAO;
import com.ptithcm.apihealthcare.entities.Notification;
import com.ptithcm.apihealthcare.model.request.NotificationParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@Transactional
public class NotificationService {

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    NotificationDAO notificationDAO;

    public Notification addNotification(NotificationParam notificationParam){
        Notification notification = new Notification();
        notification.setContentNoti(notificationParam.getContentNoti());
        notification.setDateNoti(ZonedDateTime.now());
        notification.setAccount(accountDAO.getAccount(notificationParam.getAccId()));

        notificationDAO.addNotification(notification);
        return notification;
    }

    public List<Notification> getNotifications(int pId){
        return notificationDAO.getNotification(pId);
    }
}
