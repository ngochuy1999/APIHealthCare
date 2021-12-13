package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.entities.TestFormDetail;
import com.ptithcm.apihealthcare.model.reponse.TestFormResponse;
import com.ptithcm.apihealthcare.service.TestFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestFormRESTController {

    @Autowired
    private TestFormService testFormService;

    @GetMapping(value = "/test-form",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<List<TestFormResponse>> testFormList(@RequestParam("billId") int billId){
        List<TestForm> testForms = testFormService.testFormList(billId);
        List<TestFormResponse> testFormResponses = new ArrayList<>();
        for(TestForm testForm : testForms){
            TestFormResponse testFormResponse = new TestFormResponse(testForm.getDiagnostic(),testForm.getId(),testForm.getIsPay(),testFormService.formDetailList(testForm.getId()));
            testFormResponses.add(testFormResponse);
        }
        return ResponseEntity.ok(testFormResponses);
    }

    @GetMapping(value = "/test-form-detail",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<TestFormDetail> detailList(@RequestParam ("testId") int testId){
        return testFormService.formDetailList(testId);
    }
}
