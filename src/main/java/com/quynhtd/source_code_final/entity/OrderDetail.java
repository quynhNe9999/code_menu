package com.quynhtd.source_code_final.entity;

import javax.persistence.*;

@Entity
public class OrderDetail {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private int quantity;
	    private double unitPrice;

	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private Order order;

	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

    // Getters và setters
}

