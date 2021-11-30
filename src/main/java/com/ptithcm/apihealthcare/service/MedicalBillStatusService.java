package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.MedicalBillStatusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicalBillStatusService {

    @Autowired
    MedicalBillStatusDAO medicalStatusDAO;

    // join room
    public Boolean joinMedical(int medicalId){
        return medicalStatusDAO.joinRoom(medicalId);
    }

    // complete
    public Boolean complete(int medicalId){
        return medicalStatusDAO.complete(medicalId);
    }

    //cancel
    public Boolean cancel(int medicalId){
        return medicalStatusDAO.cancelBill(medicalId);
    }
}
