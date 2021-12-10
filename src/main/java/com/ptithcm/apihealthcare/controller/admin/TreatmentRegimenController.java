package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.entities.MedicalRecord;
import com.ptithcm.apihealthcare.entities.Prescription;
import com.ptithcm.apihealthcare.entities.TreatmentRegimen;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.PrescriptionParam;
import com.ptithcm.apihealthcare.model.request.TreatmentRegimenParam;
import com.ptithcm.apihealthcare.service.MedicalBillStatusService;
import com.ptithcm.apihealthcare.service.PrescriptionService;
import com.ptithcm.apihealthcare.service.TreatmentRegimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class TreatmentRegimenController {
    @Autowired
    private TreatmentRegimenService treatmentRegimenService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private MedicalBillStatusService medicalBillStatusService;

//    @PostMapping(value = "/create-treatment",
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public ResponseEntity<?> createBA(@RequestBody TreatmentRegimenParam treatmentRegimenParam){
//
//        TreatmentRegimen result = treatmentRegimenService.addTreatmentRegimen(treatmentRegimenParam);
//        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Tạo bệnh án không thành công",false,null));
//        else return ResponseEntity.ok(new ObjectResponse("1","Tạo bệnh án thành công",true,result));
//    }

    @PostMapping(value = "/create-prescription",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> createPrescription(@RequestBody TreatmentRegimenParam treatmentRegimenParam){

        MedicalRecord result = prescriptionService.addPrescription(treatmentRegimenParam);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Tạo đơn thuốc không thành công",false,null));
        else {
            medicalBillStatusService.complete(treatmentRegimenParam.getMedicalBillId());
            return ResponseEntity.ok(new ObjectResponse("1","Tạo đơn thuốc thành công",true,result));
        }
    }
}
