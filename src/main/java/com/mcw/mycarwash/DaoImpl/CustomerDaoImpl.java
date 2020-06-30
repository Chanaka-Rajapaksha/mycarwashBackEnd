package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.CustomerDao;
import com.mcw.mycarwash.Model.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getCustomer() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> query = currentSession.createQuery("FROM Customer", Customer.class);
        List<Customer> customersList = query.getResultList();
        return customersList;
    }

    @Override
    public Customer get(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer = currentSession.get(Customer.class, id);
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
        Customer customer = currentSession.get(Customer.class,id);
        currentSession.delete(customer);
    }
}
