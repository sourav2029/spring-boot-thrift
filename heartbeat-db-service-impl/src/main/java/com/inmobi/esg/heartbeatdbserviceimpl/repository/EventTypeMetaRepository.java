package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.EventTypeMeta;


public interface EventTypeMetaRepository extends JpaRepository<EventTypeMeta, Integer>{
    @Override
    List<EventTypeMeta> findAll();
}
