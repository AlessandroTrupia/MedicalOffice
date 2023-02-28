package com.example.MedicalOfficeTeam4Java7.services;

import com.example.MedicalOfficeTeam4Java7.entities.PatientEntity;
import com.example.MedicalOfficeTeam4Java7.entities.ReservationEntity;
import com.example.MedicalOfficeTeam4Java7.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private final SecretaryService secretary;

    public PatientService(PatientRepository patientRepository, SecretaryService secretary) {
        this.patientRepository = patientRepository;
        this.secretary = secretary;
    }

    public List<PatientEntity> getAllPatients(){
        List<PatientEntity> patientEntityList = patientRepository.findAll();
        return patientEntityList;
    }

    public void requestBooking(PatientEntity patientEntity, ReservationEntity reservationEntity, LocalDateTime dateTime) {
        secretary.createReservation(patientEntity, reservationEntity, dateTime);
        System.out.println("Your reservation has been created.");
    }

    public void requestRescheduleReservation(PatientEntity patientEntity, ReservationEntity oldReservationEntity, ReservationEntity newReservationEntity) {
        secretary.rescheduleReservation(patientEntity, oldReservationEntity, newReservationEntity);
        System.out.println("Your reservation has been changed");
    }

    public void requestDeleteReservation(PatientEntity patientEntity, ReservationEntity reservationEntity) {
        secretary.deleteReservation(patientEntity, reservationEntity);
        System.out.println("Your reservation has been cancelled");
    }

    public PatientEntity getPatientById(int id) {
        return patientRepository.findById(id).get();
    }

}
