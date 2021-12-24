package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.ConsultingRoom;
import com.ptithcm.apihealthcare.entities.Doctor;
import com.ptithcm.apihealthcare.entities.HospitalInfo;
import com.ptithcm.apihealthcare.entities.Speciality;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.service.ClinicService;
import com.ptithcm.apihealthcare.service.DoctorService;
import com.ptithcm.apihealthcare.service.HospitalInfoService;
import com.ptithcm.apihealthcare.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeRESTController {
    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private HospitalInfoService hospitalInfoService;


    @GetMapping(value = "/clinic",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<ConsultingRoom> getClinic(){
        return  clinicService.getClinic();
    }

    @GetMapping(value = "/topSpeciality",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Speciality> getTopSpecialities(){
        List<Speciality> list = specialityService.getTopSpecialities();
        return list;
    }

    @GetMapping(value = "/allSpeciality",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Speciality> getAllSpecialities(){
        List<Speciality> list = specialityService.getListSpecialities();
        return list;
    }

    @GetMapping(value = "/isLike",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> checkLike(@RequestParam("pid") int pid,
                                       @RequestParam("doctorId") int doctorId){
        if(doctorService.checkIsLike(pid,doctorId)) return ResponseEntity.ok(new ObjectResponse("","",true,null));
                else return ResponseEntity.ok(new ObjectResponse("","",false,null));
    }

    @GetMapping(value = "/topDoctor",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Doctor> getTopDoctors() {
        List<Doctor> list = doctorService.getListDoctors();
        return list;
    }

    @GetMapping(value = "/allDoctor",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Doctor> getAllDoctors(){
        List<Doctor> list = doctorService.getAllDoctors();
        return list;
    }

    @GetMapping(value = "/doctor_specialize",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Doctor> getDoctorsBySpecial(@RequestParam("specialId") int specialId){
        List<Doctor> list = doctorService.getListDoctorsBySpecial(specialId);
        return list;
    }

    @GetMapping(value = "/info",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public HospitalInfo getHospital(){
        HospitalInfo hospitalInfo = hospitalInfoService.getHospital();
        return hospitalInfo;
    }


}
