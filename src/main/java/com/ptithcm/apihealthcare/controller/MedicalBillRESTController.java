package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.MedicalBillRequest;
import com.ptithcm.apihealthcare.service.MedicalBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicalBillRESTController {
    @Autowired
    private MedicalBillService medicalBillService;

    //scan qrcode
    @PostMapping(value = "/medical-bill",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addInvoiceDetail(@RequestBody MedicalBillRequest medicalRequest){
        MedicalBill result = medicalBillService.addMedicalBill(medicalRequest);
        if(result != null){
            return ResponseEntity.ok(new ObjectResponse("1","Đăng kí khám thành công",true,result));
        }else{
            return ResponseEntity.ok(new ObjectResponse("0","Đăng kí khám không thành công",false,null));
        }
    }

    @GetMapping(value = "/consultation",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<MedicalBill> getMedicalBillByDoctor(@RequestParam("doctorId") int doctorId){
        List<MedicalBill> list = medicalBillService.getAllMedicalBillByDoctor(doctorId);
        return list;
    }

    @GetMapping(value = "/consultation-patient",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<MedicalBill> getMedicalBillByPatient(@RequestParam("PID") int PID){
        List<MedicalBill> list = medicalBillService.getAllMedicalBillByPatient(PID);
        return list;
    }
}
