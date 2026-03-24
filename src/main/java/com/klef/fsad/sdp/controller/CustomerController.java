package com.klef.fsad.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.fsad.sdp.entity.Admin;
import com.klef.fsad.sdp.entity.Customer;
import com.klef.fsad.sdp.service.CustomerService;

@RestController
@RequestMapping("customerapi")
@CrossOrigin("*")
public class CustomerController 
{
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/")
    public String customerHome() 
    {
        return "Customer Controller Demo";
    }

    @PostMapping("/registration")
    public ResponseEntity<String> customerRegistration(@RequestBody Customer c) 
    {
        try 
        {
            String output = customerService.customerRegistrationString(c);
            return ResponseEntity.status(201).body(output);
        }
        catch(Exception e) 
        {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
    @PostMapping("/login")
  public ResponseEntity<?> checkcustomerlogin(@RequestBody Customer customer) {
    try {
      Customer c=customerService.verifyCustomerLogin(customer.getUsername(),customer.getPassword());
      if(c!=null) 
      {
        return ResponseEntity.status(200).body(customer);
      }
      else 
      {
      return ResponseEntity.status(401).body("Login Invalid");  
      }
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(500).body("Internal Server Error");
      
    }
  }
}