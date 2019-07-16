package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.CountryMeta;

@Repository
@Transactional
public interface CountryMetaRepository extends JpaRepository<CountryMeta, Integer>{
    @Override
    List<CountryMeta> findAll();

    CountryMeta findByCountryId(int countryId);
}
