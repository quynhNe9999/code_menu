package com.quynhtd.source_code_final.entity;



import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="CUSTOMER")
public class Customer implements Serializable{
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "NAME",length = 50)
    private String name;
    
    @Column(name = "EMAIL",length = 50)
    private String email;
    
    @Column(name = "PHONE_NUMBER",length = 50)
    private String phoneNumber;
    
    @Column(name = "ADDRESS",length = 50)
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

	
}


