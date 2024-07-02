package com.quynhtd.source_code_final.entity;


import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="SUPPLIER")
public class Supplier implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "NAME",length = 20)
    private String name;
    
    @Column(name = "CONTACT_NAME",length = 20)
    private String contactName;
    
    @Column(name = "CONTACT_PHONE",length = 20)
    private String contactPhone;
    
    @Column(name = "CONTACT_EMAIL",length = 20)
    private String contactEmail;
    
    @Column(name = "ADDRESS",length = 20)
    private String address;

    @OneToMany(mappedBy = "supplier")
    private List<Imports> imports;

	
}
