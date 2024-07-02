package com.quynhtd.source_code_final.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_CONNECTION")
public class UserConnection implements Serializable {

    private static final long serialVersionUID = -6991752510891411572L;

    @Id
    @Column(name = "USER_ID", length = 255, nullable = false)
    private String userId;

    @Id
    @Column(name = "PROVIDERID", length = 255, nullable = false)
    private String providerId;

    @Id
    @Column(name = "PROVIDER_USER_ID", length = 255, nullable = false)
    private String providerUserId;

    @Column(name = "RANK", nullable = false)
    private int rank;

    @Column(name = "DISPLAY_NAME", length = 255, nullable = true)
    private String displayName;

    @Column(name = "PROFILE_URL", length = 512, nullable = true)
    private String profileUrl;

    @Column(name = "IMAGE_URL", length = 512, nullable = true)
    private String imageUrl;

    @Column(name = "ACCESS_TOKEN", length = 512, nullable = true)
    private String accessToken;

    @Column(name = "SECRET", length = 512, nullable = true)
    private String secret;

    @Column(name = "REFRESH_TOKEN", length = 512, nullable = true)
    private String refreshToken;

    @Column(name = "EXPIRE_TIME", nullable = true)
    private Long expireTime;

    
}