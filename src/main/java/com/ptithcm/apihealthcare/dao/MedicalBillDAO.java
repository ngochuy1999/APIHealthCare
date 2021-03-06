package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.entities.Patient;
import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.ChargeRequest;
import com.ptithcm.apihealthcare.model.request.EditProfileParam;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Repository
public class MedicalBillDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public MedicalBill addMedicalBill(MedicalBill medicalBill){
        Session session = sessionFactory.getCurrentSession();
        session.save(medicalBill);
        return medicalBill;
    }

    public Boolean charge(ChargeRequest chargeRequest){
        Session session = sessionFactory.openSession();
        List<TestForm> testForms =(List<TestForm>) session
                .createQuery("from TestForm as t where t.medicalBill.billId= '"+chargeRequest.getBillId()+"'").list();
            for (TestForm testForm : testForms) {
                Transaction t = session.beginTransaction();
                try {
                    session.createQuery("UPDATE TestForm set isPay = 1 WHERE id = :id")
                            .setParameter("id", testForm.getId())
                            .executeUpdate();
                    t.commit();
                } catch (Exception e) {
                    t.rollback();
                }
            }
            session.close();
            return true;
    }

    public List<MedicalBill> getMedicalBillByDoctor(int doctorId) {
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBills = (List<MedicalBill>) session.createQuery("from MedicalBill b " +
                        "where b.doctor.doctorId = " + doctorId + " and b.medicalBillStatus.statusId = 1").list();
        return medicalBills;
    }

    public int countBillByDoc(int doctorId) {
        long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBills = (List<MedicalBill>) session.createQuery("from MedicalBill b " +
                        "where b.doctor.doctorId = " + doctorId + " and (b.medicalBillStatus.statusId = 1 or b.medicalBillStatus.statusId=2) and b.dateCreate BETWEEN '"+date+" 00:00:00' AND '"+date+" 23:59:59'").list();
        if(medicalBills == null) return 0;
        else return medicalBills.size();
    }

    public Boolean checkDK(int patientID, int doctorId) {
        long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
        Session session = sessionFactory.getCurrentSession();
        MedicalBill medicalBills = (MedicalBill) session.createQuery("from MedicalBill b" +
                " where b.doctor.doctorId = " + doctorId + " and b.patient.userId =" + patientID + " and (b.medicalBillStatus.statusId = 1 or b.medicalBillStatus.statusId=2) and b.dateCreate BETWEEN '"+date+" 00:00:00' AND '"+date+" 23:59:59'").uniqueResult();
        return (medicalBills != null);
    }

    public List<MedicalBill> getMedicalBillByPatient(int PID) {
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBills = (List<MedicalBill>) session.createQuery("from MedicalBill b " +
                        "where b.patient.userId = " + PID + " and (b.medicalBillStatus.statusId = 1 or b.medicalBillStatus.statusId = 2)").list();
        return medicalBills;
    }

    public List<MedicalBill> getMedicalBill2ByDoctor(int doctorId) {
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBills = (List<MedicalBill>) session.createQuery("from MedicalBill b " +
                        "where b.doctor.doctorId = " + doctorId + " and b.medicalBillStatus.statusId = 1 ORDER BY dateCreate ASC").list();
        return medicalBills;
    }

    public List<MedicalBill> getMedicalBillByDoctorOnDay(int doctorId) {
        long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBills = (List<MedicalBill>) session.createQuery("from MedicalBill b " +
                        "where b.doctor.doctorId = " + doctorId + " and b.medicalBillStatus.statusId = 1 and b.dateCreate BETWEEN '"+date+" 00:00:00' AND '"+date+" 23:59:59'").list();
        return medicalBills;
    }

    public List<MedicalBill> getMedicalExamineByDoctor(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<MedicalBill> medicalBill = (List<MedicalBill>) session.createQuery("from MedicalBill b " +
                        "where b.doctor.doctorId = " + id + " and b.medicalBillStatus.statusId = 2").list();
        return medicalBill;
    }


    public MedicalBill findMedicalBill(int billId){
        Session session = sessionFactory.getCurrentSession();
        MedicalBill medicalBill = (MedicalBill) session
                .createQuery("from MedicalBill b where b.billId = '"+billId+"'").uniqueResult();
        return medicalBill;
    }
}
