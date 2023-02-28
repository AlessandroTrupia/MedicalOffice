package com.example.MedicalOfficeTeam4Java7.services;

import com.example.MedicalOfficeTeam4Java7.entities.DoctorEntity;
import com.example.MedicalOfficeTeam4Java7.entities.PatientEntity;
import com.example.MedicalOfficeTeam4Java7.repositories.DoctorRepository;
import com.example.MedicalOfficeTeam4Java7.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientEntity> getAllPatient() {
        List<PatientEntity> patientEntityList = patientRepository.findAll();
        return patientEntityList;
    }
    public DoctorEntity createDoctor(DoctorEntity doctorEntity){
        return doctorRepository.saveAndFlush(doctorEntity);
    }

}
