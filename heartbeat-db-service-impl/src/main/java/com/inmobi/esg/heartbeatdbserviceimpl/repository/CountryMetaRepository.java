package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.CountryMeta;


public interface CountryMetaRepository extends JpaRepository<CountryMeta, Integer>{
    @Override
    List<CountryMeta> findAll();
}
