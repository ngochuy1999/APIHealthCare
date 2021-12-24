package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.DoctorDAO;
import com.ptithcm.apihealthcare.dao.TestFormDAO;
import com.ptithcm.apihealthcare.dao.TestResultDAO;
import com.ptithcm.apihealthcare.entities.TestResult;
import com.ptithcm.apihealthcare.entities.TestResultDetail;
import com.ptithcm.apihealthcare.model.request.TestResultParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Boolean doneResult(int id){
        return testResultDAO.doneResult(id);
    }

    public List<TestResult> testResultListUser(int pId){
        return testResultDAO.testResultListUser(pId);
    }

    public TestResult addTestResult(Integer doctorId, Integer testFormId ){
        TestResult testResult = new TestResult();
        testResult.setTestForm(testFormDAO.findTestForm(testFormId));
        long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
        testResult.setDate(date);
        testResult.setDoctor(doctorDAO.getDoctor(doctorId));
        testResult.setActive(1);

        testResultDAO.addTestResult(testResult);
        return testResult;
    }

    public TestResult addTestResult1(TestResult testResult){
        testResultDAO.addTestResult(testResult);
        return testResult;
    }

    public TestResult findTestResult(Integer resultId){
        return  testResultDAO.findTestResult(resultId);
    }

    public TestResultDetail addImageTestResult(TestResultDetail imageTestResult){
        return testResultDAO.addImageTestResult(imageTestResult);
    }

    public List<TestResultDetail> imageTestResults(int testId){
        return testResultDAO.imageTestResult(testId);
    }

}
