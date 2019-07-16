package com.inmobi.esg.heartbeatdbservice.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "meta_proposition")
@Data
public class PropositionMeta {
    @Id
    @Column(name = "proposition_id")
    private int propositionId;

    @Column(name = "name", columnDefinition = "character varying(255)")
    private String name;

    @Column(name = "code", columnDefinition = "character varying(255)")
    private String code;
}
