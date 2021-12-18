package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.dao.TreatmentRegimenDAO;
import com.ptithcm.apihealthcare.entities.MedicalRecord;
import com.ptithcm.apihealthcare.entities.TreatmentRegimen;
import com.ptithcm.apihealthcare.model.reponse.TestFormResponse;
import com.ptithcm.apihealthcare.model.reponse.TreatmentRegimentResponse;
import com.ptithcm.apihealthcare.service.MedicalRecordService;
import com.ptithcm.apihealthcare.service.PrescriptionService;
import com.ptithcm.apihealthcare.service.TreatmentRegimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicalRecordRESTController {
    @Autowired
    MedicalRecordService medicalRecordService;

    @Autowired
    TreatmentRegimenService treatmentRegimenService;

    @Autowired
    PrescriptionService prescriptionService;

    @GetMapping(value = "/medical-record",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<MedicalRecord> getMedicalRecords(@RequestParam("pid") int PID){
        List<MedicalRecord> list = medicalRecordService.medicalRecordList(PID);
        return list;
    }


    @GetMapping(value = "/treatment-regiment",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<TreatmentRegimentResponse> getTreatmentRegiment(@RequestParam("medicalRecordId") int medicalRecordId){
        TreatmentRegimen treatmentRegimen = treatmentRegimenService.findTreatmentRegiment(medicalRecordId);

        TreatmentRegimentResponse treatmentRegimentResponse = new TreatmentRegimentResponse();
        treatmentRegimentResponse.setTreatmentId(treatmentRegimen.getTreatmentId());
        treatmentRegimentResponse.setDateBegin(treatmentRegimen.getDateBegin());
        treatmentRegimentResponse.setDateEnd(treatmentRegimen.getDateEnd());
        treatmentRegimentResponse.setNeeds(treatmentRegimen.getNeeds());
        treatmentRegimentResponse.setReExaminationDate(treatmentRegimen.getReExaminationDate());
        treatmentRegimentResponse.setProhibited(treatmentRegimen.getProhibited());
        treatmentRegimentResponse.setPrescriptions(prescriptionService.prescriptionList(treatmentRegimen.getTreatmentId()));

        return ResponseEntity.ok(treatmentRegimentResponse);
    }


}
