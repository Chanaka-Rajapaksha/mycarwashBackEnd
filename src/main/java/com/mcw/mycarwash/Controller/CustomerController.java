package com.mcw.mycarwash.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcw.mycarwash.Model.Customer;
import com.mcw.mycarwash.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cusapi")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @PostMapping("/customerbymobile")
    public String getCustomerByMobile(@RequestBody Customer customer) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Customer customerByMobile = customerService.getCustomerByMobile(customer.getCusMobileNumber());
        String jsonString = objectMapper.writeValueAsString(customerByMobile);
        return jsonString;

    }

    @PostMapping("/customer")
    public Customer save(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerService.get(id);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return "Customer deleted" + id;
    }
}
