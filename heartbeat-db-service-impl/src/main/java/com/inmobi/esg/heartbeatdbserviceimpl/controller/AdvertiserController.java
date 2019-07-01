package com.inmobi.esg.heartbeatdbserviceimpl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.Advertiser;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.AdvertiserRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.service.AppService;


@RestController
public class AdvertiserController {

    @Autowired
    private AppService appService;

    @Autowired
    private AdvertiserRepository advertiserRepository;

    @GetMapping(path = "/")
    public Advertiser get() {
        //return "Hello World";
        return appService.findById(1L).orElseThrow(RuntimeException::new);
    }

    @GetMapping(path = "/advertisers")
    public List<Advertiser> getAdvertisersById(int id){
        return advertiserRepository.findById(id);
    }
}
