package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.MedicalBillDAO;
import com.ptithcm.apihealthcare.dao.SubclinicalDAO;
import com.ptithcm.apihealthcare.dao.TestFormDAO;
import com.ptithcm.apihealthcare.dao.TestFormDetailDAO;
import com.ptithcm.apihealthcare.entities.Subclinical;
import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.entities.TestFormDetail;
import com.ptithcm.apihealthcare.entities.TestFormDetailKey;
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
    public TestForm addTestForm(TestFormParam testFormParam){
        TestForm testForm = new TestForm();

        testForm.setMedicalBill(medicalBillDAO.findMedicalBill(testFormParam.getMedicalBillId()));
        testForm.setDiagnostic(testFormParam.getDiagnostic());
        testForm.setIsPay(0);
        testForm.setActive(1);

        testFormDAO.addTestForm(testForm);
        return testForm;
    }

    // create test form detail
    public TestFormDetail addSubclinical (SubclinicalParam subclinicalParam) {
        try {
            TestFormDetail testFormDetail = new TestFormDetail();
            TestFormDetailKey ik = new TestFormDetailKey();
            ik.setSubclinicalId(subclinicalParam.getSubclinicalId());
            ik.setTestFormId(subclinicalParam.getTestFormId());
            testFormDetail.setId(ik);
            testFormDetail.setSubclinical(subclinicalDAO.findSubclinical(subclinicalParam.getSubclinicalId()));
            testFormDetail.setTestForm(testFormDAO.findTestForm(subclinicalParam.getTestFormId()));
            testFormDetail.setNote(subclinicalParam.getNote());
            long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
            testFormDetail.setAssignTime(date);
            testFormDetailDAO.addTestFormDetail(testFormDetail);

            return testFormDetail;
        }catch (Exception e) {
            System.out.println("Loi" + e);
        }
        return null;
    }

    //list subclinical
    public List<Subclinical> listSubclinical(){
        return subclinicalDAO.listSubclinical();
    }

    public List<TestForm> testFormList(int billId){
        return  testFormDAO.testFormList(billId);
    }

    public List<TestFormDetail> formDetailList(int testId){
        return testFormDetailDAO.formDetailList(testId);
    }

}
