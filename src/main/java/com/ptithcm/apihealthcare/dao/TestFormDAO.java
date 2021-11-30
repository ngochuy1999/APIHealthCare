package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.model.request.TestFormParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestFormDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<TestForm> testFormList(int billId){
        Session session = sessionFactory.getCurrentSession();
        return (List<TestForm>) session.createQuery("from TestForm as t where t.medicalBill.billId= '"+billId+"'").list();
    }

    public TestForm addTestForm(TestForm testForm){
        Session session = sessionFactory.getCurrentSession();
        session.save(testForm);
        return testForm;
    }

    public TestForm findTestForm(int testFormId){
        Session session = sessionFactory.getCurrentSession();
        return (TestForm) session.createQuery("from TestForm as t where t.id ='"+testFormId+"'").uniqueResult();
    }
}
