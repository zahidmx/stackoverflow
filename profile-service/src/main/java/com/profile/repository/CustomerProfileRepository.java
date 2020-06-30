package com.profile.repository;


import com.common.profle.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerProfileRepository extends JpaRepository<Customer, Integer> {


}
