package com.example.MedicalOfficeTeam4Java7.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table
@Entity
public class SecretaryEntity extends Persona {

    @Column(name = "working_days")
    private Date workingDays;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private List<DoctorEntity> doctorEntityList;

    // private Doctor doctor;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservation")
    private List<ReservationEntity> reservationEntityList;
    // private Reservation reservation;

    public SecretaryEntity(){}

    public SecretaryEntity(Integer id, String name, String surname, String telephoneNumber, String email, Date workingDays, List<DoctorEntity> doctorEntityList, List<ReservationEntity> reservationEntityList) {
        super(id, name, surname, telephoneNumber,email);
        this.workingDays = workingDays;
        this.doctorEntityList = doctorEntityList;
        this.reservationEntityList = reservationEntityList;
    }

    public Date getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Date workingDays) {
        this.workingDays = workingDays;
    }

    public List<DoctorEntity> getDoctorList() {
        return doctorEntityList;
    }

    public void setDoctorList(List<DoctorEntity> doctorEntityList) {
        this.doctorEntityList = doctorEntityList;
    }

    public List<ReservationEntity> getReservationList() {
        return reservationEntityList;
    }

    public void setReservationList(List<ReservationEntity> reservationEntityList) {
        this.reservationEntityList = reservationEntityList;
    }
}
