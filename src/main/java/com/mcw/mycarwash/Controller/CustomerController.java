package com.mcw.mycarwash.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcw.mycarwash.Model.Customer;
import com.mcw.mycarwash.Model.ImageFile;
import com.mcw.mycarwash.Service.CustomerService;
import com.mcw.mycarwash.Service.DocumentCodeService;
import com.mcw.mycarwash.Service.OtpService;
import com.mcw.mycarwash.ServiceImpl.ImageFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.List;

@RestController
@RequestMapping("/cusapi")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ImageFileService fileStorageService;
    @Autowired
    private DocumentCodeService documentCodeService;
    @Autowired
    public OtpService otpModeService;


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
    public Customer save(@RequestBody Customer customer) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
//        Customer customer = mapper.readValue(model, Customer.class);
        String cusId = documentCodeService.nextDocNumber("customer", "MCWCUS");
        customer.setCusId(cusId);
        customerService.saveCustomer(customer);
        otpModeService.SendOTP(customer.getCusMobileNumber(), customer.getCusEmail());
        return customer;
    }

    @PostMapping("/customernew")
    public Customer saveNew(@RequestParam("customer") String model, @RequestParam("file") MultipartFile file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(model, Customer.class);
        String cusId = documentCodeService.nextDocNumber("customer", "MCWCUS");
        String imageId = documentCodeService.nextDocNumber("customer", "IMG");
        customer.setCusId(cusId);
        customer.setImageId(imageId);
        ImageFile fileName = fileStorageService.storeFile(file, imageId);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/getfileurl/")
                .path(fileName.getFileName())
                .toUriString();
        customer.setImageURL(fileDownloadUri);
        customerService.saveCustomer(customer);
        otpModeService.SendOTP(customer.getCusMobileNumber(), customer.getCusEmail());
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
