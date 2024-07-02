package com.quynhtd.source_code_final.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
@Table(name = "APP_ROLE", //
       uniqueConstraints = { //
               @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "ROLE_NAME") })
public class AppRole implements Serializable{
    private static final long serialVersionUID = 1L;

   public static final String ROLE_USER = "ROLE_USER";
   public static final String ROLE_ADMIN = "ROLE_ADMIN";
   
   @Id
   @GeneratedValue
   @Column(name = "ROLE_ID" , length = 50, nullable = false)
   private Long roleId;

   @Column(name = "ROLE_NAME", length = 30, nullable = false)
   private String roleName;

   
}
