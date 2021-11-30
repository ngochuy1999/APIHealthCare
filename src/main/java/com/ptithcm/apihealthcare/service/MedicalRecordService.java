package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.MedicalBillDAO;
import com.ptithcm.apihealthcare.dao.MedicalRecordDAO;
import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.entities.MedicalRecord;
import com.ptithcm.apihealthcare.model.request.MedicalRecordParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicalRecordService {
    @Autowired
    MedicalRecordDAO medicalRecordDAO;

    @Autowired
    MedicalBillDAO medicalBillDAO;

    public List<MedicalRecord> medicalRecordList(int PID){
        return medicalRecordDAO.getListMedicalRecords(PID);
    }

    public MedicalRecord addMedicalRecord(MedicalRecordParam medicalRecordParam){
        try {
            MedicalRecord medicalRecord = new MedicalRecord();
            medicalRecord.setDiagnostic(medicalRecordParam.getDiagnostic());
            medicalRecord.setDrugAllergy(medicalRecordParam.getDrugAllergy());
            medicalRecord.setMedicalBill(medicalBillDAO.findMedicalBill(medicalRecordParam.getMedicalBillId()));
            medicalRecord.setActive(1);

            medicalRecordDAO.addMedicalRecords(medicalRecord);
            return medicalRecord;
        }catch (Exception e){
            return null;
        }
    }
}
