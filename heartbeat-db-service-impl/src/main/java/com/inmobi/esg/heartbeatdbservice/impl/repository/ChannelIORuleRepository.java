package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.ChannelIORule;

@Repository
@Transactional
public interface ChannelIORuleRepository extends JpaRepository<ChannelIORule, Integer> {
    List<ChannelIORule> findByIoDetailsIdIn(final List<Integer> ioDetailsId);

    ChannelIORule findByChannelIoRuleId(final int channelIoRuleId);

}