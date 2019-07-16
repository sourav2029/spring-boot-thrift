package com.inmobi.esg.heartbeatdbservice.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "meta_channel")
@Data
public class ChannelMeta {
    @Id
    @Column(name = "channel_id")
    private int channelId;

    @Column(name = "name", columnDefinition = "character varying(255)")
    private String name;

    @Column(name = "code", columnDefinition = "character varying(255)")
    private String code;
}
