package com.ptithcm.apihealthcare.controller.admin;


import com.ptithcm.apihealthcare.config.firebase.FirebaseStorageFileUploadService;
import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.entities.TestResult;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.SubclinicalParam;
import com.ptithcm.apihealthcare.model.request.TestResultParam;
import com.ptithcm.apihealthcare.service.DoctorService;
import com.ptithcm.apihealthcare.service.TestFormService;
import com.ptithcm.apihealthcare.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class TestResultController {
    @Autowired
    private TestResultService testResultService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TestFormService testFormService;

    @Autowired
    private FirebaseStorageFileUploadService firebaseStorageFileUploadService;


    @GetMapping(value = "/test-result",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<TestResult> testResults(@RequestParam("testFormId") int testFormId){
        return testResultService.testResultList(testFormId);
    }

    @PostMapping(path = "/test-result1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveEmployee( @RequestParam("imageUrl") MultipartFile imageUrl,
                                                @RequestParam("fileUrl") MultipartFile fileUrl,
                                                @RequestParam("doctorId") Integer doctorId,
                                                @RequestParam("conclude") String conclude,
                                                @RequestParam("testFormId") Integer testFormId ) {
        try {
            String imageUrlFB = firebaseStorageFileUploadService.uploadFileToFirebaseStorage(imageUrl);
            String fileUrlFB = firebaseStorageFileUploadService.uploadFileToFirebaseStorage(fileUrl);
            TestResult testResult = new TestResult();
            testResult.setTestForm(testFormService.findTestForm(testFormId));
            testResult.setConclude(conclude);
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            testResult.setDate(date);
            testResult.setDoctor(doctorService.getDoctor(doctorId));
            testResult.setFileUrl(fileUrlFB);
            testResult.setImageUrl(imageUrlFB);
            testResult.setActive(1);

            testResultService.addTestResult1(testResult);

            return ResponseEntity.ok(new ObjectResponse("1", "Thêm kết quả xét nghiệm thành công", true, testResult));

        }catch (Exception e){
        }
        return ResponseEntity.ok(new ObjectResponse("0", "Thêm kết quả xét nghiệm không thành công", false, null));
    }


    @PostMapping(value = "/test-result",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addTestResult(@RequestBody TestResultParam testResultParam){

        TestResult result = testResultService.addTestResult(testResultParam);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Thêm kết quả xét ngiệm không thành công",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Thêm kết quả xét nghiệm thành công",true,result));
    }
}
