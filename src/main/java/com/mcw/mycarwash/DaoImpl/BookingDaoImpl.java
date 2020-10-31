package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.BookingDao;
import com.mcw.mycarwash.Model.Booking;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;


@Repository
public class BookingDaoImpl implements BookingDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplateName;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplateName = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Booking> getBookingList(String ClientId) {

        String query = "SELECT * FROM booking WHERE client_id='" + ClientId + "' AND isactive='" + 1 + "'";
        List<Booking> bookingList = jdbcTemplate.query(query, new BeanPropertyRowMapper(Booking.class));
        return bookingList;

    }

    @Override
    public Booking getBooking(String ClientId, String BookingId) {
        Booking booking = new Booking();
        String query = "SELECT * FROM booking WHERE client_id='" + ClientId + "' AND booking_id='" + BookingId + "'";
        List<Booking> bookingList = jdbcTemplate.query(query, new BeanPropertyRowMapper(Booking.class));
        for (Booking booking1 : bookingList) {
            booking = booking1;
        }
        return booking;
    }

    @Override
    public void addBooking(Booking booking) {
        Session session = null;
        Transaction tx = null;
        try {
            session = entityManager.unwrap(Session.class);
            tx = session.beginTransaction();
            session.persist(booking);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override

    public void updateBooking(Booking booking) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(booking);
    }

    @Override
    public void confirmBooking(String ClientId, String BookingId, int status) {
        String query = "UPDATE booking SET isconfirm=? WHERE client_id=? AND booking_id=?";
        int responce = jdbcTemplate.update(query, 1, ClientId, BookingId);
    }

    @Override
    public void cancelBooking(String ClientId, String BookingId, int status) {
        String query = "UPDATE booking SET iscancel=? WHERE client_id=? AND booking_id=?";
        int responce = jdbcTemplate.update(query, 1, ClientId, BookingId);
    }

    @Override
    public void completeBooking(String ClientId, String BookingId) {
        String query = "UPDATE booking SET isactive=? WHERE client_id=? AND booking_id=?";
        int responce = jdbcTemplate.update(query, 0, ClientId, BookingId);
    }
}
