package com.example.OrderMgmt.service;

import com.example.OrderMgmt.CONSTANTS;
import com.example.OrderMgmt.entity.Customer;
import com.example.OrderMgmt.entity.enums.CustomerType;
import com.example.OrderMgmt.repository.CustomerRepository;
import com.example.OrderMgmt.repository.CustomerOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepo;
    private CustomerOrderRepository orderRepo;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerOrderRepository orderRepository){
       customerRepo=customerRepository;
       orderRepo=orderRepository;
    }

    @Override
    public Iterable<Customer> list() {
        return customerRepo.findAll();
    }

    @Override
    public Customer create(String name) {
       Customer customer = new Customer(name);
       customer.setType(CustomerType.Regular);
       return (customerRepo.save(new Customer(name)));
    }

    @Override
    public void display(String name) {
        Iterable<Customer> customerIter= customerRepo.findAll();
        for(Customer c : customerIter){
            System.out.println(c.toString());
        }
    }

    // this is essentially not correct because the end user would not update the type and it should happen automatically.
    @Override
    public void update(Long id, CustomerType type) {
        Customer dbCustomer= customerRepo.findByCustomerID(id);
        if(dbCustomer.getNumberOfOrders()>= CONSTANTS.GOLD_ORDER && dbCustomer.getNumberOfOrders()<=CONSTANTS.PLATINUM_ORDER)
            dbCustomer.setType(CustomerType.Gold);
        if(dbCustomer.getNumberOfOrders()>=CONSTANTS.PLATINUM_ORDER)
            dbCustomer.setType(CustomerType.Platinum);
        // check this here it is quite possible there are 2 enteries in the DB or the value of the DB has not been persisted
        customerRepo.save(dbCustomer);
    }

    @Override
    public void delete(long id) {
        customerRepo.delete(customerRepo.findByCustomerID(id));
    }

    @Override
    public long getDiscount(long id) {
        return customerRepo.findByCustomerID(id).getTotalDiscount();
    }
}
