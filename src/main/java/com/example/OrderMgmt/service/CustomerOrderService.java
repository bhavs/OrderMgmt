package com.example.OrderMgmt.service;

import com.example.OrderMgmt.entity.CustomerOrder;
import com.example.OrderMgmt.entity.Customer;

public interface CustomerOrderService {
    //create
    //delete
    //list
    Iterable<CustomerOrder> list();
    void delete(long id);
    void create(CustomerOrder order);
    Customer findCustomer(String name);

}
