package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.entities.MedicalBillStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalBillStatusDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public MedicalBillStatus getStatus(int statusId){
        Session session = sessionFactory.getCurrentSession();
        MedicalBillStatus status = (MedicalBillStatus) session.get(MedicalBillStatus.class,statusId);
        return status;
    }

    // join room
    public Boolean joinRoom(int medicalId){
        Session session = sessionFactory.getCurrentSession();
        MedicalBill medicalBillUpdate = (MedicalBill) session.get(MedicalBill.class, medicalId);
        if(medicalBillUpdate.getMedicalBillStatus().getStatusId()==1) {
            MedicalBillStatus medicalBillStatus = (MedicalBillStatus) session.createQuery("FROM MedicalBillStatus as m WHERE m.statusId = 2").uniqueResult();
            medicalBillUpdate.setMedicalBillStatus(medicalBillStatus);
            session.update(medicalBillUpdate);
            return true;
        }else{
            return false;
        }
    }

    // complete
    public Boolean complete(int medicalId){
        Session session = sessionFactory.getCurrentSession();
        MedicalBill medicalBillUpdate = (MedicalBill) session.get(MedicalBill.class, medicalId);
        if(medicalBillUpdate.getMedicalBillStatus().getStatusId()==2) {
            MedicalBillStatus medicalBillStatus = (MedicalBillStatus) session.createQuery("FROM MedicalBillStatus as m WHERE m.statusId = 3").uniqueResult();
            medicalBillUpdate.setMedicalBillStatus(medicalBillStatus);
            session.update(medicalBillUpdate);
            return true;
        }else{
            return false;
        }
    }

    // cancel bill
    public Boolean cancelBill(int medicalId){
        Session session = sessionFactory.getCurrentSession();
        MedicalBill medicalBillUpdate = (MedicalBill) session.get(MedicalBill.class, medicalId);
        if(medicalBillUpdate.getMedicalBillStatus().getStatusId()==1) {
            MedicalBillStatus medicalBillStatus = (MedicalBillStatus) session.createQuery("FROM MedicalBillStatus as m WHERE m.statusId = 4").uniqueResult();
            medicalBillUpdate.setMedicalBillStatus(medicalBillStatus);
            session.update(medicalBillUpdate);
            return true;
        }else{
            return false;
        }
    }
}
