package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.RateCardRule;


@Repository
@Transactional
public interface RateCardRuleRepository extends JpaRepository<RateCardRule, Integer>{
    List<RateCardRule> findByRateCardId(final int rateCardId);

    RateCardRule findByRateCardRuleId(final int rateCardRuleId);
}
