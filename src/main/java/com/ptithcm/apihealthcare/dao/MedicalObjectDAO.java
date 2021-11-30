package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.MedicalBillStatus;
import com.ptithcm.apihealthcare.entities.MedicalObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalObjectDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public MedicalObject getObject(int id){
        Session session = sessionFactory.getCurrentSession();
        MedicalObject object = (MedicalObject) session.get(MedicalObject.class,id);
        return object;
    }
}

