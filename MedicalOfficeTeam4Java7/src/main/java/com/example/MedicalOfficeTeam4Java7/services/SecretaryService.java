package com.example.MedicalOfficeTeam4Java7.services;

import com.example.MedicalOfficeTeam4Java7.entities.DoctorEntity;
import com.example.MedicalOfficeTeam4Java7.entities.PatientEntity;
import com.example.MedicalOfficeTeam4Java7.entities.ReservationEntity;
import com.example.MedicalOfficeTeam4Java7.repositories.DoctorRepository;
import com.example.MedicalOfficeTeam4Java7.repositories.PatientRepository;
import com.example.MedicalOfficeTeam4Java7.repositories.ReservationRepository;
import com.example.MedicalOfficeTeam4Java7.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecretaryService {
    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ReservationRepository reservationRepository;


    public List<PatientEntity> getAllPatient() {
        List<PatientEntity> patientEntityList = patientRepository.findAll();
        return patientEntityList;
}
    public PatientEntity createPatient(PatientEntity patientEntity) {
        return patientRepository.saveAndFlush(patientEntity);
    }

    public List<DoctorEntity> getAllDoctor(){
        List<DoctorEntity> doctorEntityList = doctorRepository.findAll();
        return doctorEntityList;
    }

    public List<DoctorEntity> getDoctorById(Integer id) {
        return getAllDoctor().stream().filter(doctor -> doctor.getId().equals(id)).collect(Collectors.toList());
    }

    public List<PatientEntity> getPatientById(Integer id){
        return getAllPatient().stream().filter(patient -> patient.getId().equals(id)).collect(Collectors.toList());
    }

   public ReservationEntity createReservation(PatientEntity patientEntity, ReservationEntity reservationEntity, LocalDateTime dateTime) {
        return reservationRepository.saveAndFlush(reservationEntity);
    }

    public ReservationEntity rescheduleReservation(PatientEntity patientEntity, ReservationEntity reservationEntity, ReservationEntity newReservationEntity){
        reservationEntity.setDateTime(newReservationEntity.getDateTime());
        return reservationEntity;
    }

    public ReservationEntity deleteReservation(PatientEntity patientEntity, ReservationEntity reservationEntity){
        return reservationRepository.delete(patientEntity, reservationEntity);
    }
}
