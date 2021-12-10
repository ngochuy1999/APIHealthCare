package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.MedicalBillDAO;
import com.ptithcm.apihealthcare.dao.SubclinicalDAO;
import com.ptithcm.apihealthcare.dao.TestFormDAO;
import com.ptithcm.apihealthcare.dao.TestFormDetailDAO;
import com.ptithcm.apihealthcare.entities.Subclinical;
import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.entities.TestFormDetail;
import com.ptithcm.apihealthcare.entities.TestFormDetailKey;
import com.ptithcm.apihealthcare.model.request.SubclinicalInTest;
import com.ptithcm.apihealthcare.model.request.SubclinicalParam;
import com.ptithcm.apihealthcare.model.request.TestFormParam;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TestFormService {
    @Autowired
    private TestFormDAO testFormDAO;

    @Autowired
    private MedicalBillDAO medicalBillDAO;

    @Autowired
    private TestFormDetailDAO testFormDetailDAO;

    @Autowired
    private SubclinicalDAO subclinicalDAO;


    //create test form
    public TestForm addTestForm(int billId, String diagnostic){
        TestForm testForm = new TestForm();
        testForm.setMedicalBill(medicalBillDAO.findMedicalBill(billId));
        testForm.setDiagnostic(diagnostic);
        testForm.setIsPay(0);
        testForm.setActive(1);

        testFormDAO.addTestForm(testForm);
        return testForm;
    }

    // create test form detail
    public TestForm addSubclinical (SubclinicalParam subclinicalParam) {
        try {
            TestForm testForm = addTestForm(subclinicalParam.getMedicalBillId(),subclinicalParam.getDiagnostic());
            for (SubclinicalInTest subclinicalInTest : subclinicalParam.getListSubclinicalInTests()) {
                TestFormDetail testFormDetail = new TestFormDetail();
                TestFormDetailKey ik = new TestFormDetailKey();
                ik.setSubclinicalId(subclinicalInTest.getSubclinicalId());
                ik.setTestFormId(testForm.getId());
                testFormDetail.setId(ik);
                testFormDetail.setSubclinical(subclinicalDAO.findSubclinical(subclinicalInTest.getSubclinicalId()));
                testFormDetail.setTestForm(testForm);
                testFormDetail.setNote(subclinicalInTest.getNote());
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                testFormDetail.setAssignTime(date);
                testFormDetailDAO.addTestFormDetail(testFormDetail);
            }
            return testForm;
        }catch (Exception e) {
            System.out.println("Loi" + e);
        }
        return null;
    }

    //list subclinical
    public List<Subclinical> listSubclinical(int specialityId){
        return subclinicalDAO.listSubclinical(specialityId);
    }

    public List<Subclinical> listSubclinicalByTestForm(int specialityId){
        return subclinicalDAO.listSubclinicalByTestForm(specialityId);
    }

    public TestForm findTestForm(int id){ return testFormDAO.findTestForm(id);}

    public List<TestForm> testFormList(int billId){
        return  testFormDAO.testFormList(billId);
    }

    public List<TestFormDetail> formDetailList(int testId){
        return testFormDetailDAO.formDetailList(testId);
    }

}
