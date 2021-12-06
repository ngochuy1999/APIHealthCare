package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.SpecialityDAO;
import com.ptithcm.apihealthcare.entities.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpecialityService {

    @Autowired
    SpecialityDAO specialityDAO;

    public List<Speciality> getTopSpecialities(){
        return specialityDAO.getTopSpecialities();
    }

    public List<Speciality> getListSpecialities(){
        return specialityDAO.getListSpecialities();
    }
}
