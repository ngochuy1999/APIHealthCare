package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.HospitalInfo;
import com.ptithcm.apihealthcare.entities.TestForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public HospitalInfo getHospital(){
        Session session = sessionFactory.getCurrentSession();
        return (HospitalInfo) session.createQuery("from HospitalInfo ").uniqueResult();
    }
}
