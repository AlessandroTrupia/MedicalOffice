package com.example.MedicalOfficeTeam4Java7.services;

import com.example.MedicalOfficeTeam4Java7.entities.ReservationEntity;
import com.example.MedicalOfficeTeam4Java7.repositories.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Grande punto di domanda
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    private final List<ReservationEntity> allReservationEntities = reservationRepository.findAll();

    public List<ReservationEntity> getAllReservations() {
        return allReservationEntities;
    }

    public ReservationEntity createReservation(ReservationEntity reservationEntity) {
        // aggiungere la logica di creazione prenotazione ??
        return reservationRepository.saveAndFlush(reservationEntity);
    }

    //Status reservation metodo a parte?
    public ReservationEntity findReservationById(Integer id) {
        return reservationRepository.findById(Math.toIntExact(Long.valueOf(id)))
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id " + id));
    }

    public ReservationEntity updateReservation(Integer id, ReservationEntity reservationEntity) {
        ReservationEntity existingReservationEntity = findReservationById(Math.toIntExact(reservationEntity.getId()));
        // update existing reservation properties ??

        existingReservationEntity.setReservationTime(reservationEntity.getReservationTime());
        existingReservationEntity.setDateTime(reservationEntity.getDateTime());
        existingReservationEntity.setPatientId(reservationEntity.getPatientId());
        existingReservationEntity.setReservationStatus(reservationEntity.getReservationStatus()); //??? status ???

        // save updated reservation to the database already existing
        return reservationRepository.saveAndFlush(existingReservationEntity);
    }

    public void deleteReservationById(Integer id) {

        reservationRepository.delete(findReservationById(id));
    }

}
