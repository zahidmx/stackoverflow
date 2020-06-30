package com.profile.impl;

import java.util.List;


import com.common.profle.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.profile.service.CustomerService;
import com.profile.repository.CustomerProfileRepository;

@Service
@Transactional
public class CustomerProfileServiceImpl implements CustomerService {

    @Autowired
    private CustomerProfileRepository customerRepository;

    @Override
    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> allCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByID(int Id) {

        return customerRepository.findById(Id).get();
    }

    @Override
    public void deleteById(int Id) {
        customerRepository.deleteById(Id);
    }


}
