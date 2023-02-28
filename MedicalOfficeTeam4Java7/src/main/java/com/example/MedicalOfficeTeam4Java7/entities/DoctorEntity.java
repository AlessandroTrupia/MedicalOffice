package com.example.MedicalOfficeTeam4Java7.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name = "doctor")
@Entity
public class DoctorEntity extends Persona {

    @Column(name ="medical_specialty")
    private String medicalSpecialty;
    @Column(name = "working_days")
    private Date workingDays;

    //Rivedere come fare le relazioni
    @OneToMany(mappedBy = "ownDoctor")
    private List<PatientEntity> patientEntityList;

    @OneToMany(mappedBy = "doctorId")
    private List<ReservationEntity> reservationEntityList;

    @ManyToOne(fetch = FetchType.LAZY)
    private SecretaryEntity secretaryEntity;

    public DoctorEntity(){}

    public DoctorEntity(Integer id, String name, String surname, String telephoneNumber, String email, String medicalSpecialty, Date workingDays) {
        super(id, name, surname, telephoneNumber, email);
        this.medicalSpecialty = medicalSpecialty;
        this.workingDays = workingDays;
    }

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public void setMedicalSpecialty(String medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }

    public Date getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Date workingDays) {
        this.workingDays = workingDays;
    }
}


