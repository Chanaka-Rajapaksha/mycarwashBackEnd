package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Exceptions.ResponseMessage;
import com.mcw.mycarwash.Model.Booking;
import com.mcw.mycarwash.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/getAllBooking/{ClientId}")
    public List<Booking> getBookingList(@PathVariable String ClientId) {
        return bookingService.getBookingList(ClientId);
    }

    @GetMapping("/getBooking/{ClientId}/{BookingId}")
    public Booking getBooking(@PathVariable String ClientId, @PathVariable String BookingId) {
        return bookingService.getBooking(ClientId, BookingId);
    }

    @PostMapping("/addBooking")
    ResponseEntity<ResponseMessage> addBooking(@RequestBody Booking booking) {
        String message = "";
        try {
            bookingService.addBooking(booking);
            message = "successfully: " + booking.getBookingId();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Unsuccessfully: " + booking.getBookingId() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }


    }

    @PostMapping("/editBooking")
    public void updateBooking(@RequestBody Booking booking) {
        bookingService.updateBooking(booking);
    }

    @PostMapping("/confirmBooking/{ClientId}/{BookingId}/{status}")
    public void confirmBooking(@PathVariable String ClientId, @PathVariable String BookingId, @PathVariable int status) {
        bookingService.confirmBooking(ClientId, BookingId, status);
    }

    @PostMapping("/cancelBooking/{ClientId}/{BookingId}/{status}")
    public void cancelBooking(@PathVariable String ClientId, @PathVariable String BookingId, @PathVariable int status) {
        bookingService.cancelBooking(ClientId, BookingId, status);
    }

    @PostMapping("/completelBooking/{ClientId}/{BookingId}")
    public void completeBooking(@PathVariable String ClientId, @PathVariable String BookingId) {
        bookingService.completeBooking(ClientId, BookingId);
    }
}
