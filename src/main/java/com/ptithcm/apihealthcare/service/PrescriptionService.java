package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.*;
import com.ptithcm.apihealthcare.entities.MedicalRecord;
import com.ptithcm.apihealthcare.entities.Prescription;
import com.ptithcm.apihealthcare.entities.PrescriptionKey;
import com.ptithcm.apihealthcare.entities.TreatmentRegimen;
import com.ptithcm.apihealthcare.model.request.PrescriptionParam;
import com.ptithcm.apihealthcare.model.request.SubclinicalInTest;
import com.ptithcm.apihealthcare.model.request.TreatmentRegimenParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionService {
    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @Autowired
    private TreatmentRegimenDAO treatmentRegimenDAO;

    @Autowired
    private MedicalBillDAO medicalBillDAO;

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    @Autowired
    private MedicineDAO medicineDAO;

    // create prescription
    public MedicalRecord addPrescription (TreatmentRegimenParam treatmentRegimenParam) {
        try {
            //add medical record
            MedicalRecord medicalRecord = new MedicalRecord();
            medicalRecord.setDiagnostic(treatmentRegimenParam.getDiagnostic());
            medicalRecord.setMedicalBill(medicalBillDAO.findMedicalBill(treatmentRegimenParam.getMedicalBillId()));
            medicalRecord.setActive(1);

            medicalRecordDAO.addMedicalRecords(medicalRecord);

            //add treatment
            TreatmentRegimen treatmentRegimen = new TreatmentRegimen();

            treatmentRegimen.setMedicalRecord(medicalRecord);
            treatmentRegimen.setDateBegin(treatmentRegimenParam.getDateBegin());
            treatmentRegimen.setDateEnd(treatmentRegimenParam.getDateEnd());
            treatmentRegimen.setReExaminationDate(treatmentRegimenParam.getReExaminationDate());
            treatmentRegimen.setNeeds(treatmentRegimenParam.getNeeds());
            treatmentRegimen.setProhibited(treatmentRegimenParam.getProhibited());
            treatmentRegimen.setActive(1);

            treatmentRegimenDAO.addTreatmentRegimen(treatmentRegimen);


            //add prescription
            for (PrescriptionParam prescriptionParam : treatmentRegimenParam.getPrescriptionParamList()) {
                Prescription prescription = new Prescription();
                PrescriptionKey ik = new PrescriptionKey();
                ik.setTreatmentId(treatmentRegimen.getTreatmentId());
                ik.setMedicineId(prescriptionParam.getMedicineId());

                prescription.setId(ik);
                prescription.setMedicine(medicineDAO.findMedicine(prescriptionParam.getMedicineId()));
                prescription.setQuantity(prescriptionParam.getQuantity());
                prescription.setTreatmentRegimen(treatmentRegimen);
                prescription.setActive(1);

                prescriptionDAO.addPrescription(prescription);
            }

            return medicalRecord;
        }catch (Exception e) {
            System.out.println("Loi" + e);
        }
        return null;
    }

    public List<Prescription> prescriptionList(int treatmentId){
        return prescriptionDAO.prescriptionList(treatmentId);
    }
}
