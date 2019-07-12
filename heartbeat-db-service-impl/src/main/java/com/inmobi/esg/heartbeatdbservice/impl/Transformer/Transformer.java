package com.inmobi.esg.heartbeatdbserviceimpl.Transformer;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.Advertiser;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.ChannelMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.CountryMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.EventTypeMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.OsMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.PropositionMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TAdvertiser;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TChannelMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCodeNameMetaInfo;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCountryMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TEventTypeMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TOSMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TPropositionMeta;


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
        return new TAdvertiser().setId(advertiser.getAdvertiserId()).setAccountId(advertiser.getAccountId())
                .setAccountName(advertiser.getAccountName()).setPod(
                        advertiser.getPod()).setSubPod(advertiser.getSubPod()).setRoo(advertiser.getRoo()).setSubRoo(
                        advertiser.getSubRoo()).setModifiedBy(advertiser.getModifiedBy());
    }


    public static PropositionMeta getPropositionMeta(final TPropositionMeta tPropositionMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = tPropositionMeta.getMeta();
        final PropositionMeta propositionMeta = new PropositionMeta();
        propositionMeta.setPropositionId(tPropositionMeta.getPropositionId());
        propositionMeta.setCode(tCodeNameMetaInfo.getCode());
        propositionMeta.setName(tCodeNameMetaInfo.getName());
        return propositionMeta;
    }


    public static OsMeta getOSMeta(final TOSMeta tosMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = tosMeta.getMeta();
        final OsMeta osMeta = new OsMeta();
        osMeta.setOsId(tosMeta.getOsId());
        osMeta.setCode(tCodeNameMetaInfo.getCode());
        osMeta.setName(tCodeNameMetaInfo.getName());
        return osMeta;
    }


    public static ChannelMeta getChannelMeta(final TChannelMeta tChannelMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = tChannelMeta.getMeta();
        final ChannelMeta channelMeta = new ChannelMeta();
        channelMeta.setChannelId(tChannelMeta.getChannelId());
        channelMeta.setCode(tCodeNameMetaInfo.getCode());
        channelMeta.setName(tCodeNameMetaInfo.getName());
        return channelMeta;
    }


    public static EventTypeMeta getEventTypeMeta(final TEventTypeMeta tEventTypeMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = tEventTypeMeta.getMeta();
        final EventTypeMeta eventTypeMeta = new EventTypeMeta();
        eventTypeMeta.setEventTypeId(tEventTypeMeta.getEventTypeId());
        eventTypeMeta.setCode(tCodeNameMetaInfo.getCode());
        eventTypeMeta.setName(tCodeNameMetaInfo.getName());
        return eventTypeMeta;
    }

    public static CountryMeta getCountryMeta(final TCountryMeta tCountryMeta) {
        final TCodeNameMetaInfo tCodeNameMetaInfo = tCountryMeta.getMeta();
        final CountryMeta countryMeta = new CountryMeta();
        countryMeta.setCountryId(tCountryMeta.getCountryId());
        countryMeta.setCode(tCodeNameMetaInfo.getCode());
        countryMeta.setName(tCodeNameMetaInfo.getName());
        return countryMeta;
    }
}
