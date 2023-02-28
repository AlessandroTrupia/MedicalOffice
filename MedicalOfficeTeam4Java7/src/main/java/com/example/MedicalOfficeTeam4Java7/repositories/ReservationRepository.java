package com.example.MedicalOfficeTeam4Java7.repositories;

import com.example.MedicalOfficeTeam4Java7.entities.PatientEntity;
import com.example.MedicalOfficeTeam4Java7.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    ReservationEntity delete(PatientEntity patientEntity, ReservationEntity reservationEntity);
}
