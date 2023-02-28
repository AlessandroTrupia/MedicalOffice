package com.example.MedicalOfficeTeam4Java7.repositories;

import com.example.MedicalOfficeTeam4Java7.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Integer> {
}
