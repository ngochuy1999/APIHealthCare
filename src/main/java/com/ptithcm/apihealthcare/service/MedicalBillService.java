package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.*;
import com.ptithcm.apihealthcare.entities.Doctor;
import com.ptithcm.apihealthcare.entities.MedicalBill;
import com.ptithcm.apihealthcare.entities.Patient;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.ChargeRequest;
import com.ptithcm.apihealthcare.model.request.MedicalBillRequest;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MedicalBillService {
    @Autowired
    DoctorDAO doctorDAO;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    MedicalBillDAO medicalBillDAO;

    @Autowired
    MedicalBillStatusDAO medicalStatusDAO;

    @Autowired
    MedicalObjectDAO medicalObjectDAO;

    public ResponseEntity<?> addMedicalBill (MedicalBillRequest medicalBillRequest) {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);

  //      || String.valueOf(now.getTime()).startsWith("Sun")
        if(hour < 8 || hour >= 18 || String.valueOf(now.getTime()).startsWith("Sun") ) {
            return ResponseEntity.ok(new ObjectResponse("0", "Chưa đến giờ đăng ký", false, null));
        }else
            if (medicalBillDAO.countBillByDoc(medicalBillRequest.getDoctorId()) >= 20) {
            return ResponseEntity.ok(new ObjectResponse("0", "Đăng kí không thành công, quá lượt khám trong ngày", false, null));
        } else if (medicalBillDAO.checkDK(medicalBillRequest.getPID(), medicalBillRequest.getDoctorId())) {
            return ResponseEntity.ok(new ObjectResponse("0", "Đăng kí khám không thành công, đã đăng ký khám hôm nay", false, null));
        } else {

            Patient customer = accountDAO.getUser(medicalBillRequest.getPID());
            Doctor doctor = doctorDAO.getDoctor(medicalBillRequest.getDoctorId());
            if(doctor == null){
                return ResponseEntity.ok(new ObjectResponse("0", "Đăng kí khám không thành công, không tồn tại bác sĩ", false, null));
            }
            MedicalBill medicalBill = new MedicalBill();

            medicalBill.setPatient(customer);
            medicalBill.setDoctor(doctor);

            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int countPatient = medicalBillDAO.getMedicalBillByDoctorOnDay(doctor.getDoctorId()).size();
            int waitTime = doctor.getTimeAdvise() * countPatient;
            calendar.add(Calendar.MINUTE, waitTime);

            medicalBill.setTimePrediction(ZonedDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault()));
            medicalBill.setDateCreate(ZonedDateTime.now());
            medicalBill.setExaminationFee(20);
            medicalBill.setMedicalBillStatus(medicalStatusDAO.getStatus(1));
            medicalBill.setMedicalObject(medicalObjectDAO.getObject(1));

            medicalBillDAO.addMedicalBill(medicalBill);
            return ResponseEntity.ok(new ObjectResponse("1", "Đăng kí khám thành công", true, medicalBill));
        }
    }

    public Boolean charge(ChargeRequest chargeRequest){
        return medicalBillDAO.charge(chargeRequest);
    }

//    public Boolean addMedicalBill (MedicalBillRequest medicalBillRequest) {
//        try {
//            Patient customer = accountDAO.getUser(medicalBillRequest.getPID());
//            Doctor doctor = doctorDAO.getDoctor(medicalBillRequest.getDoctorId());
//            MedicalBill medicalBill = new MedicalBill();
//
//            medicalBill.setPatient(customer);
//            medicalBill.setDoctor(doctor);
//
//            Date date = Date.valueOf(LocalDate.now());
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(date);
//            calendar.add(Calendar.DATE,4);
//
//            java.util.Date dateformat = calendar.getTime();
//            String result = String.valueOf(dateformat);
//            if(result.startsWith("Sun")){
//                calendar.add(Calendar.DATE,1);
//            }
//            dateformat = calendar.getTime();
//            Date deliveryDate = new Date(dateformat.getTime());
//
//            medicalBill.setDate(date);
//            medicalBill.setExaminationFee(20000);
//            medicalBill.setMedicalBillStatus(medicalStatusDAO.getStatus(1));
//            medicalBill.setMedicalObject(medicalObjectDAO.getObject(1));
//
//            medicalBillDAO.addMedicalBill(medicalBill);
//            return true;
//        }catch (Exception e) {
//            System.out.println("Loi" + e);
//        }
//        return false;
//    }

    public List<MedicalBill> getAllMedicalBillByDoctor(int doctorId){
        return medicalBillDAO.getMedicalBillByDoctor(doctorId);
    }

    public List<MedicalBill> getAllMedicalBillByPatient(int PID){
        return medicalBillDAO.getMedicalBillByPatient(PID);
    }

    public List<MedicalBill> getAllMedicalBill2ByDoctor(int doctorId){
        return medicalBillDAO.getMedicalBill2ByDoctor(doctorId);
    }

    public List<MedicalBill> getMedicalBillByDoctorOnDay(int doctorId) {
        return medicalBillDAO.getMedicalBillByDoctorOnDay(doctorId);
    }

    public List<MedicalBill> getMedicalExamineByDoctor(int PID){
        return medicalBillDAO.getMedicalExamineByDoctor(PID);
    }

    public MedicalBill findMedicalBill(int id){
        return medicalBillDAO.findMedicalBill(id);
    }

}
