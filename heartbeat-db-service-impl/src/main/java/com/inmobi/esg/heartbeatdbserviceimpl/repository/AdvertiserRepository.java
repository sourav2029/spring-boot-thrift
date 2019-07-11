package com.inmobi.esg.heartbeatdbserviceimpl.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.Advertiser;

@Repository
public interface AdvertiserRepository extends JpaRepository<Advertiser, Integer> {
    Advertiser findByAdvertiserId(final int advertiserId);

    @SuppressWarnings("unchecked")
    Advertiser save(final Advertiser advertiser);
}
