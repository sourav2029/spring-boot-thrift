namespace java com.inmobi.esg.heartbeatservice.entities

typedef i32 int

enum TReportStatus {
    PENDING,
    AVAILABLE,
    PROCESSED,
    RERUN
}

struct TCampaignReportStatus {
    1: int id,
    2: string date,
    3: int channelId,
    4: TReportStatus status,
    5: string createdOn,
    6: string createdBy,
    7: string modifiedOn,
    8: string modifiedBy
}

struct TCampaignDailyReports {
    1: int id,
    2: string reportDate,
    3: string campaignId,
    4: int channelId,
    5: string channelAdvertiserId,
    6: int osId,
    7: int countryId,
    8: int impressions,
    9: int clicks,
    10: int installs,
    11: double spend,
    12: string createdOn,
    13: string createdBy,
    14: string modifiedOn,
    15: string modifiedBy
}

struct TCampaignCustomEvents {
    1: int id,
    2: int campaignDetailsId,
    3: string eventId,
    4: int eventCount,
    5: string createdOn,
    6: string createdBy,
    7: string modifiedOn,
    8: string modifiedBy
}

struct TCampaignTransactions {
    1: int id,
    2: string reportDate,
    3: int channelId,
    4: string campaignId,
    5: string channelAdvertiserId,
    6: string ioId,
    7: string rateCardName,
    8: int osId,
    9: int countryId,
    10: int impressions,
    11: int clicks,
    12: int installs,
    13: int billedEvents,
    14: double spend,
    15: double indicativeBilled,
    16: string reconciliationId,
    17: string createdOn,
    18: string createdBy,
    19: string modifiedOn,
    20: string modifiedBy
}

struct TChannelIoRule {
    1: int id,
    2: string channelAdvertiserId,
    3: int channelId,
    4: int ioDetailsId,
    5: int propositionId,
    6: int rateCardId,
    7: string createdOn,
    8: string createdBy,
    9: string modifiedOn,
    10: string modifiedBy
}

struct TChannelIoRuleToCampaignMapping {
    1: int id,
    2: int channelIoRuleId,
    3: int campaignDetailsId,
    4: string createdOn,
    5: string createdBy,
    6: string modifiedOn,
    7: string modifiedBy
}

struct TCampaignDetails {
    1: int id,
    2: int campaignId,
    3: string name,
    4: string createdOn,
    5: string createdBy,
    6: string modifiedOn,
    7: string modifiedBy
}

struct TAdvertiser {
    1: int id,
    2: string accountId,
    3: string accountName,
    4: string accountMailId,
    5: string roo,
    6: string subRoo,
    7: string pod,
    8: string subPod,
    9: string createdOn,
    10: string createdBy,
    11: string modifiedOn,
    12: string modifiedBy
}

struct TIoDetails {
    1: int id,
    2: string advertiserId,
    3: string parentIoId,
    4: string ioId,
    5: double totalBudget,
    6: double availableBudget,
    7: string createdOn,
    8: string createdBy,
    9: string modifiedOn,
    10: string modifiedBy
}

struct TRateCard {
    1: int id,
    2: int sfadvertiserId,
    3: string name,
    4: string createdBy,
    5: string createdOn
}

struct TRateCardRule {
    1: int id,
    2: int rateCardId,
    3: int countryId,
    4: int osId,
    5: int billingModelId,
    6: int eventTypeId,
    7: int propositionId,
    8: double value,
    9: string createdOn,
    10: string createdBy
}

struct TCampaignReportsForBilling {
    1: string reportDate,
    2: string campaignId,
    3: int channelId,
    4: int osId,
    5: int countryId,
    6: int impressions,
    7: int clicks,
    8: int installs,
    9: double spend,
    10: int customEventId,
    11: string customEventName,
    12: int customEventCount
}


struct TRateCardAndIoForCampaign {
    1: int channelId,
    2: string campaignId,
    3: list<TIoDetails> ioDetailsList,
    4: list<TRateCardRule> rateCardList
}

struct TCountryMeta {
    1: int countryId,
    2: string name,
    3: string code
}

struct TOSMeta {
    1: int osId,
    2: string name,
    3: string code
}