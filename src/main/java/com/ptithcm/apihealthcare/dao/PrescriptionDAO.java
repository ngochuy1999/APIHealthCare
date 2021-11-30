package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.Prescription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PrescriptionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Prescription addPrescription(Prescription prescription){
        Session session = sessionFactory.getCurrentSession();
        session.save(prescription);
        return prescription;
    }
}
