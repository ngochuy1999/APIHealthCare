package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.reponse.PushNotificationResponse;
import com.ptithcm.apihealthcare.model.request.PushNotificationRequest;
import com.ptithcm.apihealthcare.service.MedicalBillService;
import com.ptithcm.apihealthcare.service.MedicalBillStatusService;
import com.ptithcm.apihealthcare.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class MedicalBillStatusController {
    @Autowired
    private MedicalBillStatusService medicalBillStatusService;

    @Autowired
    private PushNotificationService pushNotificationService;

    @Autowired
    private MedicalBillService medicalBillService;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @GetMapping(value = "/remind",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>remind(@RequestParam(value = "medicalId") int medicalId){
        MedicalBill medicalBill = medicalBillService.findMedicalBill(medicalId);
        pushNotificationService.sendPushNotificationToToken(new PushNotificationRequest("Health Care","Nhắc bạn đến lịch khám bệnh","https://scontent.fdad1-2.fna.fbcdn.net/v/t39.30808-6/172539822_205327314811077_8309969083014784707_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=b9115d&_nc_ohc=NZMR5Pa2rm0AX-ZTlTt&_nc_ht=scontent.fdad1-2.fna&oh=f2e8217ee92d3b417d66c07b77d85b66&oe=61AB1E38",medicalBill.getPatient().getAccount().getToken()));
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    //Join Room
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @PutMapping(value = "/joinRoom",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
        public ResponseEntity<?>joinRoom(@RequestParam(value = "medicalId") int medicalId){
        Boolean result = medicalBillStatusService.joinMedical(medicalId);
        if(result){
            MedicalBill medicalBill = medicalBillService.findMedicalBill(medicalId);
            pushNotificationService.sendPushNotificationToToken(new PushNotificationRequest("Health Care","Nhắc bạn đến lịch khám bệnh","https://scontent.fdad1-2.fna.fbcdn.net/v/t39.30808-6/172539822_205327314811077_8309969083014784707_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=b9115d&_nc_ohc=NZMR5Pa2rm0AX-ZTlTt&_nc_ht=scontent.fdad1-2.fna&oh=f2e8217ee92d3b417d66c07b77d85b66&oe=61AB1E38",medicalBill.getPatient().getAccount().getToken()));
            return ResponseEntity.ok(new ObjectResponse("200","OK",result,null));
        }else
        return ResponseEntity.ok(new ObjectResponse("404","Lỗi khi tham gia khám",result,null));
    }
    //cancel invoice
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @PutMapping(value = "/completeBill",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>complete(@RequestParam(value = "medicalId") int medicalId){
        return ResponseEntity.ok(new ObjectResponse("200","OK",medicalBillStatusService.complete(medicalId),null));
    }
    //cancel invoice
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @PutMapping(value = "/cancelBill",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>cancel(@RequestParam(value = "medicalId") int medicalId){
        return ResponseEntity.ok(new ObjectResponse("200","OK",medicalBillStatusService.cancel(medicalId),null));
    }
}
