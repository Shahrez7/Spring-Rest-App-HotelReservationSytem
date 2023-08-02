package com.shahrez.app.rest.HotelReservationSytem.Repo;

import com.shahrez.app.rest.HotelReservationSytem.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}