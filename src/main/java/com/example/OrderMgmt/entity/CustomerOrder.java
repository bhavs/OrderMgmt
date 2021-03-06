package com.example.OrderMgmt.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderID;
    private long discountValue;
    private long totalValue;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customer customer;

    private CustomerOrder(){

    }

    public CustomerOrder(long totalValue) {
        this.totalValue = totalValue;
    }

    public long getDiscountValue() {
        return discountValue;
    }

    public long getTotalValue() {
        return totalValue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setDiscountValue(long discountValue) {
        this.discountValue = discountValue;
    }

    public void setTotalValue(long totalValue) {
        this.totalValue = totalValue;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
