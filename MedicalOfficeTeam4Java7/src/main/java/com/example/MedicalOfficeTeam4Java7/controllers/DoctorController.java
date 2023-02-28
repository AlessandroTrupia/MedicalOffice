package com.example.MedicalOfficeTeam4Java7.controllers;

import com.example.MedicalOfficeTeam4Java7.entities.DoctorEntity;
import com.example.MedicalOfficeTeam4Java7.entities.PatientEntity;
import com.example.MedicalOfficeTeam4Java7.services.DoctorService;
import com.example.MedicalOfficeTeam4Java7.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/getallpatient")
    public List<PatientEntity> getAllPatients(){
        List<PatientEntity> patientEntityList = doctorService.getAllPatient();
        return patientEntityList;
    }
    
    @PostMapping("/createdoctor")
    public DoctorEntity createDoctor(@RequestBody DoctorEntity doctorEntity){
        return doctorService.createDoctor(doctorEntity);
    }

}


