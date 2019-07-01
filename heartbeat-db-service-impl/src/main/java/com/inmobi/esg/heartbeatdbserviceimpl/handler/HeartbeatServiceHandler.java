package com.inmobi.esg.heartbeatdbserviceimpl.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inmobi.esg.heartbeatdbservice.thrift.TInternalServerException;
import com.inmobi.esg.heartbeatdbserviceimpl.Transformer.Transformer;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.CountryMetaRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.OSMetaRepository;
import com.inmobi.esg.heartbeatservice.entities.TCampaignReportsForBilling;
import com.inmobi.esg.heartbeatservice.entities.TCampaignTransactions;
import com.inmobi.esg.heartbeatservice.entities.TCountryMeta;
import com.inmobi.esg.heartbeatservice.entities.TOSMeta;
import com.inmobi.esg.heartbeatservice.entities.TRateCardAndIoForCampaign;
import com.inmobi.esg.heartbeatservice.entities.TReportStatus;
import com.inmobi.thriftself.thrift.models.THeartbeatService;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HeartbeatServiceHandler implements THeartbeatService.Iface {
    private final OSMetaRepository osMetaRepository;
    private final CountryMetaRepository countryMetaRepository;


    @Override
    public List<TCountryMeta> getListOfCountry() throws TInternalServerException, TException {
        return countryMetaRepository.findAll().stream().map(Transformer::getTCountryMeta).collect(Collectors.toList());
    }


    @Override
    public List<TOSMeta> getListOfOS() throws TInternalServerException, TException {
        return osMetaRepository.findAll().stream().map(Transformer::getTOSMeta).collect(Collectors.toList());
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
