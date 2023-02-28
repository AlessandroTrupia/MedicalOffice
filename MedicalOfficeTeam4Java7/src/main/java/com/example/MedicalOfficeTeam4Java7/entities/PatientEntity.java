package com.example.MedicalOfficeTeam4Java7.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table
@Entity
public class PatientEntity extends Persona {

    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "tax_id_code", unique = true)
    private String taxIdCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor")
    private DoctorEntity ownDoctorEntity;

    @OneToMany(mappedBy = "patientId")
    private List<ReservationEntity> reservationEntityList;

    public PatientEntity() {
    }

    public PatientEntity(Integer id, String name, String surname, String telephoneNumber, String email, Date dateOfBirth, String taxIdCode) {
        super(id, name, surname, telephoneNumber, email);
        this.dateOfBirth = dateOfBirth;
        this.taxIdCode = taxIdCode;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTaxIdCode() {
        return taxIdCode;
    }

    public void setTaxIdCode(String taxIdCode) {
        this.taxIdCode = taxIdCode;
    }

    public DoctorEntity getOwnDoctor() {
        return ownDoctorEntity;
    }

    public void setOwnDoctor(DoctorEntity ownDoctorEntity) {
        this.ownDoctorEntity = ownDoctorEntity;
    }
}
