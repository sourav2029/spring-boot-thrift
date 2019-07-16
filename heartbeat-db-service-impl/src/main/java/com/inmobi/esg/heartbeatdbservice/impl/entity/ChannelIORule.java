package com.inmobi.esg.heartbeatdbservice.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "channel_io_rule")
public class ChannelIORule {
    @Id
    @Column(name = "channel_io_rule_id")
    private Integer channelIoRuleId;

    @Column(name = "channel_adv_id")
    private String channelAdvertiserId;

    @Column(name = "io_details_id")
    private Integer ioDetailsId;

    @Column(name = "channel_id")
    private Integer channelId;

    @Column(name = "proposition_id")
    private Integer propositionId;

    @Column(name = "rate_card_id")
    private Integer rateCardId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;
}
