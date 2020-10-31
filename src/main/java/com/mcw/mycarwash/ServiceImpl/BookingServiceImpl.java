package com.mcw.mycarwash.ServiceImpl;

import com.mcw.mycarwash.Dao.BookingDao;
import com.mcw.mycarwash.Model.Booking;
import com.mcw.mycarwash.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public List<Booking> getBookingList(String ClientId) {
        return bookingDao.getBookingList(ClientId);
    }

    @Override
    public Booking getBooking(String ClientId, String BookingId) {
        return bookingDao.getBooking(ClientId, BookingId);
    }

    @Override
    public void addBooking(Booking booking) {
        bookingDao.addBooking(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDao.updateBooking(booking);
    }

    @Override
    public void confirmBooking(String ClientId, String BookingId, int status) {
        bookingDao.confirmBooking(ClientId, BookingId, status);
    }

    @Override
    public void cancelBooking(String ClientId, String BookingId, int status) {
        bookingDao.cancelBooking(ClientId, BookingId, status);
    }

    @Override
    public void completeBooking(String ClientId, String BookingId) {
        bookingDao.completeBooking(ClientId, BookingId);
    }
}
