package com.mcw.mycarwash.Service;

import com.mcw.mycarwash.Dao.CustomerDao;
import com.mcw.mycarwash.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Transactional
    @Override
    public List<Customer> getCustomer() {
        return customerDao.getCustomer();
    }

    @Transactional
    @Override
    public Customer get(String id) {
        return customerDao.get(id);
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(String id) {
        customerDao.deleteCustomer(id);
    }
}
