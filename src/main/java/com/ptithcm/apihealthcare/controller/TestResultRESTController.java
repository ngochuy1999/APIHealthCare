package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.TestResult;
import com.ptithcm.apihealthcare.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestResultRESTController {

    @Autowired
    private TestResultService testResultService;

    @GetMapping(value = "/test-result",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<TestResult> testResults(@RequestParam("pid") int pId){
        return testResultService.testResultListUser(pId);
    }
}
