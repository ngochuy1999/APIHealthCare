package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MedicineDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Medicine> getMedicine(){
        Session session = sessionFactory.getCurrentSession();
        List<Medicine> medicineList = (List<Medicine>) session.createQuery("from  Medicine ").list();
        return medicineList;
    }

    public Medicine findMedicine(int medicineId) {
        Session session = sessionFactory.getCurrentSession();
        Medicine medicine = (Medicine) session.createQuery("from Medicine m where m.medicineId = " + medicineId).uniqueResult();
        return medicine;
    }
}
