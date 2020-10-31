package com.mcw.mycarwash.Service;

import com.mcw.mycarwash.Model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomer();

    Customer getCustomerByMobile(int mobileNumber) ;

    Customer get(String id);

    void saveCustomer(Customer customer);

    void deleteCustomer(String id);
}
