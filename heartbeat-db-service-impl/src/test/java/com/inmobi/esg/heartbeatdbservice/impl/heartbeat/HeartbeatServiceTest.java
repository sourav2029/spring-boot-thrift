package com.inmobi.esg.heartbeatdbservice.impl.heartbeat;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import org.apache.thrift.protocol.TProtocolFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inmobi.esg.heartbeatdbservice.client.HeartbeatServiceClient;
import com.inmobi.esg.heartbeatdbservice.impl.repository.ChannelMetaRepository;
import com.inmobi.esg.heartbeatdbservice.impl.utils.DateUtil;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TAdvertiserSearchQuery;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TAdvertiserSearchType;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TChannelIoRule;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCodeNameMetaInfo;
import com.inmobi.esg.heartbeatdbservice.thrift.entities.TCountryMeta;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HeartbeatServiceTest {
    @Autowired
    protected TProtocolFactory protocolFactory;
    private static final String MODIFIED_BY = "Automation";

    @Autowired
    private ChannelMetaRepository channelMetaRepository;

    private HeartbeatServiceClient client;


    @Before
    public void setUp() throws Exception {
        client = new HeartbeatServiceClient("localhost", 9000);

    }


    @Test
    public void testListOfCountry() throws Exception {
        System.out.println(client.getListOfCountry());
    }


    @Test
    public void testListOfOs() throws Exception {
        System.out.println(client.getListOfOS());
    }


    @Test
    public void testListOfProposition() throws Exception {
        System.out.println(client.getListOfProposition());
    }


    @Test
    public void testListOfEventType() throws Exception {
        System.out.println(client.getListOfEventType());
    }


    @Test
    public void testListOfChannel() throws Exception {
        System.out.println(client.getListOfChannel());
    }


    @Test
    public void testAdvertiserByAdvertiserId() throws Exception {
        System.out.println(client.getAdvertiserByAdvertiserId(1));
    }


    @Test
    public void testsaveCountries() throws Exception {
        TCountryMeta tCountryMeta = new TCountryMeta();
        tCountryMeta.setCountryId(40);
        TCodeNameMetaInfo tCodeNameMetaInfo = new TCodeNameMetaInfo();
        tCodeNameMetaInfo.setCode("BAN");
        tCodeNameMetaInfo.setName("BANGLADESH");
        tCountryMeta.setMeta(tCodeNameMetaInfo);
        Assert.assertTrue(client.saveCountries(Collections.singletonList(tCountryMeta)) == 1);
    }


    @Test
    public void testSearchAdvertisers() throws Exception {
        final TAdvertiserSearchType tAdvertiserSearchType = TAdvertiserSearchType.ACCOUNT_ID;
        final TAdvertiserSearchQuery searchAdvertiserQuery = new TAdvertiserSearchQuery().setAdvertiserSearchType(
                tAdvertiserSearchType).setSearchValue("hello_world_account1");
        System.out.println(client.searchAdvertisers(searchAdvertiserQuery));
        searchAdvertiserQuery.setAdvertiserSearchType(TAdvertiserSearchType.ACCOUNT_NAME).setSearchValue(
                "hello_world_advertiser1");
        System.out.println(client.searchAdvertisers(searchAdvertiserQuery));
    }


    @Test
    public void testGetRateCardsForAdvertiser() throws Exception {
        System.out.println(client.getRateCardsForAdvertiser(1));
    }


    @Test
    public void testGetRateCardRulesForRateCard() throws Exception {
        System.out.println(client.getRateCardRulesForRateCard(1));
    }


    @Test
    public void testGetIODetailsForAdvertiser() throws Exception {
        System.out.println(client.getIODetailsForAdvertiser(1));
    }


    @Test
    public void testGetChannelIORulesForIODetails() throws Exception {
        System.out.println(client.getChannelIORulesForIODetails(Arrays.asList(1, 2)));
    }


    @Test
    public void testGetIODetailsById() throws Exception {
        System.out.println(client.getIODetailsById(1));
    }


    @Test
    public void testGetChannelIORuleById() throws Exception {
        System.out.println(client.getChannelIORuleById(1));
    }


    @Test
    public void testGetRateCardById() throws Exception {
        System.out.println(client.getRateCardById(1));
    }


    @Test
    public void testGetRateCardRuleById() throws Exception {
        System.out.println(client.getChannelIORuleById(1));
    }


    @Test
    public void testGetIODetailsByIoId() throws Exception {
        System.out.println(client.getIODetailsByIoId("IMRO-2"));
    }


    @Test
    public void testGetCampaignDetailsById() throws Exception {
        System.out.println(client.getCampaignDetailsById(3));
    }


    @Test
    public void testGetChannelIoRuleToCampaignDetailsMappingById() throws Exception {
        System.out.println(client.getChannelIoRuleToCampaignDetailsMappingById(3));
    }


    @Test
    public void testSaveOrUpdateChannelIoRules() throws Exception {
        final TChannelIoRule tChannelIoRuleInput = new TChannelIoRule();
        tChannelIoRuleInput.setId(5);
        tChannelIoRuleInput.setChannelAdvertiserId("C_ADV_2");
        tChannelIoRuleInput.setIoDetailsId(2);
        tChannelIoRuleInput.setChannelId(1);
        tChannelIoRuleInput.setPropositionId(1);
        tChannelIoRuleInput.setRateCardId(2);
        tChannelIoRuleInput.setCreatedOn(new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT).format(new Date()));
        tChannelIoRuleInput.setModifiedOn(new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT).format(new Date()));
        tChannelIoRuleInput.setModifiedBy(MODIFIED_BY);
        List<TChannelIoRule> tChannelIoRuleList = client.saveOrUpdateChannelIoRules(
                Collections.singletonList(tChannelIoRuleInput));
        System.out.println(tChannelIoRuleList);
        Assert.assertTrue(tChannelIoRuleList.size() == 1);
        for (TChannelIoRule tChannelIoRule : tChannelIoRuleList) {
                Assert.assertEquals(tChannelIoRule.getId(), tChannelIoRuleInput.getId());
        }
    }


}
