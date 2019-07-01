package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.ChannelMeta;


public interface ChannelMetaRepository extends JpaRepository<ChannelMeta, Integer>{
    @Override
    List<ChannelMeta> findAll();
}
