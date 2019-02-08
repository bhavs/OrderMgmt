package com.example.OrderMgmt.service;

import com.example.OrderMgmt.entity.Customer;
import com.example.OrderMgmt.entity.enums.CustomerType;

public interface CustomerService {

    Iterable<Customer> list();
    Customer create(String name);
    void display(String name);
    void update(Long id, CustomerType type);
    void delete(long id);
    long getDiscount(long id);

}
