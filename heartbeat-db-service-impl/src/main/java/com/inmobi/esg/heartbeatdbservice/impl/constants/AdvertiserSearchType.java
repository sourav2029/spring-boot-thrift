package com.inmobi.esg.heartbeatdbservice.impl.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inmobi.esg.heartbeatdbservice.thrift.entities.TAdvertiserSearchType;


public enum AdvertiserSearchType {
    ACCOUNT_ID,
    ACCOUNT_NAME;

    private static final Logger log = LoggerFactory.getLogger(AdvertiserSearchType.class);


    public static AdvertiserSearchType getAdvertiserSearchType(final TAdvertiserSearchType tAdvertiserSearchType) {
        if (tAdvertiserSearchType != null) {
            switch (tAdvertiserSearchType) {
                case ACCOUNT_ID:
                    return AdvertiserSearchType.ACCOUNT_ID;
                case ACCOUNT_NAME:
                    return AdvertiserSearchType.ACCOUNT_NAME;
            }
        }
        log.error("TSearchAdvertiserType cannot be null");
        return null;
    }


}
