package com.inmobi.esg.heartbeatdbserviceimpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "meta_country")
@Data
public class CountryMeta {
    @Id
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "name", columnDefinition = "character varying(255)")
    private String name;

    @Column(name = "code", columnDefinition = "character varying(255)")
    private String code;
}
