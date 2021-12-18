package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.Prescription;
import com.ptithcm.apihealthcare.entities.TestFormDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrescriptionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Prescription addPrescription(Prescription prescription){
        Session session = sessionFactory.getCurrentSession();
        session.save(prescription);
        return prescription;
    }

    public List<Prescription> prescriptionList(int treatmentId){
        Session session = sessionFactory.getCurrentSession();
        return (List<Prescription>) session.createQuery("from Prescription as p where p.treatmentRegimen.treatmentId = '"+treatmentId+"'").list();
    }
}
