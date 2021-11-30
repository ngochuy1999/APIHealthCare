package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.Doctor;
import com.ptithcm.apihealthcare.entities.Speciality;
import com.ptithcm.apihealthcare.service.DoctorService;
import com.ptithcm.apihealthcare.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeRESTController {
    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private DoctorService doctorService;


    @GetMapping(value = "/listSpeciality",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Speciality> getAllSpecialities(){
        List<Speciality> list = specialityService.getAllSpecialities();
        return list;
    }


    @GetMapping(value = "/listDoctor",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Doctor> getTopDoctors(){
        List<Doctor> list = doctorService.getTopDoctors();
        return list;
    }

    @GetMapping(value = "/allDoctor",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Doctor> getAllDoctors(){
        List<Doctor> list = doctorService.getAllDoctors();
        return list;
    }
}
