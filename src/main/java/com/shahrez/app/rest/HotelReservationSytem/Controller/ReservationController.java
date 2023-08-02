package com.shahrez.app.rest.HotelReservationSytem.Controller;
import com.shahrez.app.rest.HotelReservationSytem.Model.Reservation;
import com.shahrez.app.rest.HotelReservationSytem.Repo.GuestRepository;
import com.shahrez.app.rest.HotelReservationSytem.Repo.ReservationRepository;
import com.shahrez.app.rest.HotelReservationSytem.Repo.ReservationStatusRepository;
import com.shahrez.app.rest.HotelReservationSytem.Repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ReservationStatusRepository statusRepository;



    @GetMapping("/list")
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addReservation(@RequestBody Reservation request) {
        Reservation reservation = new Reservation();
        reservation.setRoom(roomRepository.findById(request.getRoomId()).orElse(null));
        reservation.setGuest(guestRepository.findById(request.getGuestId()).orElse(null));
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        reservation.setStatus(statusRepository.findById(request.getStatusId()).orElse(null));

        if (reservation.getRoom() == null || reservation.getGuest() == null || reservation.getStatus() == null) {
            return ResponseEntity.badRequest().body("Invalid room, guest, or status ID");
        }

        reservationRepository.save(reservation);
        return ResponseEntity.ok("Reservation added successfully");
    }

    @PutMapping("/update/{reservationId}")
    public ResponseEntity<String> updateReservation(
            @PathVariable int reservationId, @RequestBody Reservation request) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);

        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }

        reservation.setRoom(roomRepository.findById(request.getRoomId()).orElse(null));
        reservation.setGuest(guestRepository.findById(request.getGuestId()).orElse(null));
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        reservation.setStatus(statusRepository.findById(request.getStatusId()).orElse(null));

        if (reservation.getRoom() == null || reservation.getGuest() == null || reservation.getStatus() == null) {
            return ResponseEntity.badRequest().body("Invalid room, guest, or status ID");
        }

        reservationRepository.save(reservation);
        return ResponseEntity.ok("Reservation updated successfully");
    }

    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity<String> deleteReservation(@PathVariable int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);

        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }

        reservationRepository.delete(reservation);
        return ResponseEntity.ok("Reservation deleted successfully");
    }
}

