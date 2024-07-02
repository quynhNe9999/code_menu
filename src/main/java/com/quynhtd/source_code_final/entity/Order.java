package com.quynhtd.source_code_final.entity;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "ORDERS")
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID",length = 20)
	    private Long id;
	   
	    @Column(name = "ORDER_ID",length = 20)
	    private String orderId;
	    
	    @Column(name = "ORDER_DATE",length = 20)
	    private Date orderDate;
	    
	    @Column(name = "TOTAL_AMOUNT",length = 20)
	    private double totalAmount;
	    
	    @Column(name = "STATUS",length = 20)
	    private String status;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @OneToMany(mappedBy = "order")
	    private List<OrderDetail> orderDetails;

	
}
