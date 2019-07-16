package com.inmobi.esg.heartbeatdbservice.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "channel_io_rule_to_campaign_details_mapping")
public class ChannelIORuleToCampaignDetailsMapping {
    @Id
    @Column(name = "mapping_id")
    private Integer mappingId;

    @Column(name = "channel_io_rule_id")
    private Integer channelIoRuleId;

    @Column(name = "campaign_details_id")
    private Integer campaignDetailsId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "created_by")
    private String createdBy;

}
