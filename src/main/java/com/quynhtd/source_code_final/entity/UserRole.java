package com.quynhtd.source_code_final.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
 
@Entity
@Data
@Table(name = "USER_ROLE", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", //
                        columnNames = { "USER_ID", "ROLE_ID" }) })
public class UserRole implements Serializable{
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue
    @Column(name = "ID",length = 20, nullable = false)
    private Long id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private AppUser appUser;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private AppRole appRole;
 
    
 
}