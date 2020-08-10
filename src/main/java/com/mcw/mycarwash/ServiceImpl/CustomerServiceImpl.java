package com.mcw.mycarwash.ServiceImpl;

import com.mcw.mycarwash.Dao.CustomerDao;
import com.mcw.mycarwash.Exceptions.CustomerNotFound;
import com.mcw.mycarwash.Model.Customer;
import com.mcw.mycarwash.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Transactional
    @Override
    public List<Customer> getCustomer() {
        return customerDao.getCustomer();
    }

    @Override
    public Customer getCustomerByMobile(int mobileNumber) throws CustomerNotFound {
        return customerDao.getCustomerByMobile(mobileNumber);
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
