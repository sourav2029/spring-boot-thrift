package com.inmobi.esg.heartbeatdbserviceimpl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Entity
@Table(name = "advertiser")
@Data
public class Advertiser {

    @Id
    @Column(name = "advertiser_id")
    private int id;

    @Column(name = "account_id", columnDefinition = "character varying(255)")
    private String accountId;

    @Column(name = "account_name", columnDefinition = "character varying(255)")
    private String accountName;

    @Column(name = "account_mail_id", columnDefinition = "character varying(255)")
    private String emailId;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL")
    private Date createdOn;

    @Column(name = "deprecated_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL")
    private Date deprecatedOn;

    @Column(name = "is_active")
    private boolean active;
}
