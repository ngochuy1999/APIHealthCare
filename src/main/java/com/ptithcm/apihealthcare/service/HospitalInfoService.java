package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.HospitalInfoDAO;
import com.ptithcm.apihealthcare.entities.HospitalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HospitalInfoService {
    @Autowired
    private HospitalInfoDAO hospitalInfoDAO;

    public HospitalInfo getHospital(){
        return hospitalInfoDAO.getHospital();
    }
}
