package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.MedicalRecordDAO;
import com.ptithcm.apihealthcare.dao.TreatmentRegimenDAO;
import com.ptithcm.apihealthcare.entities.TreatmentRegimen;
import com.ptithcm.apihealthcare.model.request.TreatmentRegimenParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TreatmentRegimenService {
    @Autowired
    private TreatmentRegimenDAO treatmentRegimenDAO;
    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    public TreatmentRegimen addTreatmentRegimen(TreatmentRegimenParam treatmentRegimenParam){
        try {
        TreatmentRegimen treatmentRegimen = new TreatmentRegimen();

        treatmentRegimen.setTreatmentId(treatmentRegimenParam.getTreatmentId());
        treatmentRegimen.setMedicalRecord(medicalRecordDAO.findMedicalRecords(treatmentRegimenParam.getTreatmentId()));
        treatmentRegimen.setDateBegin(treatmentRegimenParam.getDateBegin());
        treatmentRegimen.setDateEnd(treatmentRegimenParam.getDateEnd());
        treatmentRegimen.setReExaminationDate(treatmentRegimenParam.getReExaminationDate());
        treatmentRegimen.setNeeds(treatmentRegimenParam.getNeeds());
        treatmentRegimen.setProhibited(treatmentRegimenParam.getProhibited());
        treatmentRegimen.setActive(1);

        treatmentRegimenDAO.addTreatmentRegimen(treatmentRegimen);
        return treatmentRegimen;
        }catch (Exception e){
            return null;
        }

    }
}
