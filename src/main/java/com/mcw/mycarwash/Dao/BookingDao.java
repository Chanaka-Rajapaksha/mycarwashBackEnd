package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.Booking;

import java.util.List;

public interface BookingDao {

    List<Booking> getBookingList(String ClientId);

    Booking getBooking(String ClientId, String BookingId);

    void addBooking(Booking booking);

    void updateBooking(Booking booking);

    void confirmBooking(String ClientId, String BookingId, int status);

    void cancelBooking(String ClientId, String BookingId, int status);

    void completeBooking(String ClientId, String BookingId);
}
