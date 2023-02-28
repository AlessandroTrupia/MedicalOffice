package com.example.MedicalOfficeTeam4Java7.controllers;

import com.example.MedicalOfficeTeam4Java7.entities.DoctorEntity;
import com.example.MedicalOfficeTeam4Java7.entities.PatientEntity;
import com.example.MedicalOfficeTeam4Java7.entities.ReservationEntity;
import com.example.MedicalOfficeTeam4Java7.repositories.DoctorRepository;
import com.example.MedicalOfficeTeam4Java7.repositories.ReservationRepository;
import com.example.MedicalOfficeTeam4Java7.services.PatientService;
import com.example.MedicalOfficeTeam4Java7.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private final PatientService patientService;
    @Autowired
    private final ReservationService reservationService;
    @Autowired
    private final DoctorRepository doctorRepository;

    @Autowired
    public PatientController(ReservationRepository reservationRepository, PatientService patientService, ReservationService reservationService,
                             DoctorRepository doctorRepository) {
        this.reservationRepository = reservationRepository;
        this.patientService = patientService;
        this.reservationService = reservationService;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/{patientId}/reservations-status/{reservationId}")
    public String getReservationStatus(@PathVariable int patientId, @PathVariable int reservationId) {
        PatientEntity patientEntity = patientService.getPatientById(patientId);
        ReservationEntity reservationEntity = reservationService.findReservationById(reservationId);
        if (reservationEntity != null) {
            return reservationEntity.getReservationStatus().getReservationStatus();
        }
        return "I'm sorry, this reservation doesn't exist.";
    }


    @GetMapping("check-reservation")
    public List<ReservationEntity> checkPatientReservation(@RequestParam long id, @RequestParam PatientEntity patientEntity) {
        List<ReservationEntity> patientReservationEntity = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationService.getAllReservations()) {
            if (reservationEntity.getPatientId().equals(patientEntity.getId())) {
                patientReservationEntity.add(reservationEntity);
            }
        }
        return patientReservationEntity;
    }

    @GetMapping("/view-all-doctors")
    public List<DoctorEntity> viewDoctors(){
        List<DoctorEntity> doctorEntities = doctorRepository.findAll();
        return doctorEntities;
    }

    // chiedere a Michele se c'è una soluzione migliore perchè ho il cervello in meltdown
    @GetMapping("search-doctor")
    public DoctorEntity searchDoctor(@RequestParam int id){
        List<DoctorEntity> doctorEntities = doctorRepository.findAll();
        DoctorEntity newDoctorEntity = new DoctorEntity();
        for(DoctorEntity doctorEntity : doctorEntities){
            if(doctorEntity.getId() == id){
                newDoctorEntity = doctorEntity;
            }else{
                System.out.println("I'm sorry, the doctor isn't our structure.");
            }
        }
        return newDoctorEntity;
    }
}
