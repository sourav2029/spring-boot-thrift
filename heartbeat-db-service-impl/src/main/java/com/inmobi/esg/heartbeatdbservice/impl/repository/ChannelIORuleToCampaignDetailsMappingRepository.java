package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.ChannelIORule;
import com.inmobi.esg.heartbeatdbservice.impl.entity.ChannelIORuleToCampaignDetailsMapping;


@Repository
@Transactional
public interface ChannelIORuleToCampaignDetailsMappingRepository extends JpaRepository<ChannelIORuleToCampaignDetailsMapping, Integer>{

    ChannelIORuleToCampaignDetailsMapping findByMappingId(final Integer mappingId);

    void deleteByChannelIoRuleId(List<Integer> channelIoRuleIds);
}
