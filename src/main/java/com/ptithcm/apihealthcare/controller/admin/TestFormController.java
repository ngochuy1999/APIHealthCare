package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.entities.Subclinical;
import com.ptithcm.apihealthcare.entities.TestForm;
import com.ptithcm.apihealthcare.entities.TestFormDetail;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.SubclinicalParam;
import com.ptithcm.apihealthcare.model.request.TestFormParam;
import com.ptithcm.apihealthcare.service.TestFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class TestFormController {
    @Autowired
    private TestFormService testFormService;

    @PostMapping(value = "/create-testForm",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> createTestForm(@RequestBody TestFormParam testFormParam){

        TestForm result = testFormService.addTestForm(testFormParam);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Tạo phiếu kiểm tra",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Tạo phiếu kiểm tra thành công",true,result));
    }

    @PostMapping(value = "/subclinical-testForm",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addSubclinical(@RequestBody SubclinicalParam subclinicalParam){

        TestFormDetail result = testFormService.addSubclinical(subclinicalParam);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Thêm chỉ định lâm sàng không thành công",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Thêm chỉ định lâm sàng thành công",true,result));
    }

    @GetMapping(value = "/subclinical",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Subclinical> listSubclinical(){
        return testFormService.listSubclinical();
    }

    @GetMapping(value = "/test-form",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<TestForm> testFormList(@RequestParam ("billId") int billId){
        return testFormService.testFormList(billId);
    }

    @GetMapping(value = "/test-form-detail",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<TestFormDetail> detailList(@RequestParam ("testId") int testId){
        return testFormService.formDetailList(testId);
    }
}
