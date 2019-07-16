package com.inmobi.esg.heartbeatdbservice.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Entity
@Table(name = "sf_advertiser")
@Data
public class Advertiser {

    @Id
    @Column(name = "advertiser_id")
    private int advertiserId;

    @Column(name = "account_id", columnDefinition = "character varying(255)")
    private String accountId;

    @Column(name = "account_name", columnDefinition = "character varying(255)")
    private String accountName;

    @Column(name = "roo")
    private String roo;

    @Column(name = "sub_roo")
    private String subRoo;

    @Column(name = "pod")
    private String pod;

    @Column(name = "sub_pod")
    private String subPod;

    @CreationTimestamp
    @Column(name = "created_on", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL")
    private Date createdOn;

    @Column(name = "modified_on", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL")
    private Date modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;
}
