package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.DoctorDAO;
import com.ptithcm.apihealthcare.dao.TestFormDAO;
import com.ptithcm.apihealthcare.dao.TestResultDAO;
import com.ptithcm.apihealthcare.entities.TestResult;
import com.ptithcm.apihealthcare.model.request.TestResultParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestResultService {
    @Autowired
    private TestResultDAO testResultDAO;

    @Autowired
    private TestFormDAO testFormDAO;

    @Autowired
    private DoctorDAO doctorDAO;

    public List<TestResult> testResultList(int testFormId){
        return testResultDAO.testResultList(testFormId);
    }

    public TestResult addTestResult(TestResultParam testResultParam){
        TestResult testResult = new TestResult();
        testResult.setTestForm(testFormDAO.findTestForm(testResultParam.getTestFormId()));
        testResult.setConclude(testResultParam.getConclude());
        long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
        testResult.setDate(date);
        testResult.setDoctor(doctorDAO.getDoctor(testResultParam.getDoctorId()));
        testResult.setFileUrl(testResultParam.getFileUrl());
        testResult.setImageUrl(testResultParam.getImageUrl());
        testResult.setActive(1);

        testResultDAO.addTestResult(testResult);
        return testResult;
    }

    public TestResult addTestResult1(TestResult testResult){
        testResultDAO.addTestResult(testResult);
        return testResult;
    }
}
