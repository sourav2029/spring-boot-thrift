package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.ChannelMeta;

@Repository
@Transactional
public interface ChannelMetaRepository extends JpaRepository<ChannelMeta, Integer> {
    @Override
    List<ChannelMeta> findAll();

}
