package com.example.OrderMgmt.entity;


import com.example.OrderMgmt.entity.enums.CustomerType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


import javax.persistence.*;
import java.util.List;


@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerID;
    private String name;
    private CustomerType type;
    private long totalDiscount;
    private int numberOfOrders;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> orders;

    private Customer(){

    }

    public Customer(String name, CustomerType type, long totalOrderPlaced, long totalDiscount) {
        this.name = name;
        this.type = type;
        this.totalDiscount = totalDiscount;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public void setTotalDiscount(long totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }
}
