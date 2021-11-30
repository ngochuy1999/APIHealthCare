package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.MedicalRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalRecordDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<MedicalRecord> getListMedicalRecords(int PID){
        Session session = sessionFactory.getCurrentSession();
        return (List<MedicalRecord>) session.createQuery("from MedicalRecord as m where m.medicalBill.patient.userId ='"+PID+"'").list();
    }

    public MedicalRecord findMedicalRecords(int medicalId){
        Session session = sessionFactory.getCurrentSession();
        return (MedicalRecord) session.createQuery("from MedicalRecord as m where m.recordId ='"+medicalId+"'").uniqueResult();
    }

    public MedicalRecord addMedicalRecords(MedicalRecord medicalRecord){
        Session session = sessionFactory.getCurrentSession();
        session.save(medicalRecord);
        return medicalRecord;
    }


}
