package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.TestResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    public TestResult addTestResult(TestResult testResult){
        Session session = sessionFactory.getCurrentSession();
        session.save(testResult);
        return testResult;
    }
}
