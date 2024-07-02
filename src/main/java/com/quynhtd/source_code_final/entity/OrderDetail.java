package com.quynhtd.source_code_final.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable{
    private static final long serialVersionUID = 1L;

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID",length = 20)
	    private Long id;
	   
	    @Column(name = "QUANTITY",length = 20)
	    private int quantity;
	    
	    @Column(name = "UNITPRICE",length = 20)
	    private double unitPrice;

	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private Order order;

	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Product product;

	
}

