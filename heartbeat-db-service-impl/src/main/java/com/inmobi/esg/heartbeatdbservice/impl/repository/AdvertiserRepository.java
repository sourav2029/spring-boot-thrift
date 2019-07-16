package com.inmobi.esg.heartbeatdbservice.impl.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.Advertiser;


@Repository
@Transactional
public interface AdvertiserRepository extends JpaRepository<Advertiser, Integer> {
    Advertiser findByAdvertiserId(final int advertiserId);

    @SuppressWarnings("unchecked")
    Advertiser save(final Advertiser advertiser);

    List<Advertiser> findByAccountName(String string);

    List<Advertiser> findByAccountId(String string);
}
