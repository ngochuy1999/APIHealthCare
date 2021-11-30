package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.PrescriptionDAO;
import com.ptithcm.apihealthcare.dao.TreatmentRegimenDAO;
import com.ptithcm.apihealthcare.entities.Prescription;
import com.ptithcm.apihealthcare.entities.PrescriptionKey;
import com.ptithcm.apihealthcare.model.request.PrescriptionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrescriptionService {
    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @Autowired
    private TreatmentRegimenDAO treatmentRegimenDAO;

    // create prescription
    public Prescription addPrescription (PrescriptionParam prescriptionParam) {
        try {
            Prescription prescription = new Prescription();
            PrescriptionKey ik = new PrescriptionKey();
            ik.setTreatmentId(prescriptionParam.getPrescriptionId());
            ik.setMedicineName(prescriptionParam.getMedicineName());

            prescription.setId(ik);
            prescription.setDosage(prescriptionParam.getDosage());
            prescription.setQuantity(prescriptionParam.getQuantity());
            prescription.setTreatmentRegimen(treatmentRegimenDAO.findTreatmentRegimen(prescriptionParam.getPrescriptionId()));
            prescription.setActive(1);

            prescriptionDAO.addPrescription(prescription);

            return prescription;
        }catch (Exception e) {
            System.out.println("Loi" + e);
        }
        return null;
    }
}
