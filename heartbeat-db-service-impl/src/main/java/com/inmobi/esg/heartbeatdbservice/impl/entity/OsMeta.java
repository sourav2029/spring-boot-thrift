package com.inmobi.esg.heartbeatdbserviceimpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "meta_os")
@Data
public class OsMeta  {
    @Id
    @Column(name = "os_id")
    private int osId;

    @Column(name = "name", columnDefinition = "character varying(255)")
    private String name;

    @Column(name = "code", columnDefinition = "character varying(255)")
    private String code;

}
