package com.inmobi.esg.heartbeatdbservice.impl.handler;

import static com.inmobi.esg.heartbeatdbservice.impl.constants.AdvertiserSearchType.*;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import java.util.stream.Collectors;


import org.apache.thrift.TException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.inmobi.esg.heartbeatdbservice.impl.Transformer.Transformer;
import com.inmobi.esg.heartbeatdbservice.impl.constants.AdvertiserSearchType;
import com.inmobi.esg.heartbeatdbservice.impl.repository.AdvertiserRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.CampaignDetailsRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.ChannelIORuleRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.ChannelIORuleToCampaignDetailsMappingRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.ChannelMetaRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.CountryMetaRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.EventTypeMetaRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.IODetailsRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.OSMetaRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.RateCardRepository;
import com.inmobi.esg.heartbeatdbservice.impl.repository.RateCardRuleRepository;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TAdvertiserSearchQuery;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCampaignDetails;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TChannelIoRule;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TChannelIoRuleToCampaignDetailsMapping;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TIoDetails;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TRateCard;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TRateCardRule;
import com.inmobi.esg.heartbeatdbservice.thrift.exceptions.TInternalServerException;
import com.inmobi.esg.heartbeatdbservice.thrift.models.THeartbeatService;
import com.inmobi.esg.heartbeatdbservice.impl.repository.PropositionMetaRepository;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TAdvertiser;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCampaignReportsForBilling;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCampaignTransactions;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TChannelMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCountryMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TEventTypeMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TOSMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TPropositionMeta;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TRateCardAndIoForCampaign;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TReportStatus;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HeartbeatServiceHandler implements THeartbeatService.Iface {
    private final OSMetaRepository osMetaRepository;
    private final CountryMetaRepository countryMetaRepository;
    private final ChannelMetaRepository channelMetaRepository;
    private final PropositionMetaRepository propositionMetaRepository;
    private final EventTypeMetaRepository eventTypeMetaRepository;
    private final AdvertiserRepository advertiserRepository;
    private final RateCardRepository rateCardRepository;
    private final RateCardRuleRepository rateCardRuleRepository;
    private final IODetailsRepository ioDetailsRepository;
    private final ChannelIORuleRepository channelIORuleRepository;
    private final CampaignDetailsRepository campaignDetailsRepository;
    private final ChannelIORuleToCampaignDetailsMappingRepository channelIORuleToCampaignDetailsMappingRepository;

    private static final Logger log = LoggerFactory.getLogger(HeartbeatServiceHandler.class);


    @Override
    public int savePropositions(final List<TPropositionMeta> tPropositions)
            throws TInternalServerException, TException {
        return propositionMetaRepository.saveAll(
                tPropositions.parallelStream().map(Transformer::getPropositionMeta).collect(Collectors.toList()))
                .size();
    }


    @Override
    public int saveEventTypes(final List<TEventTypeMeta> tEventTypes) throws TInternalServerException, TException {
        return eventTypeMetaRepository.saveAll(
                tEventTypes.parallelStream().map(Transformer::getEventTypeMeta).collect(Collectors.toList())).size();
    }


    @Override
    public int saveChannels(final List<TChannelMeta> tChannels) throws TInternalServerException, TException {
        return channelMetaRepository.saveAll(
                tChannels.parallelStream().map(Transformer::getChannelMeta).collect(Collectors.toList())).size();
    }


    @Override
    public int saveCountries(final List<TCountryMeta> tCountries) throws TInternalServerException, TException {
        return countryMetaRepository.saveAll(
                tCountries.parallelStream().map(Transformer::getCountryMeta).collect(Collectors.toList())).size();
    }


    @Override
    public int saveOS(final List<TOSMeta> tOSMetas) throws TInternalServerException, TException {
        return osMetaRepository.saveAll(
                tOSMetas.parallelStream().map(Transformer::getOSMeta).collect(Collectors.toList())).size();
    }


    @Override
    public List<TPropositionMeta> getListOfProposition() throws TInternalServerException, TException {
        return propositionMetaRepository.findAll().parallelStream().map(Transformer::getTPropositionMeta).collect(
                Collectors.toList());

    }


    @Override
    public List<TEventTypeMeta> getListOfEventType() throws TInternalServerException, TException {
        return eventTypeMetaRepository.findAll().parallelStream().map(Transformer::getTEventTypeMeta).collect(
                Collectors.toList());
    }


    @Override
    public List<TChannelMeta> getListOfChannel() throws TInternalServerException, TException {
        return channelMetaRepository.findAll().parallelStream().map(Transformer::getTChannelMeta).collect(
                Collectors.toList());

    }


    @Override
    public List<TCountryMeta> getListOfCountry() throws TInternalServerException, TException {
        return countryMetaRepository.findAll().parallelStream().map(Transformer::getTCountryMeta).collect(
                Collectors.toList());
    }


    @Override
    public List<TOSMeta> getListOfOS() throws TInternalServerException, TException {
        return osMetaRepository.findAll().parallelStream().map(Transformer::getTOSMeta).collect(Collectors.toList());
    }


    @Override
    public TAdvertiser getAdvertiserByAdvertiserId(final int advertiserId) throws TInternalServerException, TException {
        return Transformer.getTAdvertiser(advertiserRepository.findByAdvertiserId(advertiserId));
    }


    @Override
    public List<TCampaignReportsForBilling> getCampaignReportsForBilling(final List<TReportStatus> reportStatus)
            throws TInternalServerException, TException {
        return null;
    }


    @Override
    public TRateCardAndIoForCampaign getRateCardAndIoCampaign(final long channelId, final String campaignId)
            throws TInternalServerException, TException {
        return null;
    }


    @Override
    public void createCampaignTransaction(final TCampaignTransactions campaignTransaction)
            throws TInternalServerException, TException {

    }


    @Override
    public void updatedCampaignTransaction(final TCampaignTransactions campaignTransaction)
            throws TInternalServerException, TException {

    }


    @Override
    public List<TCampaignTransactions> getAllCampaignTransactionByDate(final String date)
            throws TInternalServerException, TException {
        return null;
    }


    @Override
    public List<TCampaignTransactions> getAllCampaignTransactionForChannel(final long channelId)
            throws TInternalServerException, TException {
        return null;
    }


    @Override
    public List<TCampaignTransactions> getAllCampaignTransactionForCampaign(final String campaignId)
            throws TInternalServerException, TException {
        return null;
    }


    @Override
    public TCampaignTransactions getCampaignTransactionById(final long transactionId)
            throws TInternalServerException, TException {
        return null;
    }


    @Override
    public List<TCampaignTransactions> getCampaignTransactionsForChannel(final String date, final long channelId)
            throws TInternalServerException, TException {
        return null;
    }


    @Override
    public List<TCampaignTransactions> getCampaignTransactionsForCampaign(final String date, final String campaignId)
            throws TInternalServerException, TException {
        return null;
    }


    @Override
    public List<TAdvertiser> searchAdvertisers(final TAdvertiserSearchQuery tAdvertiserSearchQuery)
            throws TInternalServerException, TException {
        if (tAdvertiserSearchQuery == null) {
            throw new TInternalServerException("TAdvertiserSearchQuery cannot be null.");
        }

        if (StringUtils.isBlank(tAdvertiserSearchQuery.getSearchValue())) {
            throw new TInternalServerException("Search value cannot be empty.");
        }

        final String searchValue = tAdvertiserSearchQuery.getSearchValue();
        final AdvertiserSearchType advertiserSearchType = getAdvertiserSearchType(
                tAdvertiserSearchQuery.getAdvertiserSearchType());

        if (advertiserSearchType != null) {
            switch (advertiserSearchType) {
                case ACCOUNT_NAME:
                    return advertiserRepository.findByAccountName(searchValue).parallelStream().map(
                            Transformer::getTAdvertiser).collect(Collectors.toList());
                case ACCOUNT_ID:
                    return advertiserRepository.findByAccountId(searchValue).parallelStream().map(
                            Transformer::getTAdvertiser).collect(Collectors.toList());
            }
        }
        log.error("Null value for TSearchAdvertiserQuery");
        throw new TInternalServerException(
                "Incorrect Value for TSearchAdvertiserQuery :" + tAdvertiserSearchQuery.getAdvertiserSearchType());
    }


    @Override
    public List<TRateCard> getRateCardsForAdvertiser(final int advertiserId) throws TException {
        return rateCardRepository.findByAdvertiserId(advertiserId).parallelStream().map(Transformer::getTRateCard)
                .collect(Collectors.toList());
    }


    @Override
    public List<TRateCardRule> getRateCardRulesForRateCard(final int rateCardId)
            throws TInternalServerException, TException {
        return rateCardRuleRepository.findByRateCardId(rateCardId).parallelStream().map(Transformer::getTRateCardRule)
                .collect(Collectors.toList());
    }


    @Override
    public List<TIoDetails> getIODetailsForAdvertiser(final int advertiserId)
            throws TInternalServerException, TException {
        return ioDetailsRepository.findByAdvertiserId(advertiserId).parallelStream().map(Transformer::getTIODetails)
                .collect(Collectors.toList());
    }


    @Override
    public List<TChannelIoRule> getChannelIORulesForIODetails(final List<Integer> listOfIoDetailsId)
            throws TInternalServerException, TException {
        return channelIORuleRepository.findByIoDetailsIdIn(listOfIoDetailsId).parallelStream().map(
                Transformer::getTChannelIORule).collect(Collectors.toList());
    }


    @Override
    public TIoDetails getIODetailsById(final int ioDetailsId) throws TInternalServerException, TException {
        return Transformer.getTIODetails(ioDetailsRepository.findByIoDetailId(ioDetailsId));
    }


    @Override
    public TChannelIoRule getChannelIORuleById(final int channelIORuleId) throws TInternalServerException, TException {
        return Transformer.getTChannelIORule(channelIORuleRepository.findByChannelIoRuleId(channelIORuleId));
    }


    @Override
    public TRateCard getRateCardById(final int rateCardId) throws TInternalServerException, TException {
        return Transformer.getTRateCard(rateCardRepository.findByRateCardId(rateCardId));
    }


    @Override
    public TRateCardRule getRateCardRuleById(final int rateCardRule) throws TInternalServerException, TException {
        return Transformer.getTRateCardRule(rateCardRuleRepository.findByRateCardRuleId(rateCardRule));
    }


    @Override
    public TIoDetails getIODetailsByIoId(final String ioDetailsId) throws TInternalServerException, TException {
        return Transformer.getTIODetails(ioDetailsRepository.findByIoId(ioDetailsId));
    }


    @Override
    public TCampaignDetails getCampaignDetailsById(final int campaignDetailsId)
            throws TInternalServerException, TException {
        return Transformer.getTCampaignDetails(campaignDetailsRepository.findByCampaignDetailsId(campaignDetailsId));
    }


    @Override
    public TChannelIoRuleToCampaignDetailsMapping getChannelIoRuleToCampaignDetailsMappingById(final int mappingId)
            throws TInternalServerException, TException {
        return Transformer.getTChannelIORuleToCampaignMapping(
                channelIORuleToCampaignDetailsMappingRepository.findByMappingId(mappingId));
    }


    @Override
    public List<TChannelIoRule> saveOrUpdateChannelIoRules(final List<TChannelIoRule> tChannelIoRules)
            throws TInternalServerException, TException {
        if (CollectionUtils.isEmpty(tChannelIoRules)) {
            throw new TInternalServerException("Nothing to update");
        }
        return channelIORuleRepository.saveAll(
                tChannelIoRules.parallelStream().map(Transformer::getChannelIORule).collect(Collectors.toList()))
                .parallelStream().map(Transformer::getTChannelIORule).collect(Collectors.toList());
    }


    @Override
    public List<TRateCard> saveOrUpdateRateCards(final List<TRateCard> tRateCards)
            throws TInternalServerException, TException {
        if (CollectionUtils.isEmpty(tRateCards)) {
            throw new TInternalServerException("Nothing to update");
        }
        return rateCardRepository.saveAll(
                tRateCards.parallelStream().map(Transformer::getRateCard).collect(Collectors.toList())).parallelStream()
                .map(Transformer::getTRateCard).collect(Collectors.toList());
    }


    @Override
    public List<TRateCardRule> saveOrUpdateRateCardRules(final List<TRateCardRule> tRateCardRules)
            throws TInternalServerException, TException {
        if (CollectionUtils.isEmpty(tRateCardRules)) {
            throw new TInternalServerException("Nothing to update");
        }
        return rateCardRuleRepository.saveAll(
                tRateCardRules.parallelStream().map(Transformer::getRateCardRule).collect(Collectors.toList()))
                .parallelStream().map(Transformer::getTRateCardRule).collect(Collectors.toList());
    }


    @Override
    public List<TCampaignDetails> saveOrUpdateCampaignDetails(final List<TCampaignDetails> tCampaignDetails)
            throws TInternalServerException, TException {
        if (CollectionUtils.isEmpty(tCampaignDetails)) {
            throw new TInternalServerException("Nothing to update");
        }
        return campaignDetailsRepository.saveAll(
                tCampaignDetails.parallelStream().map(Transformer::getCampaignDetails).collect(Collectors.toList()))
                .parallelStream().map(Transformer::getTCampaignDetails).collect(Collectors.toList());
    }


    @Override
    public void deleteChannelIORuleToCampaignMapping(final List<Integer> channelIoRuleIds)
            throws TException, TInternalServerException {
        if (CollectionUtils.isEmpty(channelIoRuleIds)) {
            throw new TInternalServerException("Empty channel IO Rule Ids not allowed");
        }
        channelIORuleToCampaignDetailsMappingRepository.deleteByChannelIoRuleId(channelIoRuleIds);
    }

}
