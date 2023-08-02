package com.shahrez.app.rest.HotelReservationSytem.Repo;


import com.shahrez.app.rest.HotelReservationSytem.Model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Integer> {
}
