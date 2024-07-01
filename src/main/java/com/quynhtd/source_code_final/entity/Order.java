package com.quynhtd.source_code_final.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class Order {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String order_id;
	    private Date orderDate;
	    private double totalAmount;
	    private String status;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @OneToMany(mappedBy = "order")
	    private List<OrderDetail> orderDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	

    // Getters và setters
}
