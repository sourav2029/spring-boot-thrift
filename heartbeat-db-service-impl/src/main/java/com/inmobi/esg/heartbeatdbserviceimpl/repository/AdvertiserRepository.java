package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.Advertiser;

@Repository
public interface AdvertiserRepository extends JpaRepository<Advertiser, Integer> {
    List<Advertiser> findByAccountId(final String accountId);

    List<Advertiser> findById(final int id);
}
