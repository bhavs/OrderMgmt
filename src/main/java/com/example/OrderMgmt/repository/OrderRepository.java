package com.example.OrderMgmt.repository;

import com.example.OrderMgmt.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {

    List<Long> findByOrderID(long customerID);
    long findByDiscountValue(long orderID);



}
