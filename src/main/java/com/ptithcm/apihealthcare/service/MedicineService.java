package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.MedicineDAO;
import com.ptithcm.apihealthcare.entities.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineDAO medicineDAO;

    public List<Medicine> medicineList(){
        return medicineDAO.getMedicine();
    }
}
