package com.example.OrderMgmt.repository;

import com.example.OrderMgmt.entity.Customer;
import com.example.OrderMgmt.entity.CustomerOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {

    List<Long> findByOrderID(long customerID);
    long findByDiscountValue(long orderID);
    @Query("select c from Customer c where c.name like ?1 ")
    Customer findCustomer(String name);


}
