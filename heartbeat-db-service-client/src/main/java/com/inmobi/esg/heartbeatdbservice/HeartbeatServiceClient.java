package com.inmobi.esg.heartbeatdbservice;

import java.util.List;

import org.apache.http.HttpHeaders;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;

import com.inmobi.esg.heartbeatdbservice.thrift.TInternalServerException;
import com.inmobi.esg.heartbeatservice.entities.TAdvertiser;
import com.inmobi.esg.heartbeatservice.entities.TCampaignReportsForBilling;
import com.inmobi.esg.heartbeatservice.entities.TCampaignTransactions;
import com.inmobi.esg.heartbeatservice.entities.TChannelMeta;
import com.inmobi.esg.heartbeatservice.entities.TCountryMeta;
import com.inmobi.esg.heartbeatservice.entities.TEventTypeMeta;
import com.inmobi.esg.heartbeatservice.entities.TOSMeta;
import com.inmobi.esg.heartbeatservice.entities.TPropositionMeta;
import com.inmobi.esg.heartbeatservice.entities.TRateCardAndIoForCampaign;
import com.inmobi.esg.heartbeatservice.entities.TReportStatus;
import com.inmobi.thriftself.thrift.models.THeartbeatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
public class HeartbeatServiceClient implements THeartbeatService.Iface {
    private final String serverIP;
    private final int serverPort;


    private String getUrl() {
        final String servicePath = "/heartbeat/";
        return "http://" + serverIP + ":" + serverPort + servicePath;
    }


    private THeartbeatService.Client getClient() {
        THttpClient httpClient;
        try {
            final String url = getUrl();
            log.debug(url);
            httpClient = new THttpClient(url);
            httpClient.setCustomHeader(HttpHeaders.ACCEPT, "*/*");
            httpClient.setCustomHeader(HttpHeaders.CONTENT_TYPE, "application/x-thrift");
        } catch (final TTransportException e) {
            throw new RuntimeException(e);
        }
        return new THeartbeatService.Client(new TBinaryProtocol(httpClient));
    }


    private void closeClient(final THeartbeatService.Client client) {
        if (client != null) {
            if (client.getInputProtocol().getTransport().isOpen()) {
                client.getInputProtocol().getTransport().close();
            }
            if (client.getOutputProtocol().getTransport().isOpen()) {
                client.getOutputProtocol().getTransport().close();
            }
        }
    }


    @Override
    public int savePropositions(final List<TPropositionMeta> tPropositions)
            throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.savePropositions(tPropositions);
        } finally {
            closeClient(client);
        }
    }


    @Override
    public int saveEventTypes(final List<TEventTypeMeta> tEventTypes)
            throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.saveEventTypes(tEventTypes);
        } finally {
            closeClient(client);
        }
    }


    @Override
    public int saveChannels(final List<TChannelMeta> tChannels)
            throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.saveChannels(tChannels);
        } finally {
            closeClient(client);
        }
    }


    @Override
    public int saveCountries(final List<TCountryMeta> tCountries)
            throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.saveCountries(tCountries);
        } finally {
            closeClient(client);
        }
    }


    @Override
    public int saveOS(final List<TOSMeta> tOSMetas) throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.saveOS(tOSMetas);
        } finally {
            closeClient(client);
        }
    }


    @Override
    public List<TPropositionMeta> getListOfProposition() throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.getListOfProposition();
        } finally {
            closeClient(client);
        }
    }


    @Override
    public List<TEventTypeMeta> getListOfEventType() throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.getListOfEventType();
        } finally {
            closeClient(client);
        }
    }


    @Override
    public List<TChannelMeta> getListOfChannel() throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.getListOfChannel();
        } finally {
            closeClient(client);
        }
    }


    @Override
    public List<TCountryMeta> getListOfCountry() throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.getListOfCountry();
        } finally {
            closeClient(client);
        }
    }


    @Override
    public List<TOSMeta> getListOfOS() throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.getListOfOS();
        } finally {
            closeClient(client);
        }
    }


    @Override
    public TAdvertiser getAdvertiserByAdvertiserId(final int advertiserId) throws TInternalServerException, TException {
        THeartbeatService.Client client = null;

        try {
            client = getClient();
            return client.getAdvertiserByAdvertiserId(advertiserId);
        } finally {
            closeClient(client);
        }
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
