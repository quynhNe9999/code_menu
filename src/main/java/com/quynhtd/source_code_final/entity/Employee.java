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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name="EMPLOYEE")
public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20)
    private Long id;
    
    @Column(name = "EMPLOYEE_ID",length = 20)
    private String employeeId;
    
    @Column(name = "NAME",length = 20)
    private String name;
    
    @Column(name = "POSITION",length = 20)
    private String position;

    @Column(name = "SALARY",length = 20)
    private double salary;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "HIRE_DATE")
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name = "s")
    private Store store;
    
	
}

