package com.profile.service;


import com.common.profle.model.Customer;

import java.util.List;


public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> allCustomers();

    Customer getCustomerByID(int Id);

    void deleteById(int Id);
}
