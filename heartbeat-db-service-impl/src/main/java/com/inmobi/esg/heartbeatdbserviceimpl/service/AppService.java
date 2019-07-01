package com.inmobi.esg.heartbeatdbserviceimpl.service;

import org.springframework.data.repository.CrudRepository;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.Advertiser;


public interface AppService extends CrudRepository<Advertiser, Long> {}
