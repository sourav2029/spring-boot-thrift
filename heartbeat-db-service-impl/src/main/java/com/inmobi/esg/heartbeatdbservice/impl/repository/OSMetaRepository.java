package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.OsMeta;


@Repository
@Transactional
public interface OSMetaRepository extends JpaRepository<OsMeta, Integer> {
    @Override
    List<OsMeta> findAll();
}
