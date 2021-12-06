package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.*;
import com.ptithcm.apihealthcare.model.request.AccountParam;
import com.ptithcm.apihealthcare.model.request.DoctorParam;
import com.ptithcm.apihealthcare.model.request.ProfileParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Repository
public class DoctorDAO {
    @Autowired
    private SessionFactory sessionFactory;

//    public Doctor addDoctor(Doctor doctor){
//
//    }

    public Doctor getDoctor(int PID){
        Session session = sessionFactory.getCurrentSession();
        return (Doctor) session.createQuery("FROM Doctor p WHERE p.doctorId = '"+PID+"'").uniqueResult();
    }

    public List<Doctor> getTopDoctors(){
        Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.createQuery("FROM "+Doctor.class.getName()).setFirstResult(0)
                .setMaxResults(5);
        List<Doctor> doctorList =(List<Doctor>) query.list();
        System.out.println(doctorList);
        return doctorList;
    }

    public List<Doctor> getListDoctors(){
        Session session = sessionFactory.getCurrentSession();
        List<Doctor> doctorList = (List<Doctor>) session.createQuery("FROM "+Doctor.class.getName()).list();
        return doctorList;
    }

    public List<Doctor> getListDoctorsBySpecial(int specialId){
        Session session = sessionFactory.getCurrentSession();
        List<Doctor> doctorList = (List<Doctor>) session.createQuery("FROM Doctor as d where d.speciality.specialityId='"+specialId+"'").list();
        return doctorList;
    }

    public Boolean checkIsLike(int pid, int doctorId){
        Session session = sessionFactory.getCurrentSession();
        FavoriteDoctor favoriteDoctor = (FavoriteDoctor) session.createQuery("FROM FavoriteDoctor as f where f.id.patient.userId='"+pid+"' and f.id.doctor.doctorId='"+doctorId+"'").uniqueResult();
        return favoriteDoctor != null;
    }

    public List<Doctor> getAllDoctors(){
        Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.createQuery("FROM "+Doctor.class.getName());
        List<Doctor> doctorList =(List<Doctor>) query.list();
        System.out.println(doctorList);
        return doctorList;
    }

    public Account createAcc(AccountParam accountParam) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        try {
            Role role = (Role) session.createQuery("FROM Role as r WHERE r.roleId = 2").uniqueResult();
            Account account = new Account();
            account.setRole(role);
            account.setEmail(accountParam.getEmail());
            account.setPassword(accountParam.getPassword());
            account.setUserName(accountParam.getUserName());
            account.setPhone(accountParam.getPhone());
            long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
            account.setDateCreate(date);
            account.setIsAccuracy(0);
            account.setActive(1);
            session.save(account);

            t.commit();
            return account;
        } catch (Exception e) {
            t.rollback();
            System.out.println("Loi" + e);
        } finally {
            session.close();
        }
        return null;
    }

    public Doctor createProfileDoctor(DoctorParam doctorParam) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            System.out.println(doctorParam.getBirthday());
            String date = convertFormat(doctorParam.getBirthday(),"dd/MM/yyyy","yyyy-MM-dd");
            java.sql.Date datenew = java.sql.Date.valueOf(date);
            System.out.println(datenew);
//            Patient patient = new Patient();
//            patient.setUserId(doctorParam.getPid());
//            patient.setAccount((Account) session.createQuery("FROM Account as a WHERE a.accountId = '"+profileParam.getPid()+"'").uniqueResult());
//            patient.setName(profileParam.getName());
//            patient.setGender(profileParam.getGender());
//            patient.setIdentityCard(profileParam.getIdentityCard());
//            patient.setAddress(profileParam.getAddress());
//            patient.setBirthday(datenew);
//            patient.setActive(profileParam.getActive());
//            session.save(patient);
            Doctor doctor = new Doctor();
            doctor.setDoctorId(doctorParam.getDoctorId());
            doctor.setAccount((Account) session.createQuery("From Account as a WHERE a.accountId = '"+doctorParam.getDoctorId()+"'").uniqueResult());
            doctor.setSpeciality((Speciality) session.createQuery("from Speciality  as s where s.id = '"+doctorParam.getSpecialityId()+"'").uniqueResult());
            doctor.setConsultingRoom((ConsultingRoom) session.createQuery("from ConsultingRoom as c where c.id = '"+doctorParam.getConsultingRoomId()+"'").uniqueResult());
            doctor.setActive(1);
            doctor.setIsWorking(1);
            doctor.setAddress(doctorParam.getAddress());
            long millis=System.currentTimeMillis();   java.sql.Date datebegin=new java.sql.Date(millis);
            doctor.setDateBegin(datebegin);
            doctor.setBirthday(datenew);
            doctor.setFirstName(doctorParam.getFirstName());
            doctor.setLastName(doctorParam.getLastName());
            doctor.setTimeAdvise(doctorParam.getTimeAdvise());
            doctor.setYearExperience(doctorParam.getYearExperience());
            doctor.setDescription(doctorParam.getDescription());
            session.save(doctor);

            t.commit();
            return doctor;
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
