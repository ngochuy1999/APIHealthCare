package com.ptithcm.apihealthcare.controller;

import com.ptithcm.apihealthcare.entities.MedicalRecord;
import com.ptithcm.apihealthcare.entities.Notification;
import com.ptithcm.apihealthcare.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationRESTController {
    @Autowired
    NotificationService notificationService;

    @GetMapping(value = "/notification",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Notification> getNoti(@RequestParam("pid") int PID){
        List<Notification> list = notificationService.getNotifications(PID);
        return list;
    }
}
