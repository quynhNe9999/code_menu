package com.quynhtd.source_code_final.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "PERSISTENT_LOGINS")
public class PersistentLogin implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SERIES", length = 64, nullable = false)
    private String series;

    @Column(name = "USERNAME", length = 64, nullable = false)
    private String userName;

    @Column(name = "TOKEN", length = 64, nullable = false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_USED", nullable = false)
    private Date lastUsed;

    
}