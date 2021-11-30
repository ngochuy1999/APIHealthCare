package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.PatientDAO;
import com.ptithcm.apihealthcare.entities.Patient;
import com.ptithcm.apihealthcare.model.request.ProfileParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientService {
    @Autowired
    private PatientDAO patientDAO;

    public Patient getProfile(int PID){
        return patientDAO.getProfile(PID);
    }
    public Patient createProfile(ProfileParam profileParam){
        return patientDAO.createProfile(profileParam);
    }
}
