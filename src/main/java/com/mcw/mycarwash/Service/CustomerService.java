package com.mcw.mycarwash.Service;

import com.mcw.mycarwash.Exceptions.CustomerNotFound;
import com.mcw.mycarwash.Model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomer();

    Customer getCustomerByMobile(int mobileNumber) throws CustomerNotFound;

    Customer get(String id);

    void saveCustomer(Customer customer);

    void deleteCustomer(String id);
}
