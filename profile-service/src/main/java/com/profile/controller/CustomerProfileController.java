package com.profile.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.websocket.server.PathParam;

import com.common.profle.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import com.profile.service.CustomerService;

@RestController
@RequestMapping(value = "/services")

public class CustomerProfileController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting() {
        return "Hello Spring Boot";
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> allCustomers() {
        SecurityContext ga = SecurityContextHolder.getContext();//.getAuthentication().getAuthorities();
        return customerService.allCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable int id) {
        return customerService.getCustomerByID(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.DELETE)
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteById(customer.getId());
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

}
