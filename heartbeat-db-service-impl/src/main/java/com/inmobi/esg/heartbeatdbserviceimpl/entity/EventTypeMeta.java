package com.inmobi.esg.heartbeatdbserviceimpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "meta_event_type")
@Data
public class EventTypeMeta {
    @Id
    @Column(name = "event_type_id")
    private int eventTypeId;

    @Column(name = "name", columnDefinition = "character varying(255)")
    private String name;

    @Column(name = "code", columnDefinition = "character varying(255)")
    private String code;
}
