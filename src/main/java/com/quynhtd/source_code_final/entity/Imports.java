package com.quynhtd.source_code_final.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "IMPORTS")
public class Imports implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "IMPORT_DATE",length = 20)
    private Date importDate;
    
    @Column(name = "TOTAL_COST",length = 20)
    private double totalCost;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "imports")
    private List<ImportDetails> importDetails;

	
}
