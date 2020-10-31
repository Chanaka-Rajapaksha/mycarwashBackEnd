package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomer();

    Customer getCustomerByMobile(int mobileNumber) ;

    Customer get(String id);

    void saveCustomer(Customer customer);

    void deleteCustomer(String id);
}
