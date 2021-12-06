package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.Speciality;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SpecialityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Speciality> getTopSpecialities(){
        Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.createQuery("FROM "+Speciality.class.getName()).setFirstResult(0)
                .setMaxResults(8);
        List<Speciality> listSpecialities = (List<Speciality>) query.list();
        return listSpecialities;
    }

    public List<Speciality> getListSpecialities(){
        Session session = sessionFactory.getCurrentSession();
        List<Speciality> listSpecialities = (List<Speciality>) session.createQuery("FROM "+Speciality.class.getName()).list();
        return listSpecialities;
    }
}
