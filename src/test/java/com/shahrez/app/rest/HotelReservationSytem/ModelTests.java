package com.shahrez.app.rest.HotelReservationSytem;

import com.shahrez.app.rest.HotelReservationSytem.Model.Guest;
import com.shahrez.app.rest.HotelReservationSytem.Model.Reservation;
import com.shahrez.app.rest.HotelReservationSytem.Model.ReservationStatus;
import com.shahrez.app.rest.HotelReservationSytem.Model.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class ModelTests {

    @Test
    public void testReservationModel() {
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setCheckInDate(LocalDate.of(2023, 8, 10));
        reservation.setCheckOutDate(LocalDate.of(2023, 8, 15));


        Room room = new Room();
        room.setId(1);
        reservation.setRoom(room);

        Guest guest = new Guest();
        guest.setId(1);
        reservation.setGuest(guest);

        ReservationStatus status = new ReservationStatus();
        status.setId(1);
        reservation.setStatus(status);

        assertEquals(1, reservation.getId());
        assertEquals(LocalDate.of(2023, 8, 10), reservation.getCheckInDate());
        assertEquals(LocalDate.of(2023, 8, 15), reservation.getCheckOutDate());

        assertEquals(room, reservation.getRoom());
        assertEquals(guest, reservation.getGuest());
        assertEquals(status, reservation.getStatus());
    }

    @Test
    public void testRoomModel() {
        Room room = new Room();
        room.setId(1);
        room.setRoomNumber("101");


        assertEquals(1, room.getId());
        assertEquals("101", room.getRoomNumber());
    }

    @Test
    public void testGuestModel() {
        Guest guest = new Guest();
        guest.setId(1);
        guest.setFirstName("John");
        guest.setLastName("Doe");


        assertEquals(1, guest.getId());
        assertEquals("John", guest.getFirstName());
        assertEquals("Doe", guest.getLastName());

    }
    @Test
    public void testReservationStatusModel() {
        ReservationStatus status = new ReservationStatus();
        status.setId(1);
        status.setStatusName("Active");

        assertEquals(1, status.getId());
        assertEquals("Active", status.getStatusName());
    }
}
