package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.Doctor;
import com.ptithcm.apihealthcare.entities.Patient;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.*;
import com.ptithcm.apihealthcare.service.AccountService;
import com.ptithcm.apihealthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AuthRESTController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private PatientService patientService;

    
    @PostMapping(value = "/login",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticateUser(@RequestBody LogInParam logInParam){
        return accountService.loginUser(logInParam.getEmail(),logInParam.getPassword());
    }

    @DeleteMapping(value = "/logout",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Void logOut(){
        return null;
    }

    @GetMapping(value = "/users",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Patient getUser(@RequestHeader(value = "id") int accId){
        return accountService.getUser(accId);
    }


    @GetMapping(value = "/doctor",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Doctor getDoctor(@RequestHeader(value = "id") int accId){
        return accountService.getDoctor(accId);
    }


    @PostMapping(value = "/signUp",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> signup(@RequestBody AccountParam accountParam){
        return accountService.signup(accountParam);
    }


    @GetMapping(value = "/profile",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> getProfile(@RequestParam("pid") int pid){
        Patient result = patientService.getProfile(pid);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Không có thông tin tài khoản",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Thông tin tài khoản",true,result));
    }

    @PostMapping(value = "/create-profile",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> createProfile(@RequestBody ProfileParam profileParam){

        Patient result = patientService.createProfile(profileParam);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Tạo tài khoản không thành công",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Tạo tài khoản thành công",true,result));
    }

    @PutMapping(value = "/changeInfo",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> changeInfo(@RequestBody EditProfileParam profileParam){
        return accountService.changeInfo(profileParam);
    }

    @PutMapping(value = "/fcm-token",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> changeFCMToken(@RequestParam("id") int id,
                                            @RequestParam("token") String token){
        return accountService.changeFCMToken(id,token);
    }

    @PutMapping(value = "/password",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> changePass(@RequestBody ChangePassParam changePassParam){
        return accountService.changePassword(changePassParam);
    }

    @GetMapping(value = "/confirmAcc",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String confirm(@RequestParam (value = "email") String email){

        boolean result = accountService.confirm(email);
        if(!result)  return "Activation failed";
        else return "Successful activation";
    }


}
