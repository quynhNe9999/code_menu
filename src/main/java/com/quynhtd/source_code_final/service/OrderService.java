package com.quynhtd.source_code_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quynhtd.source_code_final.entity.Order;
import com.quynhtd.source_code_final.repository.OrderRepository;

@Service
public class OrderService {
	  @Autowired
	    private OrderRepository orderRepository;

	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    public Optional<Order> getOrderById(Long id) {
	        return orderRepository.findById(id);
	    }

	    public Order createOrder(Order Order) {
	        return orderRepository.save(Order);
	    }

	    public Order updateOrder(Long id, Order order) {
	        if (orderRepository.existsById(id)) {
	            order.setId(id);
	            return orderRepository.save(order);
	        }
	        return null;
	    }

	    public boolean deleteOrder(Long id) {
	        if (orderRepository.existsById(id)) {
	            orderRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}