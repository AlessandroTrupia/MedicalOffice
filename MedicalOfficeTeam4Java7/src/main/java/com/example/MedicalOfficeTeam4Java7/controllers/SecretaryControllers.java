package com.example.MedicalOfficeTeam4Java7.controllers;

import com.example.MedicalOfficeTeam4Java7.entities.DoctorEntity;
import com.example.MedicalOfficeTeam4Java7.entities.PatientEntity;
import com.example.MedicalOfficeTeam4Java7.services.ReservationService;
import com.example.MedicalOfficeTeam4Java7.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretary")
public class SecretaryControllers {

    @Autowired
    private SecretaryService secretaryService;
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/createpatient")
    public PatientEntity createPatient(@RequestBody PatientEntity patientEntity) {
        return secretaryService.createPatient(patientEntity);
    }
    @GetMapping("/getallpatient")
    public List<PatientEntity> getAllPatient(){
        return secretaryService.getAllPatient();
    }

    @GetMapping("/getalldoctor")
    public List<DoctorEntity> getAllDoctor(){
        return secretaryService.getAllDoctor();
    }

    @GetMapping("/getpatientbyid/{id}")
    public List<PatientEntity> getPatientById(@PathVariable Integer id){
        return secretaryService.getPatientById(id);
    }
    @GetMapping("/getdoctorbyid/{id}")
    public List<DoctorEntity> getDoctorByid(@PathVariable Integer id){
        return secretaryService.getDoctorById(id);
    }

   //@PostMapping("/createreservation")
   // public Reservation createReservation(@RequestBody Reservation reservation){
   //     return secretaryService.createReservation(reservation);
   //}
}
