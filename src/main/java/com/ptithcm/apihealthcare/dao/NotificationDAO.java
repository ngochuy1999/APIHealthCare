package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Notification addNotification(Notification notification){
        Session session = sessionFactory.getCurrentSession();
        session.save(notification);
        return notification;
    }

    public List<Notification> getNotification(int pId) {
        Session session = sessionFactory.getCurrentSession();
        List<Notification> notifications = (List<Notification>) session.createQuery("from Notification n where n.account.accountId = " + pId+"Order By idNoti DESC").list();
        return notifications;
    }
}
