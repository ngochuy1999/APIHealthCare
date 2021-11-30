package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.service.MedicalBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class MedicalBillController {
    @Autowired
    private MedicalBillService medicalBillService;

    @GetMapping(value = "/medical-bill",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<MedicalBill> getMedicalBill(@RequestParam("doctorId") int id){
        List<MedicalBill> list = medicalBillService.getAllMedicalBill2ByDoctor(id);
        return list;
    }
    @GetMapping(value = "/medical-bill-examine",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public MedicalBill getMedicalExamine(@RequestParam("doctorId") int id){
        MedicalBill medicalBill = medicalBillService.getMedicalExamineByDoctor(id);
        return medicalBill;
    }
}
