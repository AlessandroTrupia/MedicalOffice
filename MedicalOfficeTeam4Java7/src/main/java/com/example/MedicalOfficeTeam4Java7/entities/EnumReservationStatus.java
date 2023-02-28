package com.example.MedicalOfficeTeam4Java7.entities;

public enum EnumReservationStatus {

    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled"),
    REJECTED("Rejected");

    private final String reservationStatus;

    EnumReservationStatus(String status) {

        this.reservationStatus = status;
    }

    public String getReservationStatus() {

        return reservationStatus;
    }

}
