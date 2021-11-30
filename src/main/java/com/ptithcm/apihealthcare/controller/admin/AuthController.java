package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.model.request.*;
import com.ptithcm.apihealthcare.service.AccountService;
import com.ptithcm.apihealthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AuthController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private DoctorService doctorService;


    @PostMapping(value = "/login",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticateAdmin(@RequestBody LogInParam logInParam){
        return accountService.loginAdmin(logInParam.getEmail(),logInParam.getPassword());
    }

    @PostMapping(value = "/signUp",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> signup(@RequestBody AccountParam accountParam){
        return doctorService.signup(accountParam);
    }


}
