package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.MedicalBillRequest;
import com.ptithcm.apihealthcare.service.MedicalBillService;
import com.ptithcm.apihealthcare.service.MedicalBillStatusService;
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

    @Autowired
    private MedicalBillStatusService medicalBillStatusService;

    //scan qrcode
    @PostMapping(value = "/medical-bill",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addInvoiceDetail(@RequestBody MedicalBillRequest medicalRequest){
        return medicalBillService.addMedicalBill(medicalRequest);
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

    @PutMapping(value = "/cancel",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>cancel(@RequestParam(value = "medicalId") int medicalId){
        return ResponseEntity.ok(new ObjectResponse("200","OK",medicalBillStatusService.cancel(medicalId),null));
    }
}
