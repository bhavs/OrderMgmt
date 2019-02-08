package com.example.OrderMgmt.controller;


import com.example.OrderMgmt.CONSTANTS;
import com.example.OrderMgmt.entity.Customer;
import com.example.OrderMgmt.entity.CustomerOrder;
import com.example.OrderMgmt.entity.enums.CustomerType;
import com.example.OrderMgmt.helper.CustomerHelperClass;
import com.example.OrderMgmt.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOrderController {


    @Autowired
    private CustomerOrderService customerOrderService;

    static{
        CustomerHelperClass helperClass = new CustomerHelperClass();
    }

    public CustomerOrderController(CustomerOrderService customerOrderService){
        this.customerOrderService = customerOrderService;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public Iterable<CustomerOrder> list(){
        return customerOrderService.list();
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public void create(String name, long totalValue){
        CustomerOrder order = new CustomerOrder(totalValue);
        Customer customer=customerOrderService.findCustomer(name);
        if(customer.getNumberOfOrders()+1<= CONSTANTS.GOLD_ORDER) {
            int numOrders = customer.getNumberOfOrders();
            long discount = customer.getTotalDiscount();
            customer.setNumberOfOrders(numOrders++);
            customer.setTotalDiscount(0);
            customer.setType(CustomerType.Regular);
            order.setDiscountValue(0);
            order.setCustomer(customer);
        }
        else if (customer.getNumberOfOrders()+1>= CONSTANTS.GOLD_ORDER && customer.getNumberOfOrders()+1 <=CONSTANTS.PLATINUM_ORDER){
            int numOrders = customer.getNumberOfOrders();
            long discount = customer.getTotalDiscount();
            customer.setType(CustomerType.Gold);
            long updateDiscount = Math.round(totalValue*CONSTANTS.GOLD_DISCOUNT);
            customer.setTotalDiscount(discount+updateDiscount);
            customer.setNumberOfOrders(numOrders++);
            order.setDiscountValue(updateDiscount);
            order.setCustomer(customer);
        }
        customerOrderService.create(order);
    }

}
