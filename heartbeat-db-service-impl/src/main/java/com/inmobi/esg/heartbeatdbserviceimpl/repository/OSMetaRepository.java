package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.OsMeta;


public interface OSMetaRepository extends JpaRepository<OsMeta, Integer> {
    @Override
    List<OsMeta> findAll();
}
