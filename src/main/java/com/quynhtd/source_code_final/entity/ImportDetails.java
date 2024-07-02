package com.quynhtd.source_code_final.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "IMPORT_DETAILS")
public class ImportDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "QUANTITY",length = 20)
    private int quantity;
    
    @Column(name = "UNIT_COST",length = 20)
    private double unitCost;

    @ManyToOne
    @JoinColumn(name = "imports_id")
    private Imports imports;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

	


}