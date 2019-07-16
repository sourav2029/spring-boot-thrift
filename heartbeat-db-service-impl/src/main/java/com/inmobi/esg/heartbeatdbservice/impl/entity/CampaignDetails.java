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
@Table(name = "campaign_details")
public class CampaignDetails {

    @Id
    @Column(name = "campaign_details_id")
    private Integer campaignDetailsId;

    @Column(name = "campaign_id")
    private String campaignId;

    @Column(name = "channel_id")
    private Integer channelId;

    @Column(name = "campaign_name")
    private String campaignName;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;
}
