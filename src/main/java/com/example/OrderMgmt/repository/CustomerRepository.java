package com.example.OrderMgmt.repository;

import com.example.OrderMgmt.entity.Customer;
import com.example.OrderMgmt.entity.enums.CustomerType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;


import java.util.*;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<String> findByCustomerID(long custID);
    List<Customer> findByType(CustomerType type);
    int findByNumberOfOrders(long custID);

}
