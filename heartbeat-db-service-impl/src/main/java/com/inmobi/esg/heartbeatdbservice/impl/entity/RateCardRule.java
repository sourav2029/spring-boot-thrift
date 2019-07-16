package com.inmobi.esg.heartbeatdbservice.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "rate_card_rule")
public class RateCardRule {

    @Id
    @Column(name = "rate_card_rule_id")
    private int rateCardRuleId;

    @Column(name = "rate_card_id")
    private int rateCardId;

    @Column(name = "country_id")
    private int countryId;

    @Column(name = "os_id")
    private int osId;

    @Column(name = "billing_model_id")
    private int billingModelId;

    @Column(name = "event_type_id")
    private int eventTypeId;

    @Column(name = "proposition_id")
    private int propositionId;

    private Double value;
}
