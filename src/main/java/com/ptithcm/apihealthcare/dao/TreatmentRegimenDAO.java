package com.ptithcm.apihealthcare.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ptithcm.apihealthcare.entities.TreatmentRegimen;

@Repository
public class TreatmentRegimenDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public TreatmentRegimen addTreatmentRegimen(TreatmentRegimen treatmentRegimen){
        Session session = sessionFactory.getCurrentSession();
        session.save(treatmentRegimen);
        return treatmentRegimen;
    }
    public TreatmentRegimen findTreatmentRegimen(int treatmentRegimenId){
        Session session = sessionFactory.getCurrentSession();
        return (TreatmentRegimen) session.createQuery("from TreatmentRegimen as t where t.treatmentId= '"+treatmentRegimenId+"'").uniqueResult();
    }

}
