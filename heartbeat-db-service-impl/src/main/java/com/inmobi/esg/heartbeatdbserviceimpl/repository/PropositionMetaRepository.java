package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.PropositionMeta;


public interface PropositionMetaRepository extends JpaRepository<PropositionMeta, Integer>{
    @Override
    List<PropositionMeta> findAll();
}
