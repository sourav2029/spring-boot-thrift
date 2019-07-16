package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.EventTypeMeta;


@Repository
@Transactional
public interface EventTypeMetaRepository extends JpaRepository<EventTypeMeta, Integer>{
    @Override
    List<EventTypeMeta> findAll();
}
