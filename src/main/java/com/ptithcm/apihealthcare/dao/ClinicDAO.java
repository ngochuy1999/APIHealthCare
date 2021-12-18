package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.ConsultingRoom;
import com.ptithcm.apihealthcare.entities.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClinicDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<ConsultingRoom> getConsultingRooms() {
        Session session = sessionFactory.getCurrentSession();
        List<ConsultingRoom> consultingRooms = (List<ConsultingRoom>) session.createQuery("from ConsultingRoom ").list();
        return consultingRooms;
    }
}
