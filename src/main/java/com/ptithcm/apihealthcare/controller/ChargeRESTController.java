package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.ChargeRequest;
import com.ptithcm.apihealthcare.model.request.LogInParam;
import com.ptithcm.apihealthcare.service.MedicalBillService;
import com.ptithcm.apihealthcare.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ChargeRESTController {

    @Autowired
    StripeService stripeService;

    @Autowired
    MedicalBillService medicalBillService;

    @PostMapping(value = "/charge",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> chargeBill(@RequestBody ChargeRequest chargeRequest) throws StripeException {
        ResponseEntity<ObjectResponse> charge = stripeService.charge(chargeRequest);
        if(Objects.requireNonNull(charge.getBody()).isStatus()) {
             Boolean result = medicalBillService.charge(chargeRequest);
             if (result){
                 return ResponseEntity.ok(new ObjectResponse("1","Thanh toán thành công",true, charge.getBody().getData()));
             }else {
                 return ResponseEntity.ok(new ObjectResponse("0", "Thanh toán lỗi/ Backend sai", false, null));
             }
        }else{
            return ResponseEntity.ok(new ObjectResponse("0",charge.getBody().getMessage(),false, null));
        }
    }

}
