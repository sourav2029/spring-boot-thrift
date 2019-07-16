include "entities.thrift"
include "exceptions.thrift"

namespace java com.inmobi.esg.heartbeatdbservice.thrift.models

typedef i32 int

service THeartbeatService {

    /**
    * Get List Of Propositions
    **/

     int savePropositions(1: required list<entities.TPropositionMeta> tPropositions) throws(1:exceptions.TInternalServerException ise),

    /**
    * Get List of EventType
    **/

    int saveEventTypes(1: required list<entities.TEventTypeMeta> tEventTypes) throws(1:exceptions.TInternalServerException ise),

    /**
    * Get List Of Channels
    **/

    int saveChannels(1: required list<entities.TChannelMeta> tChannels) throws(1: exceptions.TInternalServerException ise),

    /**
    * Get List Of Countries
    **/

    int saveCountries(1: required list<entities.TCountryMeta> tCountries) throws(1: exceptions.TInternalServerException ise),


    /**
    * Get List of Operating Systems
    **/

    int saveOS(1: required list<entities.TOSMeta> tOSMetas) throws(1: exceptions.TInternalServerException ise),

    /**
    * Get List Of Propositions
    **/

    list<entities.TPropositionMeta> getListOfProposition() throws(1:exceptions.TInternalServerException ise),

    /**
    * Get List of EventType
    **/

    list<entities.TEventTypeMeta> getListOfEventType() throws(1:exceptions.TInternalServerException ise),

    /**
    * Get List Of Channels
    **/

    list<entities.TChannelMeta> getListOfChannel() throws(1: exceptions.TInternalServerException ise),

    /**
    * Get List Of Countries
    **/
    list<entities.TCountryMeta> getListOfCountry() throws(1: exceptions.TInternalServerException ise),


    /**
    * Get List of Operating Systems
    **/
    list<entities.TOSMeta> getListOfOS() throws(1: exceptions.TInternalServerException ise),

    /**
    * Get Advertiser for a given advertiserId
    **/

    entities.TAdvertiser getAdvertiserByAdvertiserId(1: required i32 advertiserId) throws(1:exceptions.TInternalServerException ise),

    /**
    * Get available/rerun reports from campaign_daily_reports
    **/
    list<entities.TCampaignReportsForBilling> getCampaignReportsForBilling(1: required list<entities.TReportStatus> reportStatus) throws (1: exceptions.TInternalServerException ise),


    /**
    * Get RateCard Rule and IoDetails for a campaign
    **/
    entities.TRateCardAndIoForCampaign getRateCardAndIoCampaign(1: required i64 channelId, 2: required string campaignId) throws (1: exceptions.TInternalServerException ise),



    /**
    *  Insert/Update campaign_transaction entry
    **/
    void createCampaignTransaction(1: required entities.TCampaignTransactions campaignTransaction) throws (1: exceptions.TInternalServerException ise),

    /**
    *  Insert/Update campaign_transaction entry
    **/
    void updatedCampaignTransaction(1: required entities.TCampaignTransactions campaignTransaction) throws (1: exceptions.TInternalServerException ise),

    /**
    *  Get campaign transaction for a given date.
    **/
    list<entities.TCampaignTransactions> getAllCampaignTransactionByDate(1: required string date) throws (1: exceptions.TInternalServerException ise),

    /**
    *  Get campaign transaction for a given channelId.
    **/
    list<entities.TCampaignTransactions> getAllCampaignTransactionForChannel(1: required i64 channelId) throws (1: exceptions.TInternalServerException ise),

    /**
    *  Get campaign transaction for a given campaignId.
    **/
    list<entities.TCampaignTransactions> getAllCampaignTransactionForCampaign(1: required string campaignId) throws (1: exceptions.TInternalServerException ise),

    /**
    *  Get campaign transaction for a given transaction id.
    **/
    entities.TCampaignTransactions getCampaignTransactionById(1: required i64 transactionId) throws (1: exceptions.TInternalServerException ise),

    /**
    * Get all campaign transactions for a date, channelId
    **/
    list<entities.TCampaignTransactions> getCampaignTransactionsForChannel(1: required string date, 2: required i64 channelId) throws (1: exceptions.TInternalServerException ise),

    /**
    * Get all campaign transactions for a date, campaign id
    **/
    list<entities.TCampaignTransactions> getCampaignTransactionsForCampaign(1: required string date, 2: required string campaignId) throws (1: exceptions.TInternalServerException ise),

    list<entities.TAdvertiser> searchAdvertisers(1: required entities.TAdvertiserSearchQuery searchAdvertiserQuery) throws (1: exceptions.TInternalServerException ise),

    list<entities.TRateCard> getRateCardsForAdvertiser(1: int advertiserId) throws (1: exceptions.TInternalServerException ise),

    list<entities.TRateCardRule> getRateCardRulesForRateCard(1: int rateCardId) throws (1: exceptions.TInternalServerException ise),

    list<entities.TIoDetails> getIODetailsForAdvertiser(1: int advertiserId) throws (1: exceptions.TInternalServerException ise),

    list<entities.TChannelIoRule> getChannelIORulesForIODetails(1: list<int> listOfIoDetailsId) throws (1: exceptions.TInternalServerException ise),

    entities.TIoDetails getIODetailsById(1: int ioDetailsId) throws (1: exceptions.TInternalServerException ise),

    entities.TChannelIoRule getChannelIORuleById(1: int channelIORuleId) throws (1: exceptions.TInternalServerException ise),

    entities.TRateCard getRateCardById(1: int rateCardId) throws (1: exceptions.TInternalServerException ise),

    entities.TRateCardRule getRateCardRuleById(1: int rateCardRuleId) throws (1: exceptions.TInternalServerException ise),

    entities.TIoDetails getIODetailsByIoId(1: string ioDetailsId) throws (1: exceptions.TInternalServerException ise),

    entities.TCampaignDetails getCampaignDetailsById(1: int campaignDetailsId) throws (1: exceptions.TInternalServerException ise),

    entities.TChannelIoRuleToCampaignDetailsMapping getChannelIoRuleToCampaignDetailsMappingById(1: int mappingId) throws (1: exceptions.TInternalServerException ise),

    list<entities.TChannelIoRule> saveOrUpdateChannelIoRules(1: list<entities.TChannelIoRule> tChannelIoRules) throws (1: exceptions.TInternalServerException ise),

    list<entities.TRateCard> saveOrUpdateRateCards(1: list<entities.TRateCard> tRateCards) throws(1: exceptions.TInternalServerException ise),

    list<entities.TRateCardRule> saveOrUpdateRateCardRules(1: list<entities.TRateCardRule> tRateCardRules) throws(1: exceptions.TInternalServerException ise),

    list<entities.TCampaignDetails> saveOrUpdateCampaignDetails(1: list<entities.TCampaignDetails> tCampaignDetails) throws(1: exceptions.TInternalServerException ise),

    void deleteChannelIORuleToCampaignMapping(1: list<int> channelIoRuleIds) throws (1: exceptions.TInternalServerException ise),

}