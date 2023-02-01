package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.bean.Orders;
import com.bhavna.service.OrdersService;

@RestController
public class Controller {
	
	@Autowired
	OrdersService orderService;
	
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getOrders() {
 
        List orders = orderService.getAllOrders();
        return orders;
    }
 
    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
    public Orders getOrderById(@PathVariable int id) {
        return orderService.getOrder(id);
    }
 
    @RequestMapping(value = "/order", method = RequestMethod.POST, headers = "Accept=application/json")
    public void placeOrder(@RequestBody Orders order) {
        orderService.placeOrder(order);
 
    }
 
    @RequestMapping(value = "/updateOrder", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateCountry(@RequestBody Orders order) {
        orderService.updateOrder(order);
    }
 
    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteCountry(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
    }
	

}
