package com.example.OrderMgmt.service;

import com.example.OrderMgmt.entity.Customer;
import com.example.OrderMgmt.entity.CustomerOrder;
import com.example.OrderMgmt.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository){
        this.customerOrderRepository= customerOrderRepository;
    }

    @Override
    public Iterable<CustomerOrder> list() {
        return customerOrderRepository.findAll();
    }

    @Override
    public void delete(long id) {
        customerOrderRepository.deleteById(id);
    }

    @Override
    public void create(CustomerOrder order) {
        customerOrderRepository.save(order);
    }

    @Override
    public Customer findCustomer(String name) {
        return customerOrderRepository.findCustomer(name);
    }
}
