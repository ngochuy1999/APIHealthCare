package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalBillDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public MedicalBill addMedicalBill(MedicalBill medicalBill){
        Session session = sessionFactory.getCurrentSession();
        session.save(medicalBill);
        return medicalBill;
    }

    public List<MedicalBill> getMedicalBillByDoctor(int doctorId) {
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBills = (List<MedicalBill>) session.createQuery("from MedicalBill b where b.doctor.doctorId = " + doctorId + " and b.medicalBillStatus.statusId = 1").list();
        return medicalBills;
    }

    public List<MedicalBill> getMedicalBillByPatient(int PID) {
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBills = (List<MedicalBill>) session.createQuery("from MedicalBill b where b.patient.userId = " + PID + " and b.medicalBillStatus.statusId = 2").list();
        return medicalBills;
    }

    public List<MedicalBill> getMedicalBill2ByDoctor(int doctorId) {
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBills = (List<MedicalBill>) session.createQuery("from MedicalBill b where b.doctor.doctorId = " + doctorId + " and b.medicalBillStatus.statusId = 1").list();
        return medicalBills;
    }

    public MedicalBill getMedicalExamineByDoctor(int id) {
        Session session = sessionFactory.getCurrentSession();
        MedicalBill medicalBill = (MedicalBill) session.createQuery("from MedicalBill b where b.doctor.doctorId = " + id + " and b.medicalBillStatus.statusId = 2").uniqueResult();
        return medicalBill;
    }


    public MedicalBill findMedicalBill(int billId){
        Session session = sessionFactory.getCurrentSession();
        MedicalBill medicalBill = (MedicalBill) session.createQuery("from MedicalBill b where b.billId = '"+billId+"'").uniqueResult();
        return medicalBill;
    }
}
