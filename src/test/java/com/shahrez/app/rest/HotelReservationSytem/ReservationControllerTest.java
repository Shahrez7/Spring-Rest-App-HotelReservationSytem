package com.shahrez.app.rest.HotelReservationSytem;

import com.shahrez.app.rest.HotelReservationSytem.Controller.ReservationController;
import com.shahrez.app.rest.HotelReservationSytem.Model.Guest;
import com.shahrez.app.rest.HotelReservationSytem.Model.Reservation;
import com.shahrez.app.rest.HotelReservationSytem.Model.ReservationStatus;
import com.shahrez.app.rest.HotelReservationSytem.Model.Room;
import com.shahrez.app.rest.HotelReservationSytem.Repo.GuestRepository;
import com.shahrez.app.rest.HotelReservationSytem.Repo.ReservationRepository;
import com.shahrez.app.rest.HotelReservationSytem.Repo.ReservationStatusRepository;
import com.shahrez.app.rest.HotelReservationSytem.Repo.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ReservationControllerTest {

    @InjectMocks
    private ReservationController reservationController;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private GuestRepository guestRepository;

    @Mock
    private ReservationStatusRepository statusRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        when(reservationRepository.findAll()).thenReturn(reservations);

        List<Reservation> result = reservationController.getAllReservations();

        assertEquals(reservations, result);
        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    public void testAddReservation() {
        Reservation request = new Reservation();
        Room room = new Room();
        room.setId(1);
        request.setRoom(room);
        Guest guest = new Guest();
        guest.setId(1);
        request.setGuest(guest);
        ReservationStatus status = new ReservationStatus();
        status.setId(1);
        request.setStatus(status);
        LocalDate checkInDate = LocalDate.of(2023, Month.AUGUST, 10); // Example check-in date
        LocalDate checkOutDate = LocalDate.of(2023, Month.AUGUST, 15); // Example check-out date
        request.setCheckInDate(checkInDate);
        request.setCheckOutDate(checkOutDate);
        when(roomRepository.findById(any())).thenReturn(Optional.of(room));
        when(guestRepository.findById(any())).thenReturn(Optional.of(guest));
        when(statusRepository.findById(any())).thenReturn(Optional.of(status));
        ResponseEntity<String> result = reservationController.addReservation(request);
        assertNotNull(result);
        assertEquals(ResponseEntity.ok("Reservation added successfully"), result);
        verify(roomRepository, times(1)).findById(any());
        verify(guestRepository, times(1)).findById(any());
        verify(statusRepository, times(1)).findById(any());
        verify(reservationRepository, times(1)).save(any());
    }



    @Test
    public void testDeleteReservation() {
        int reservationId = 1;
        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(new Reservation()));
        ResponseEntity<String> result = reservationController.deleteReservation(reservationId);
        assertNotNull(result);
        assertEquals(ResponseEntity.ok("Reservation deleted successfully"), result);
        verify(reservationRepository, times(1)).findById(reservationId);
        verify(reservationRepository, times(1)).delete(any());
    }
    @Test
    public void testUpdateReservation() {
        int reservationId = 1;
        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(new Reservation()));
        Reservation request = new Reservation();
        Room room = new Room();
        room.setId(1);
        request.setRoom(room);
        Guest guest = new Guest();
        guest.setId(1);
        request.setGuest(guest);
        ReservationStatus status = new ReservationStatus();
        status.setId(1);
        request.setStatus(status);
        LocalDate checkInDate = LocalDate.of(2023, Month.AUGUST, 10); // Example check-in date
        LocalDate checkOutDate = LocalDate.of(2023, Month.AUGUST, 15); // Example check-out date
        request.setCheckInDate(checkInDate);
        request.setCheckOutDate(checkOutDate);
        when(roomRepository.findById(any())).thenReturn(Optional.of(room));
        when(guestRepository.findById(any())).thenReturn(Optional.of(guest));
        when(statusRepository.findById(any())).thenReturn(Optional.of(status));

        ResponseEntity<String> result = reservationController.updateReservation(reservationId, request);

        assertNotNull(result);
        assertEquals(ResponseEntity.ok("Reservation updated successfully"), result);

        verify(reservationRepository, times(1)).findById(reservationId);
        verify(roomRepository, times(1)).findById(any());
        verify(guestRepository, times(1)).findById(any());
        verify(statusRepository, times(1)).findById(any());
        verify(reservationRepository, times(1)).save(any());
    }


}
