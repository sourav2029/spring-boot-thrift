package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.ChannelMeta;

@Repository
public interface ChannelMetaRepository extends JpaRepository<ChannelMeta, Integer> {
    @Override
    List<ChannelMeta> findAll();

}
