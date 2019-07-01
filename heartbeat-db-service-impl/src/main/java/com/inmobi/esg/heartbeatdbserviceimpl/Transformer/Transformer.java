package com.inmobi.esg.heartbeatdbserviceimpl.Transformer;

import java.util.Objects;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.CountryMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.OsMeta;
import com.inmobi.esg.heartbeatservice.entities.TCountryMeta;
import com.inmobi.esg.heartbeatservice.entities.TOSMeta;


public class Transformer {
    public static TCountryMeta getTCountryMeta(final CountryMeta countryMeta){
        final TCountryMeta tCountryMeta = new TCountryMeta();
        tCountryMeta.setCode(countryMeta.getCode());
        tCountryMeta.setCountryId(countryMeta.getCountryId());
        tCountryMeta.setName(countryMeta.getName());
        return tCountryMeta;
    }


    public static TOSMeta getTOSMeta(final OsMeta countryMeta){
        final TOSMeta tosMeta = new TOSMeta();
        tosMeta.setCode(countryMeta.getCode());
        tosMeta.setOsId(countryMeta.getOsId());
        tosMeta.setName(countryMeta.getName());
        return tosMeta;
    }
}
