package com.example.MedicalOfficeTeam4Java7.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity
public class ReservationEntity {
    @Id
    @Column(name = "id_reservation", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "reservation_time")
    private LocalDate reservationTime;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    /*@Column(name = "status_reservation")
    private String reservationStatus;*/
    //rivedere con michele\team
    private EnumReservationStatus reservationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor")
    private DoctorEntity doctorEntityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private PatientEntity patientEntityId;

    @ManyToOne(fetch = FetchType.LAZY)
    private SecretaryEntity secretaryEntity;

    public ReservationEntity() {
    }

    public ReservationEntity(Integer id, LocalDate reservationTime, LocalDateTime dateTime, EnumReservationStatus reservationStatus, DoctorEntity doctorEntityId, PatientEntity patientEntityId, SecretaryEntity secretaryEntity) {
        this.id = id;
        this.reservationTime = reservationTime;
        this.dateTime = dateTime;
        this.reservationStatus = reservationStatus;
        this.doctorEntityId = doctorEntityId;
        this.patientEntityId = patientEntityId;
        this.secretaryEntity = secretaryEntity;
    }

    public EnumReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(EnumReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDate bookingTime) {
        this.reservationTime = bookingTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public DoctorEntity getDoctorId() {
        return doctorEntityId;
    }

    public void setDoctorId(DoctorEntity doctorEntityId) {
        this.doctorEntityId = doctorEntityId;
    }

    public PatientEntity getPatientId() {
        return patientEntityId;
    }

    public void setPatientId(PatientEntity patientEntityId) {
        this.patientEntityId = patientEntityId;
    }
}


