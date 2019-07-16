package com.inmobi.esg.heartbeatdbservice.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Entity
@Data
@Table(name = "io_details")
public class IODetails {
    @Id
    @Column(name = "io_details_id")
    private Integer ioDetailId;

    @Column(name = "advertiser_id")
    private Integer advertiserId;

    @Column(name = "io_id")
    private String ioId;

    @Column(name = "parent_io_id")
    private String parentIoId;

    @Column(name = "total_budget")
    private Double totalBudget;

    @Column(name = "available_budget")
    private Double availableBudget;

    @Column(name = "io_type")
    private String ioType;

    @Column(name = "io_status")
    private String ioStatus;

    @Column(name = "vertical")
    private String vertical;

    @Column(name = "local_currency")
    private String localCurreny;

    @Column(name = "conversion_rate")
    private Double conversionRate;

    @Column(name = "agency_discount")
    private Double agencyDiscount;

    @Column(name = "advertiser_discount")
    private Double advertiserDiscount;

    @Column(name = "creative_charges")
    private Double creativeCharges;

    @Column(name = "other_charges")
    private Double otherCharges;

    @Column(name = "volume_discount")
    private Double volumeDiscount;

    @Column(name = "tax_withholding")
    private Double taxWithholding;

    @Column(name = "payment_terms")
    private Integer paymentTerms;

    @Column(name = "billing_cycle_id")
    private String billingCycleId;

    @CreationTimestamp
    @Column(name = "created_on", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL")
    private Date createdOn;

    @Column(name = "modified_on", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL")
    private Date modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_by")
    private String createdBy;

}
