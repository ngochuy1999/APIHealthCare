package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.entities.TestResult;
import com.ptithcm.apihealthcare.model.request.ChargeRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestResultDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<TestResult> testResultList(int testFormId){
        Session session = sessionFactory.getCurrentSession();
        return (List<TestResult>) session.createQuery("from TestResult as t where t.testForm.id ='"+testFormId+"'").list();
    }

    public List<TestResult> testResultListUser(int pId){
        Session session = sessionFactory.getCurrentSession();
        return (List<TestResult>) session.createQuery("from TestResult as t where t.testForm.medicalBill.patient.userId ='"+pId+"'").list();
    }

    public Boolean doneResult(int testId) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.createQuery("UPDATE TestForm set isPay = 2 WHERE id = :id")
                    .setParameter("id", testId)
                    .executeUpdate();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        session.close();
        return true;
    }


    public TestResult addTestResult(TestResult testResult){
        Session session = sessionFactory.getCurrentSession();
        session.save(testResult);
        return testResult;
    }
}
