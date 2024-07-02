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
@Table(name = "APP_USER", //
       uniqueConstraints = { //
               @UniqueConstraint(name = "APP_USER_UK", columnNames = "USER_NAME"),
               @UniqueConstraint(name = "APP_USER_UK2", columnNames = "EMAIL") })
public class AppUser implements Serializable{
    private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   @Column(name = "USER_ID", length = 50, nullable = false)
   private Long userId;

   @Column(name = "USER_NAME", length = 36, nullable = false)
   private String userName;

   @Column(name = "EMAIL", length = 128, nullable = false)
   private String email;

   @Column(name = "FIRST_NAME", length = 36, nullable = true)
   private String firstName;

   @Column(name = "LAST_NAME", length = 36, nullable = true)
   private String lastName;

   @Column(name = "ENCRYTED_PASSWORD", length = 128, nullable = false)
   private String encrytedPassword;

   @Column(name = "ENABLED", length = 1, nullable = false)
   private boolean enabled;



}