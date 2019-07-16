package com.inmobi.esg.heartbeatdbservice.impl.Transformer;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;

import com.inmobi.esg.heartbeatdbservice.impl.entity.Advertiser;
import com.inmobi.esg.heartbeatdbservice.impl.entity.CampaignDetails;
import com.inmobi.esg.heartbeatdbservice.impl.entity.ChannelIORule;
import com.inmobi.esg.heartbeatdbservice.impl.entity.ChannelIORuleToCampaignDetailsMapping;
import com.inmobi.esg.heartbeatdbservice.impl.entity.ChannelMeta;
import com.inmobi.esg.heartbeatdbservice.impl.entity.CountryMeta;
import com.inmobi.esg.heartbeatdbservice.impl.entity.EventTypeMeta;
import com.inmobi.esg.heartbeatdbservice.impl.entity.IODetails;
import com.inmobi.esg.heartbeatdbservice.impl.entity.OsMeta;
import com.inmobi.esg.heartbeatdbservice.impl.entity.PropositionMeta;
import com.inmobi.esg.heartbeatdbservice.impl.entity.RateCard;
import com.inmobi.esg.heartbeatdbservice.impl.entity.RateCardRule;
import com.inmobi.esg.heartbeatdbservice.impl.utils.DateUtil;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TAdvertiser;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCampaignDetails;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TChannelIoRule;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TChannelIoRuleToCampaignDetailsMapping;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TChannelMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCodeNameMetaInfo;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCountryMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TEventTypeMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TIoDetails;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TOSMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TPropositionMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TRateCard;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TRateCardRule;


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
                .setAccountName(advertiser.getAccountName()).setPod(advertiser.getPod()).setSubPod(
                        advertiser.getSubPod()).setRoo(advertiser.getRoo()).setSubRoo(advertiser.getSubRoo())
                .setModifiedBy(advertiser.getModifiedBy()).setCreatedOn(DateUtil.getDateStr(advertiser.getCreatedOn()))
                .setModifiedOn(DateUtil.getDateStr(advertiser.getModifiedOn()));
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


    public static TRateCard getTRateCard(final RateCard rateCard) {
        return new TRateCard().setId(rateCard.getRateCardId()).setSfAdvertiserId(rateCard.getAdvertiserId()).setName(
                rateCard.getName()).setCreatedOn(DateUtil.getDateStr(rateCard.getCreatedOn())).setCreatedBy(
                rateCard.getCreatedBy());
    }


    public static RateCard getRateCard(final TRateCard tRateCard) {
        final RateCard rateCard = new RateCard();
        rateCard.setRateCardId(tRateCard.getId());
        rateCard.setAdvertiserId(tRateCard.getSfAdvertiserId());
        rateCard.setName(tRateCard.getName());
        rateCard.setCreatedBy(tRateCard.getCreatedBy());
        rateCard.setCreatedOn(DateUtil.getDateFromString(tRateCard.getCreatedOn()));
        return rateCard;
    }


    public static TRateCardRule getTRateCardRule(final RateCardRule rateCardRule) {
        return new TRateCardRule().setRateCardId(rateCardRule.getRateCardId()).setCountryId(rateCardRule.getCountryId())
                .setBillingModelId(rateCardRule.getBillingModelId()).setEventTypeId(rateCardRule.getEventTypeId())
                .setPropositionId(rateCardRule.getPropositionId()).setValue(rateCardRule.getValue()).setOsId(
                        rateCardRule.getOsId());
    }


    public static RateCardRule getRateCardRule(final TRateCardRule tRateCardRule) {
        final RateCardRule rateCardRule = new RateCardRule();
        rateCardRule.setRateCardRuleId(tRateCardRule.getId());
        rateCardRule.setRateCardId(tRateCardRule.getRateCardId());
        rateCardRule.setCountryId(tRateCardRule.getCountryId());
        rateCardRule.setOsId(tRateCardRule.getOsId());
        rateCardRule.setBillingModelId(tRateCardRule.getBillingModelId());
        rateCardRule.setEventTypeId(tRateCardRule.getEventTypeId());
        rateCardRule.setPropositionId(tRateCardRule.getPropositionId());
        rateCardRule.setValue(tRateCardRule.getValue());
        return rateCardRule;
    }


    public static TIoDetails getTIODetails(final IODetails ioDetails) {
        return new TIoDetails().setId(ioDetails.getIoDetailId()).setIoId(ioDetails.getIoId()).setParentIoId(
                ioDetails.getParentIoId()).setAdvertiserId(ioDetails.getAdvertiserId()).setAvailableBudget(
                ioDetails.getAvailableBudget()).setTotalBudget(ioDetails.getTotalBudget()).setModifiedBy(
                ioDetails.getModifiedBy()).setCreatedBy(ioDetails.getCreatedBy()).setCreatedOn(
                DateUtil.getDateStr(ioDetails.getCreatedOn())).setModifiedOn(
                DateUtil.getDateStr(ioDetails.getModifiedOn()));
    }


    public static TChannelIoRule getTChannelIORule(final ChannelIORule channelIORule) {
        if (channelIORule != null) {
            final TChannelIoRule tChannelIoRule = new TChannelIoRule();
            tChannelIoRule.setId(channelIORule.getChannelIoRuleId()).setChannelId(channelIORule.getChannelId())
                    .setChannelAdvertiserId(channelIORule.getChannelAdvertiserId()).setIoDetailsId(
                    channelIORule.getIoDetailsId()).setRateCardId(channelIORule.getRateCardId()).setPropositionId(
                    channelIORule.getPropositionId()).setModifiedBy(channelIORule.getModifiedBy());

            if (Objects.nonNull(channelIORule.getModifiedOn())) {
                tChannelIoRule.setModifiedOn(DateUtil.getDateStr(channelIORule.getModifiedOn()));
            }

            if (Objects.nonNull(channelIORule.getCreatedOn())) {
                tChannelIoRule.setModifiedOn(DateUtil.getDateStr(channelIORule.getCreatedOn()));
            }
            return tChannelIoRule;
        }
        return null;
    }


    public static TCampaignDetails getTCampaignDetails(final CampaignDetails campaignDetails) {
        if (campaignDetails != null) {
            final TCampaignDetails tCampaignDetails = new TCampaignDetails();
            tCampaignDetails.setCampaignId(campaignDetails.getCampaignId()).setId(
                    campaignDetails.getCampaignDetailsId()).setChannelId(campaignDetails.getChannelId()).setName(
                    campaignDetails.getCampaignName()).setModifiedBy(campaignDetails.getModifiedBy());

            if (campaignDetails.getCreatedOn() != null) {
                tCampaignDetails.setCreatedOn(DateUtil.getDateStr(campaignDetails.getCreatedOn()));
            }
            if (campaignDetails.getModifiedOn() != null) {
                tCampaignDetails.setModifiedOn(DateUtil.getDateStr(campaignDetails.getModifiedOn()));
            }
            return tCampaignDetails;
        }
        return null;
    }


    public static CampaignDetails getCampaignDetails(final TCampaignDetails tcampaignDetails) {
        if (tcampaignDetails != null) {
            final CampaignDetails campaignDetails = new CampaignDetails();
            campaignDetails.setCampaignDetailsId(tcampaignDetails.getId());
            campaignDetails.setCampaignId(tcampaignDetails.getCampaignId());
            campaignDetails.setChannelId(tcampaignDetails.getChannelId());
            campaignDetails.setCampaignName(tcampaignDetails.getName());
            campaignDetails.setModifiedBy(tcampaignDetails.getModifiedBy());
            if (StringUtils.isNotBlank(tcampaignDetails.getModifiedOn())) {
                campaignDetails.setModifiedOn(DateUtil.getDateFromString(tcampaignDetails.getModifiedOn()));
            }
            if (StringUtils.isNotBlank(tcampaignDetails.getCreatedOn())) {
                campaignDetails.setCreatedOn(DateUtil.getDateFromString(tcampaignDetails.getCreatedOn()));
            }
            return campaignDetails;
        }
        return null;
    }


    public static TChannelIoRuleToCampaignDetailsMapping getTChannelIORuleToCampaignMapping(
            final ChannelIORuleToCampaignDetailsMapping channelIORuleToCampaignDetailsMapping) {
        if (channelIORuleToCampaignDetailsMapping != null) {
            final TChannelIoRuleToCampaignDetailsMapping tChannelIoRuleToCampaignDetailsMapping =
                    new TChannelIoRuleToCampaignDetailsMapping();
            tChannelIoRuleToCampaignDetailsMapping.setId(channelIORuleToCampaignDetailsMapping.getMappingId())
                    .setChannelIoRuleId(channelIORuleToCampaignDetailsMapping.getChannelIoRuleId())
                    .setCampaignDetailsId(channelIORuleToCampaignDetailsMapping.getCampaignDetailsId()).setCreatedBy(
                    channelIORuleToCampaignDetailsMapping.getCreatedBy());
            if (channelIORuleToCampaignDetailsMapping.getCreatedOn() != null) {
                tChannelIoRuleToCampaignDetailsMapping.setCreatedOn(
                        DateUtil.getDateStr(channelIORuleToCampaignDetailsMapping.getCreatedOn()));
            }
            return tChannelIoRuleToCampaignDetailsMapping;
        }
        return null;
    }


    public static ChannelIORule getChannelIORule(final TChannelIoRule tChannelIoRule) {
        if (tChannelIoRule != null) {
            final ChannelIORule channelIORule = new ChannelIORule();
            channelIORule.setChannelId(tChannelIoRule.getChannelId());
            channelIORule.setChannelIoRuleId(tChannelIoRule.getId());
            channelIORule.setChannelAdvertiserId(tChannelIoRule.getChannelAdvertiserId());
            channelIORule.setIoDetailsId(tChannelIoRule.getIoDetailsId());
            channelIORule.setPropositionId(tChannelIoRule.getPropositionId());
            channelIORule.setRateCardId(tChannelIoRule.getRateCardId());
            if (StringUtils.isNotBlank(tChannelIoRule.getCreatedOn())) {
                channelIORule.setCreatedOn(DateUtil.getDateFromString(tChannelIoRule.getCreatedOn()));
            }
            if (StringUtils.isNotBlank(tChannelIoRule.getModifiedOn())) {
                channelIORule.setModifiedOn(DateUtil.getDateFromString(tChannelIoRule.getModifiedOn()));
            }
            channelIORule.setModifiedBy(tChannelIoRule.getModifiedBy());
            return channelIORule;
        }
        return null;
    }
}
