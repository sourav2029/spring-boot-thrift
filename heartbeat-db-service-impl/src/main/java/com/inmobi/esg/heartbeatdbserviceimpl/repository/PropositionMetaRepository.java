package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.PropositionMeta;

@Repository
public interface PropositionMetaRepository extends JpaRepository<PropositionMeta, Integer>{
    @Override
    List<PropositionMeta> findAll();
}
