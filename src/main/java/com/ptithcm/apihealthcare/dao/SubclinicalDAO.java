package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.Subclinical;
import com.ptithcm.apihealthcare.entities.TestForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubclinicalDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Subclinical> listSubclinical(int specialityId){
        Session session = sessionFactory.getCurrentSession();
        return (List<Subclinical>) session.createQuery("from Subclinical as s where s.speciality.specialityId='"+specialityId+"'").list();
    }

    public List<Subclinical> listSubclinicalByTestForm(int specialityId){
        Session session = sessionFactory.getCurrentSession();
        return (List<Subclinical>) session.createQuery("select t.subclinical from TestFormDetail t where t.testForm.id='"+specialityId+"'").list();
    }

    public Subclinical findSubclinical(int subId){
        Session session = sessionFactory.getCurrentSession();
        return (Subclinical) session.createQuery("from Subclinical as s where s.id ='"+subId+"'").uniqueResult();
    }
}
