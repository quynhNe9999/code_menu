package com.quynhtd.source_code_final.entity;



import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="CATEGORY")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "CATEGORY_ID",length = 50)
    private String categoryId;
    
    @Column(name = "NAME",length = 50)
    private String name;
    
    @Column(name = "BRAND_ID",length = 50)
    private String brandId;
    
    @Column(name = "BRAND_NAME",length = 50)
    private String brandName;

    @Column(name = "NATIONAL",length = 50)
    private String national;

    @OneToMany(mappedBy = "category")
    private List<Product> products;




}
