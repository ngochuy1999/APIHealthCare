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

import java.util.List;


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
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","Kh??ng c?? th??ng tin t??i kho???n",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","Th??ng tin t??i kho???n",true,result));
    }

    @PostMapping(value = "/create-profile",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> createProfile(@RequestBody ProfileParam profileParam){

        Patient result = patientService.createProfile(profileParam);
        if(result == null)  return ResponseEntity.ok(new ObjectResponse("0","T???o t??i kho???n kh??ng th??nh c??ng",false,null));
        else return ResponseEntity.ok(new ObjectResponse("1","T???o t??i kho???n th??nh c??ng",true,result));
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

    @PutMapping(value = "/avatar",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> updateAvatar(@RequestParam("url") String url,
                                          @RequestParam("id") int id){
        return accountService.updateAvatar(url,id);
    }

    @PutMapping(value = "/cover",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> updateCover(@RequestParam("url") String url,
                                          @RequestParam("id") int id){
        return accountService.updateCover(url,id);
    }

    @GetMapping(value = "/confirmAcc",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String confirm(@RequestParam (value = "email") String email){

        boolean result = accountService.confirm(email);
        if(!result)  return "Activation failed";
        else return "Successful activation";
    }

    @GetMapping(value = "/favoriteDoctor",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Doctor> listFavDoc(@RequestParam (value = "accountId") int id){
        return accountService.listFavDoc(id);
    }


}
