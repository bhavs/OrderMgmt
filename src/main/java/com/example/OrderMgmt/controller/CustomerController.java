package com.example.OrderMgmt.controller;


import com.example.OrderMgmt.entity.Customer;
import com.example.OrderMgmt.entity.enums.CustomerType;
import com.example.OrderMgmt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService= customerService;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public Iterable<Customer> list(){
        return customerService.list();
    }


    @RequestMapping(value="/{name}",method=RequestMethod.POST)
     public Customer create(@PathVariable(value="name")String name){
        return customerService.create(name);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value="id") int id){
        customerService.delete(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public void getDiscount(@PathVariable(value="id") int id){
        customerService.getDiscount(id);
    }



}
