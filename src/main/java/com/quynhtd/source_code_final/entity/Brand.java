package com.quynhtd.source_code_final.entity;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="BRAND")
public class Brand implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "BRAND_ID",length = 20, nullable = false)
    private String brandId;
    
    @Column(name = "BRAND_NAME",length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;

}
