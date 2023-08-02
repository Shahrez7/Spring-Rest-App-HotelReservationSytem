package com.shahrez.app.rest.HotelReservationSytem.Repo;

import com.shahrez.app.rest.HotelReservationSytem.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
