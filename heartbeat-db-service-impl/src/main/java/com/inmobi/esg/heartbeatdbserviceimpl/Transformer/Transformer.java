package com.inmobi.esg.heartbeatdbserviceimpl.Transformer;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.Advertiser;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.ChannelMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.CountryMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.EventTypeMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.OsMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.PropositionMeta;
import com.inmobi.esg.heartbeatservice.entities.TAdvertiser;
import com.inmobi.esg.heartbeatservice.entities.TChannelMeta;
import com.inmobi.esg.heartbeatservice.entities.TCodeNameMetaInfo;
import com.inmobi.esg.heartbeatservice.entities.TCountryMeta;
import com.inmobi.esg.heartbeatservice.entities.TEventTypeMeta;
import com.inmobi.esg.heartbeatservice.entities.TOSMeta;
import com.inmobi.esg.heartbeatservice.entities.TPropositionMeta;


public class Transformer {
    public static TCountryMeta getTCountryMeta(final CountryMeta countryMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = new TCodeNameMetaInfo().setCode(countryMeta.getCode()).setName(
                countryMeta.getName());
        return new TCountryMeta().setCountryId(countryMeta.getCountryId()).setMeta(tCodeNameMetaInfo);
    }


    public static TOSMeta getTOSMeta(final OsMeta osMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = new TCodeNameMetaInfo().setCode(osMeta.getCode()).setName(
                osMeta.getName());
        return new TOSMeta().setOsId(osMeta.getOsId()).setMeta(tCodeNameMetaInfo);
    }


    public static TChannelMeta getTChannelMeta(final ChannelMeta channelMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = new TCodeNameMetaInfo().setCode(channelMeta.getCode()).setName(
                channelMeta.getName());
        return new TChannelMeta().setChannelId(channelMeta.getChannelId()).setMeta(tCodeNameMetaInfo);
    }


    public static TEventTypeMeta getTEventTypeMeta(final EventTypeMeta eventTypeMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = new TCodeNameMetaInfo().setCode(eventTypeMeta.getCode()).setName(
                eventTypeMeta.getName());
        return new TEventTypeMeta().setEventTypeId(eventTypeMeta.getEventTypeId()).setMeta(tCodeNameMetaInfo);
    }


    public static TPropositionMeta getTPropositionMeta(final PropositionMeta propositionMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = new TCodeNameMetaInfo().setCode(propositionMeta.getCode()).setName(
                propositionMeta.getName());
        return new TPropositionMeta().setPropositionId(propositionMeta.getPropositionId()).setMeta(tCodeNameMetaInfo);
    }


    public static TAdvertiser getTAdvertiser(final Advertiser advertiser) {
        return new TAdvertiser().setId(advertiser.getAdvertiserId()).setAccountId(advertiser.getAccountId()).setAccountMailId(
                advertiser.getEmailId()).setAccountName(advertiser.getAccountName()).setPod(advertiser.getPod())
                .setSubPod(advertiser.getSubPod()).setRoo(advertiser.getRoo()).setSubRoo(advertiser.getSubRoo())
                .setModifiedBy(advertiser.getModifiedBy());
    }
}
