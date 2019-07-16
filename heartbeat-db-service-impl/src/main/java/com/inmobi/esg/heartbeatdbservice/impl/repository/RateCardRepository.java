package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.RateCard;


@Transactional
@Repository
public interface RateCardRepository extends JpaRepository<RateCard, Integer> {
    List<RateCard> findByAdvertiserId(final int advertiserId);

    RateCard findByRateCardId(final int rateCardId);
}
