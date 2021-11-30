package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.TestFormDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestFormDetailDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public TestFormDetail addTestFormDetail(TestFormDetail testFormDetail){
        Session session = sessionFactory.getCurrentSession();
        session.save(testFormDetail);
        return testFormDetail;
    }

    public List<TestFormDetail> formDetailList(int testId){
        Session session = sessionFactory.getCurrentSession();
        return (List<TestFormDetail>) session.createQuery("from TestFormDetail as t where t.testForm.id = '"+testId+"'").list();
    }
}
