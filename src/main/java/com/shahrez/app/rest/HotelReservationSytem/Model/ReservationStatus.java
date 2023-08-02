package com.shahrez.app.rest.HotelReservationSytem.Model;

import jakarta.persistence.*;

@Entity
public class ReservationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status_name")
    private String statusName;

    public ReservationStatus() {

    }

    public ReservationStatus(String statusName) {
        this.statusName = statusName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }


}

