package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.AccountDAO;
import com.ptithcm.apihealthcare.dao.ClinicDAO;
import com.ptithcm.apihealthcare.entities.ConsultingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClinicService {
    @Autowired
    private ClinicDAO clinicDAO;

    public List<ConsultingRoom> getClinic(){
        return clinicDAO.getConsultingRooms();
    }

}
