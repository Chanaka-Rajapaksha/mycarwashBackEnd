package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.CustomerDao;
import com.mcw.mycarwash.Model.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class CustomerDaoImpl implements CustomerDao {

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
    public List<Customer> getCustomer() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> query = currentSession.createQuery("FROM Customer", Customer.class);
        List<Customer> customersList = query.getResultList();
        return customersList;
    }

    @Override
    public Customer getCustomerByMobile(int mobileNumber) {


        Customer customer = new Customer();
        String query = "SELECT * FROM customer WHERE cus_mobile_number = '" + mobileNumber + "'";
        List<Customer> customerList = jdbcTemplate.query(query, new BeanPropertyRowMapper(Customer.class));
        for (Customer entity : customerList) {
            customer = entity;
        }
        return customer;

    }

    @Override
    public Customer get(String id) {
        //  Session currentSession = entityManager.unwrap(Session.class);
        // Customer customer = currentSession.get(Customer.class, id);
        Customer customer = new Customer();
        String query = "SELECT * FROM customer WHERE cus_id='" + id + "'";

        List<Customer> customerList = jdbcTemplate.query(query, new BeanPropertyRowMapper(Customer.class));
        for (Customer entity : customerList) {
            customer = entity;
        }
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer = currentSession.get(Customer.class, id);
        currentSession.delete(customer);
    }
}
