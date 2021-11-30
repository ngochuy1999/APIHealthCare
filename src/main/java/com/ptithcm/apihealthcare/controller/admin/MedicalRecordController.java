package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.entities.MedicalRecord;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.MedicalRecordParam;
import com.ptithcm.apihealthcare.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class MedicalRecordController {
    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping(value = "/medical-record",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<MedicalRecord> getMedicalRecords(@RequestParam("pid") int PID){
        List<MedicalRecord> list = medicalRecordService.medicalRecordList(PID);
        return list;
    }


    @PostMapping(value = "/medical-record",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addMedicalRecords(@RequestBody MedicalRecordParam medicalRecordParam){
        MedicalRecord medicalRecord = medicalRecordService.addMedicalRecord(medicalRecordParam);
        if(medicalRecord != null){
            return ResponseEntity.ok(new ObjectResponse("1","Ghi bệnh án thành công",true,medicalRecord));
        }else{
            return ResponseEntity.ok(new ObjectResponse("0","Ghi bệnh án thất bại",false,null));
        }
    }
}
