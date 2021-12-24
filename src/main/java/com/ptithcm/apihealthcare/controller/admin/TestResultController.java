package com.ptithcm.apihealthcare.controller.admin;


import com.ptithcm.apihealthcare.config.firebase.FirebaseStorageFileUploadService;
import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.entities.TestResult;
import com.ptithcm.apihealthcare.entities.TestResultDetail;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.reponse.TestResultReponse;
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

import java.util.ArrayList;
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
    public List<TestResultReponse> testResults(@RequestParam("testFormId") int testFormId){
        List<TestResult> testResults = testResultService.testResultList(testFormId);
        List<TestResultReponse> list = new ArrayList<>();
        for(TestResult testResult : testResults){
            List<TestResultDetail> testResultDetails = testResultService.imageTestResults(testResult.getResultId());
            TestResultReponse testResultReponse = new TestResultReponse(testResult.getResultId(),
                   testResult.getDate(),testResult.getActive(),testResult.getDoctor(),testResult.getTestForm(),testResultDetails);
            list.add(testResultReponse);
        }

        return list;
    }

//    @PostMapping(path = "/test-result1", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Object> saveTestResult( @RequestParam("imageUrl")List<MultipartFile> imageUrl,
//                                                @RequestParam("fileUrl") List<MultipartFile> fileUrl,
//                                                @RequestParam("doctorId") Integer doctorId,
//                                                @RequestParam("testFormId") Integer testFormId ) {
//        try {
////            String imageUrlFB = firebaseStorageFileUploadService.uploadFileToFirebaseStorage(imageUrl);
////            String fileUrlFB = firebaseStorageFileUploadService.uploadFileToFirebaseStorage(fileUrl);
//            TestResult testResult = new TestResult();
//            testResult.setTestForm(testFormService.findTestForm(testFormId));
//            long millis = System.currentTimeMillis();
//            java.sql.Date date = new java.sql.Date(millis);
//            testResult.setDate(date);
//            testResult.setDoctor(doctorService.getDoctor(doctorId));
////            testResult.setFileUrl(fileUrlFB);
////            testResult.setImageUrl(imageUrlFB);
//            testResult.setActive(1);
//
//            testResultService.addTestResult1(testResult);
//
//            for (MultipartFile multipartFile : imageUrl){
//                String imageUrlFirebase = firebaseStorageFileUploadService.uploadFileToFirebaseStorage(multipartFile);
//                ImageTestResult imageTestResult = new ImageTestResult();
//                imageTestResult.setImageUrl(imageUrlFirebase);
//                imageTestResult.setTestResult(testResult);
//                imageTestResult.setActive(1);
//
//                testResultService.addImageTestResult(imageTestResult);
//            }
//
//            for (MultipartFile multipartFile : fileUrl){
//                String fileUrlFirebase = firebaseStorageFileUploadService.uploadFileToFirebaseStorage(multipartFile);
//                FileTestResult fileTestResult = new FileTestResult();
//                fileTestResult.setTestResult(testResult);
//                fileTestResult.setFileUrl(fileUrlFirebase);
//                fileTestResult.setActive(1);
//
//                testResultService.addFileTestResult(fileTestResult);
//            }
//
//            testResultService.doneResult(testFormId);
//
//            return ResponseEntity.ok(new ObjectResponse("1", "Thêm kết quả xét nghiệm thành công", true, testResult));
//
//        }catch (Exception e){
//        }
//        return ResponseEntity.ok(new ObjectResponse("0", "Thêm kết quả xét nghiệm không thành công", false, null));
//    }



    @PostMapping(value = "/test-result",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addTestResult(@RequestParam("doctorId") int doctorId,
                                           @RequestParam("testFormId") int testFormId ){

        TestResult result = testResultService.addTestResult(doctorId,testFormId);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Thêm kết quả xét ngiệm không thành công",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Thêm kết quả xét nghiệm thành công",true,result));
    }

    @PostMapping(value = "/test-result-detail",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addTestResultDetail(@RequestParam("resultId") Integer resultId,
                                                 @RequestParam("imageUrl") MultipartFile imageUrl,
                                                 @RequestParam("fileUrl") MultipartFile fileUrl ){
        TestResultDetail testResultDetail = new TestResultDetail();
        TestResult testResult = testResultService.findTestResult(resultId);
        String imageUrlFirebase = firebaseStorageFileUploadService.uploadFileToFirebaseStorage(imageUrl);
        String fileUrlFirebase = firebaseStorageFileUploadService.uploadFileToFirebaseStorage(fileUrl);
        testResultDetail.setFileUrl(fileUrlFirebase);
        testResultDetail.setImageUrl(imageUrlFirebase);
        testResultDetail.setTestResult(testResult);
        testResultDetail.setActive(1);

        TestResultDetail result = testResultService.addImageTestResult(testResultDetail);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Thêm kết quả xét ngiệm không thành công",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Thêm kết quả xét nghiệm thành công",true,result));
    }

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @PutMapping(value = "/done-result",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> doneTestResult(@RequestParam(value = "testFormId") Integer testFormId){
        Boolean result = testResultService.doneResult(testFormId);

        if(!result)  return ResponseEntity.ok(new ObjectResponse("0","Thêm kết quả xét ngiệm không thành công",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Thêm kết quả xét nghiệm thành công",true,result));
    }

    @PostMapping(value = "/file-result",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addFileTestResult(@RequestParam("doctorId") Integer doctorId,
                                           @RequestParam("testFormId") Integer testFormId ){

        TestResult result = testResultService.addTestResult(doctorId,testFormId);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Thêm kết quả xét ngiệm không thành công",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Thêm kết quả xét nghiệm thành công",true,result));
    }

    @GetMapping(value = "/image-result",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<TestResultDetail> imageResult(@RequestParam("resultId") int resultId){
        return testResultService.imageTestResults(resultId);
    }

}
