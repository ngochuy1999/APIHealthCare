package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.Account;
import com.ptithcm.apihealthcare.entities.Patient;
import com.ptithcm.apihealthcare.entities.Role;
import com.ptithcm.apihealthcare.model.request.ProfileParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Repository
public class PatientDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Patient getProfile(int PID){
        Session session = sessionFactory.getCurrentSession();
        return (Patient) session.createQuery("FROM Patient as p WHERE p.userId = '"+PID+"'").uniqueResult();
    }
    public Patient createProfile(ProfileParam profileParam) {
        System.out.println(profileParam.getBirthday());
        String date = convertFormat(profileParam.getBirthday(),"dd/MM/yyyy","yyyy-MM-dd");
        java.sql.Date datenew = java.sql.Date.valueOf(date);
        System.out.println(datenew);
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Patient patient = new Patient();
            patient.setUserId(profileParam.getPid());
            patient.setAccount((Account) session.createQuery("FROM Account as a WHERE a.accountId = '"+profileParam.getPid()+"'").uniqueResult());
            patient.setName(profileParam.getName());
            patient.setGender(profileParam.getGender());
            patient.setIdentityCard(profileParam.getIdentityCard());
            patient.setAddress(profileParam.getAddress());
            patient.setBirthday(datenew);
            patient.setActive(profileParam.getActive());
            session.save(patient);
            t.commit();
            return patient;
        } catch (Exception e) {
            t.rollback();
            System.out.println("Loi" + e);
        } finally {
            session.close();
        }
        return null;
    }

    public String convertFormat(String dateTime,String fromFormat,String toFormat){
        if (!dateTime.isEmpty()) {
            SimpleDateFormat fromFormatter = new SimpleDateFormat(fromFormat, new Locale("vi"));
            SimpleDateFormat toFormatter = new SimpleDateFormat(toFormat, new Locale("vi"));
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(fromFormatter.parse(dateTime).getTime());
                return toFormatter.format(cal.getTime());
            } catch (ParseException e) {
            }
        }
        return "";
    }
}
