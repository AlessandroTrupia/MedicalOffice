package com.example.MedicalOfficeTeam4Java7.controllers;

import com.example.MedicalOfficeTeam4Java7.entities.ReservationEntity;
import com.example.MedicalOfficeTeam4Java7.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create-reservation")
    public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationEntity reservationEntity) {
        ReservationEntity newReservationEntity = reservationService.createReservation(reservationEntity);
        return ResponseEntity.ok(newReservationEntity);
    }

    @GetMapping("/checkAll-reservations")
    public ResponseEntity<List<ReservationEntity>> getAllReservations() {
        List<ReservationEntity> reservationEntityList = reservationService.getAllReservations();
        return ResponseEntity.ok(reservationEntityList);
    }

    @GetMapping("check-reservation/{id}")
    public ResponseEntity<ReservationEntity> getReservationById(@PathVariable Integer id) {
        ReservationEntity reservationEntity = (ReservationEntity) reservationService.findReservationById(id);
        return ResponseEntity.ok(reservationEntity);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<String> getReservationStatus(@PathVariable Integer id) {
        String status = reservationService.findReservationById(id).toString();
        return ResponseEntity.ok(status);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<ReservationEntity> updateBooking(@PathVariable Integer id, @RequestBody ReservationEntity reservationEntity) {
        ReservationEntity updateReservationEntity = reservationService.updateReservation(id, reservationEntity);
        return ResponseEntity.ok(updateReservationEntity);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ReservationEntity> deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity.noContent().build();
    }
}
