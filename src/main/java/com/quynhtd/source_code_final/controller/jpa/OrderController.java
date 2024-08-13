package com.quynhtd.source_code_final.controller.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quynhtd.source_code_final.entity.Order;
import com.quynhtd.source_code_final.service.OrderService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@Transactional 
public class OrderController {


    @Autowired
    private OrderService orderService;

//    @GetMapping
//    public List<order> getAllorders() {
//        return orderService.getAllorders();
//    }
    
    @RequestMapping(value = { "order-list" }, method = RequestMethod.GET)
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order"; // Trả về tên của view để render
    }


    @RequestMapping(value = { "order-add" }, method = RequestMethod.GET)
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = { "order-add}" }, method = RequestMethod.POST)
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @RequestMapping(value = { "order-edit/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(id, order);
        return updatedOrder != null ?
                ResponseEntity.ok(updatedOrder) :
                ResponseEntity.notFound().build();
    }

    @RequestMapping(value = { "order/{id}" }, method = RequestMethod.GET)
    public String deleteOrder(@PathVariable("id") Long id) {
        boolean deleted = orderService.deleteOrder(id);
        return "redirect:/order-list";

//        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
