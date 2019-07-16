package com.inmobi.esg.heartbeatdbservice.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

import lombok.Data;


@Entity
@Data
@Table(name = "rate_card")
public class RateCard {

    @Id
    @Column(name = "rate_card_id")
    private Integer rateCardId;

    @Column(name = "advertiser_id")
    private Integer advertiserId;

    private String name;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;
}
