package com.example.OrderMgmt.controller;


import com.example.OrderMgmt.entity.Customer;
import com.example.OrderMgmt.entity.enums.CustomerType;
import com.example.OrderMgmt.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerRepository customerRepo;

    @Autowired
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepo=customerRepository;
    }

    @RequestMapping("/")
    public Iterable<Customer> list(){
        return customerRepo.findAll();
    }

    @RequestMapping("/{type}")
    public Iterable<Customer> read(@PathVariable(value="type")CustomerType type){
        return customerRepo.findByType(type);
    }

    @RequestMapping("/{id}")
    public int read(@PathVariable(value="id") long id){
        return customerRepo.findByNumberOfOrders(id);
    }
}
