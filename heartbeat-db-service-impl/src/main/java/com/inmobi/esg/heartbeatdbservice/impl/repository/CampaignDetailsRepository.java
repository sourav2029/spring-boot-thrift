package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.CampaignDetails;


public interface CampaignDetailsRepository extends JpaRepository<CampaignDetails, Integer> {

    CampaignDetails findByCampaignDetailsId(final int campaignDetailsId);
}
