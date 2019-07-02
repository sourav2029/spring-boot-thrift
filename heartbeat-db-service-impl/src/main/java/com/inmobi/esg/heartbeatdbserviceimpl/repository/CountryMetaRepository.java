package com.inmobi.esg.heartbeatdbserviceimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.CountryMeta;

@Repository
public interface CountryMetaRepository extends JpaRepository<CountryMeta, Integer>{
    @Override
    List<CountryMeta> findAll();

    CountryMeta findByCountryId(int countryId);
}
