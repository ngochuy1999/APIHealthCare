package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.entities.Doctor;
import com.ptithcm.apihealthcare.entities.Patient;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.AccountParam;
import com.ptithcm.apihealthcare.model.request.DoctorParam;
import com.ptithcm.apihealthcare.model.request.ProfileParam;
import com.ptithcm.apihealthcare.service.AccountService;
import com.ptithcm.apihealthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AccountService accountService;


    @GetMapping(value = "/listDoctor",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Doctor> getAllDoctors(){
        List<Doctor> list = doctorService.getAllDoctors();
        return list;
    }

    @GetMapping(value = "/doctor",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Doctor getDoctor(@RequestParam("id") int doctorId){
        return accountService.getDoctor(doctorId);
    }


    @PostMapping(value = "/create-profile",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> createProfileDoctor(@RequestBody DoctorParam doctorParam){

        Doctor result = doctorService.createProfileDoctor(doctorParam);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Tạo tài khoản không thành công",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Tạo tài khoản thành công",true,result));
    }


}
