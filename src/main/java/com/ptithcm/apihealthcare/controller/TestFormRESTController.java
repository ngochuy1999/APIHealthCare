package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.service.TestFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestFormRESTController {

    @Autowired
    private TestFormService testFormService;

    @GetMapping(value = "/test-form",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<TestForm> testFormList(@RequestParam("billId") int billId){
        return testFormService.testFormList(billId);
    }
}
