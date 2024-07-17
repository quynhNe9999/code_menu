package com.quynhtd.source_code_final.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name="PRODUCT")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "PRODUCT_ID",length = 20)
    private String productId;
    
    @Column(name = "PRODUCT_NAME",length = 20)
    private String productName;
    
    @Column(name = "PRODUCT_DESCRIPSION",length = 20)
    private String productDescripsion;
    
    @Column(name = "PRODUCT_PRICE",length = 20)
    private double productPrice;

    @Lob
    @Column(name = "IMAGE", length = Integer.MAX_VALUE)
    private byte[] image;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<ImportDetails> importDetails;

	
	

//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", productId=" + productId + ", productName=" + productName + ", productDescripsion=" + productDescripsion + ", productPrice=" + productPrice + ", image="
//				+ Arrays.toString(image) + ", createDate=" + createDate + "]";
//	}
}


