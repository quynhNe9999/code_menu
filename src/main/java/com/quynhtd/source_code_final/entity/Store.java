package com.quynhtd.source_code_final.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="STORE")
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "NAME",length = 20)
    private String name;
    
    @Column(name = "ADDRESS",length = 20)
    private String address;
    
    @Column(name = "PHONE_NUMBER",length = 20)
    private String phoneNumber;
    
    @Column(name = "EMAIL",length = 20)
    private String email;

    @OneToMany(mappedBy = "store")
    private List<Employee> employees;

	
}

