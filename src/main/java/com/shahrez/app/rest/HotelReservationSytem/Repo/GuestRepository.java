package com.shahrez.app.rest.HotelReservationSytem.Repo;

import com.shahrez.app.rest.HotelReservationSytem.Model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
