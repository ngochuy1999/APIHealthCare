package com.ptithcm.apihealthcare.controller.admin;

import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.reponse.PushNotificationResponse;
import com.ptithcm.apihealthcare.model.request.NotificationParam;
import com.ptithcm.apihealthcare.model.request.PushNotificationRequest;
import com.ptithcm.apihealthcare.service.MedicalBillService;
import com.ptithcm.apihealthcare.service.MedicalBillStatusService;
import com.ptithcm.apihealthcare.service.NotificationService;
import com.ptithcm.apihealthcare.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class MedicalBillStatusController {
    @Autowired
    private MedicalBillStatusService medicalBillStatusService;

    @Autowired
    private PushNotificationService pushNotificationService;

    @Autowired
    private MedicalBillService medicalBillService;

    @Autowired
    private NotificationService notificationService;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @GetMapping(value = "/remind",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>remind(@RequestParam(value = "medicalId") int medicalId){
        MedicalBill medicalBill = medicalBillService.findMedicalBill(medicalId);
        pushNotificationService.sendPushNotificationToToken(new PushNotificationRequest("Health Care","Nhắc bạn đến giờ khám bệnh",medicalBill.getDoctor().getImageUrl(),medicalBill.getPatient().getAccount().getToken()));
        notificationService.addNotification(new NotificationParam("Nhắc bạn đến giờ khám bệnh",medicalBill.getPatient().getUserId()));
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
            pushNotificationService.sendPushNotificationToToken(new PushNotificationRequest("Health Care","Nhắc bạn vào phòng khám bệnh",medicalBill.getDoctor().getImageUrl(),medicalBill.getPatient().getAccount().getToken()));
            notificationService.addNotification(new NotificationParam("Nhắc bạn vào phòng khám bệnh",medicalBill.getPatient().getUserId()));

            List<MedicalBill> medicalBillList = medicalBillService.getAllMedicalBill2ByDoctor(medicalBill.getDoctor().getDoctorId());
            pushNotificationService.sendPushNotificationToToken(new PushNotificationRequest("Health Care","Nhắc bạn sắp đến lịch khám bệnh",medicalBill.getDoctor().getImageUrl(), medicalBillList.get(0).getPatient().getAccount().getToken()));
            notificationService.addNotification(new NotificationParam("Nhắc bạn sắp đến lịch khám bệnh",medicalBillList.get(0).getPatient().getUserId()));
            return ResponseEntity.ok(new ObjectResponse("200","OK",result,null));
        }else
        return ResponseEntity.ok(new ObjectResponse("404","Lỗi khi tham gia khám",result,null));
    }
    //complete
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @PutMapping(value = "/completeBill",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>complete(@RequestParam(value = "medicalId") int medicalId){
        return ResponseEntity.ok(new ObjectResponse("200","OK",medicalBillStatusService.complete(medicalId),null));
    }
    //cancel
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @PutMapping(value = "/cancelBill",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>cancel(@RequestParam(value = "medicalId") int medicalId){
        return ResponseEntity.ok(new ObjectResponse("200","OK",medicalBillStatusService.cancel(medicalId),null));
    }


    //end of session
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 1000)
    @PutMapping(value = "/end-session",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?>endSession(@RequestParam(value = "doctorId") int doctorId){
        List<MedicalBill> result = medicalBillService.getAllMedicalBill2ByDoctor(doctorId);
        if(result != null){
            for(MedicalBill medicalBill : result){
                medicalBillStatusService.cancel(medicalBill.getBillId());
                pushNotificationService.sendPushNotificationToToken(new PushNotificationRequest("Health Care","Đã hết giờ làm việc. Phiếu của bạn bị hủy. Hãy quay lại vào ngày mai",medicalBill.getDoctor().getImageUrl(),medicalBill.getPatient().getAccount().getToken()));
                notificationService.addNotification(new NotificationParam("Đã hết giờ làm việc. Phiếu của bạn bị hủy. Hãy quay lại vào ngày mai",medicalBill.getPatient().getUserId()));
            }
            return ResponseEntity.ok(new ObjectResponse("200","OK",true,null));
        }else
            return ResponseEntity.ok(new ObjectResponse("404","Lỗi",false,null));
    }
}
