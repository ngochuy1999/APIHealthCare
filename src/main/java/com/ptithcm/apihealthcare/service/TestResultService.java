package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.TestResultDAO;
import com.ptithcm.apihealthcare.entities.TestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestResultService {
    @Autowired
    private TestResultDAO testResultDAO;

    public List<TestResult> testResultList(int billId){
        return testResultDAO.testResultList(billId);
    }
}
