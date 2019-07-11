package com.inmobi.esg.heartbeatdbserviceimpl.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inmobi.esg.heartbeatdbservice.thrift.exceptions.TInternalServerException;
import com.inmobi.esg.heartbeatdbservice.thrift.models.THeartbeatService;
import com.inmobi.esg.heartbeatdbserviceimpl.Transformer.Transformer;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.EventTypeMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.entity.PropositionMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.AdvertiserRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.ChannelMetaRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.CountryMetaRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.EventTypeMetaRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.OSMetaRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.PropositionMetaRepository;
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


    @Override
    public int savePropositions(final List<TPropositionMeta> tPropositions)
            throws TInternalServerException, TException {
        return propositionMetaRepository.saveAll(
                tPropositions.parallelStream().map(Transformer::getPropositionMeta).collect(Collectors.toList())).size();
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
        return countryMetaRepository.saveAll(tCountries.parallelStream().map(Transformer::getCountryMeta).collect(
                Collectors.toList())).size();
    }


    @Override
    public int saveOS(final List<TOSMeta> tOSMetas) throws TInternalServerException, TException {
        return osMetaRepository.saveAll(tOSMetas.parallelStream().map(Transformer::getOSMeta).collect(Collectors.toList())).size();
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
}
