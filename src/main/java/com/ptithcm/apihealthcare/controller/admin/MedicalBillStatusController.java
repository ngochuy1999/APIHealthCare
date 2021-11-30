package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.service.MedicalBillStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class MedicalBillStatusController {
    @Autowired
    private MedicalBillStatusService medicalBillStatusService;

    //Join Room
    @PutMapping(value = "/joinRoom",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>joinRoom(@RequestParam(value = "medicalId") int medicalId){
        return ResponseEntity.ok(new ObjectResponse("200","OK",medicalBillStatusService.joinMedical(medicalId),null));
    }
    //cancel invoice
    @PutMapping(value = "/completeBill",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>complete(@RequestParam(value = "medicalId") int medicalId){
        return ResponseEntity.ok(new ObjectResponse("200","OK",medicalBillStatusService.complete(medicalId),null));
    }
    //cancel invoice
    @PutMapping(value = "/cancelBill",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>cancel(@RequestParam(value = "medicalId") int medicalId){
        return ResponseEntity.ok(new ObjectResponse("200","OK",medicalBillStatusService.cancel(medicalId),null));
    }
}
