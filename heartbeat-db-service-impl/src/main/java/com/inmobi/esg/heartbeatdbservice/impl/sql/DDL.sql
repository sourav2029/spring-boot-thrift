drop table if exists channel_io_rule_to_campaign_details_mapping cascade;
drop table if exists channel_io_rule cascade;
drop table if exists io_details cascade;
drop table if exists campaign_details cascade;
drop table if exists rate_card_rule cascade;
drop table if exists rate_card cascade;
drop table if exists sf_advertiser cascade;
drop table if exists meta_country cascade;
drop table if exists meta_channel cascade;
drop table if exists meta_os cascade;
drop table if exists meta_proposition cascade;
drop table if exists meta_event_type cascade;
drop table if exists meta_billing_model cascade;
drop table if exists campaign_daily_reports cascade;
drop table if exists campaign_custom_events cascade;
drop table if exists campaign_transactions cascade;
drop table if exists channel_report_status cascade;
drop table if exists channel_io_rule_to_campaign_details_mapping cascade;
drop type if exists report_status;

create table meta_country(
    country_id serial primary key,
    code varchar(255),
    name varchar(255)
);
comment on table meta_country is 'Meta table for storing list of Countries';


create table meta_os(
    os_id serial primary key,
    code varchar(255),
    name varchar(255)
);
comment on table meta_os is 'Meta table for storing list of OS';


create table meta_proposition(
    proposition_id serial primary key,
    code varchar(255),
    name varchar(255)
);
comment on table meta_proposition is 'Meta table for storing list of Propositions';


create table meta_event_type(
    event_type_id serial primary key,
    code varchar(255),
    name varchar(255)
);
comment on table meta_event_type is 'Meta table for storing list of Event Types';


create table meta_channel(
    channel_id serial primary key,
    code varchar(255),
    name varchar(255)
);
comment on table meta_channel is 'Meta table for storing list of Meta Channels';


create table meta_billing_model(
    billing_model_id serial primary key,
    code varchar(255),
    name varchar(255)
);
comment on table meta_billing_model is 'Meta table for storing list of Billing Models';


create table sf_advertiser(
    advertiser_id serial primary key,
    account_id varchar(255),
    account_name varchar(255),
    roo varchar(255),
    sub_roo varchar(255),
    pod varchar(255),
    sub_pod varchar(255),
    created_on timestamp without time zone not null default now(),
    modified_on timestamp without time zone default now(),
    modified_by varchar(255)
);
comment on table sf_advertiser is 'This table stores Advertiser details as is pushed from SalesForce';
comment on column sf_advertiser.advertiser_id is 'Auto-generated ID for advertisers';
comment on column sf_advertiser.account_id is 'SF sourced account ID';
comment on column sf_advertiser.account_name is 'SF sourced name of the account';
comment on column sf_advertiser.roo is 'ROO for this advertiser';
comment on column sf_advertiser.sub_roo is 'Sub ROO for this advertiser';
comment on column sf_advertiser.pod is 'Pod for this advertiser';
comment on column sf_advertiser.sub_pod is 'Sub pod for this advertiser';
comment on column sf_advertiser.created_on is 'Timestamp when this entry was created';
comment on column sf_advertiser.modified_on is 'Timestamp when this entry was modified';
comment on column sf_advertiser.modified_by is 'ID of the user who modified this entry';


create table io_details(
    io_details_id serial primary key,
    advertiser_id integer references sf_advertiser(advertiser_id),
    io_id varchar(255),
    parent_io_id varchar(255),
    total_budget float,
    available_budget float,
    io_type varchar(255),
    io_status varchar(255),
    vertical varchar(255),
    local_currency varchar(8),
    conversion_rate float,
    agency_discount float,
    advertiser_discount float,
    creative_charges float,
    other_charges float,
    volume_discount float,
    tax_withholding float,
    payment_terms integer,
    billing_cycle_id varchar(255),
    entity_id json,
    created_on timestamp without time zone not null default now(),
    modified_on timestamp without time zone default now(),
    created_by varchar(255) not null,
    modified_by varchar(255)
);
comment on table io_details is 'This table stores IO details as is pushed from SalesForce';
comment on column io_details.io_details_id is 'Auto-generated ID for io_details';
comment on column io_details.advertiser_id is 'Advertiser ID which references advertiser table';
comment on column io_details.io_id is 'IO ID as sourced from SalesForce';
comment on column io_details.parent_io_id is 'Parent IO ID as sourced from SalesForce';
comment on column io_details.total_budget is 'Total initial budget as was at the time this data was refreshed/sourced from SalesForce';
comment on column io_details.available_budget is 'Total available budget now';
comment on column io_details.io_type is 'Type of IO like (standard, Free trial, Make Good, Internal IO)';
comment on column io_details.io_status is 'Status of IO';
comment on column io_details.vertical is 'The industry this IO belongs to like Gaming etc.';
comment on column io_details.local_currency is 'Local currency for this IO like USD, SGD etc.';
comment on column io_details.conversion_rate is 'Conversion rate from USD to local currency';
comment on column io_details.agency_discount is 'Discount applicable to the agency';
comment on column io_details.advertiser_discount is 'Discount applicable to the advertiser';
comment on column io_details.creative_charges is 'Account Creative Charges';
comment on column io_details.other_charges is 'Other Charges';
comment on column io_details.volume_discount is 'Account Volume Discount';
comment on column io_details.tax_withholding is 'Tax withholding applicable to the account';
comment on column io_details.payment_terms is 'Payment terms like 30 days or 60 days billing cycle';
comment on column io_details.billing_cycle_id is 'Billing cycle type like (End of Month, End of IO)';
comment on column io_details.entity_id is 'Whether China or Singapore or India entity';
comment on column io_details.created_on is 'Timestamp when this entry was created';
comment on column io_details.modified_on is 'Timestamp when this entry was modified';
comment on column io_details.created_by is 'ID of the user who created this entry';
comment on column io_details.modified_by is 'ID of the user who modified this entry';


create table rate_card(
    rate_card_id serial primary key,
    advertiser_id integer references sf_advertiser(advertiser_id),
    name varchar(255),
    created_by varchar(255) not null,
    created_on timestamp without time zone not null default now()
);
comment on table rate_card is 'This table stores Rate Card';
comment on column rate_card.rate_card_id is 'Auto-generated ID for rate_card';
comment on column rate_card.advertiser_id is 'Advertiser ID which references sf_advertiser table';
comment on column rate_card.name is 'Name for this Rate Card';
comment on column rate_card.created_by is 'ID of the user who created this entry';
comment on column rate_card.created_on is 'Timestamp when this entry was created';


create table rate_card_rule(
    rate_card_rule_id serial primary key,
    rate_card_id integer references rate_card(rate_card_id),
    country_id integer references meta_country(country_id),
    os_id integer references meta_os(os_id),
    billing_model_id integer references meta_billing_model(billing_model_id),
    event_type_id integer references meta_event_type(event_type_id),
    proposition_id integer references meta_proposition(proposition_id),
    value float
);
comment on table rate_card_rule is 'This table stores Rate Card Rules corresponding to a Rate Card';
comment on column rate_card_rule.rate_card_rule_id is 'Auto-generated ID for rate_card_rule';
comment on column rate_card_rule.rate_card_id is 'Rate Card ID which references rate_card table';
comment on column rate_card_rule.country_id is 'Country ID which references meta_country table';
comment on column rate_card_rule.os_id is 'OS ID which references meta_os table';
comment on column rate_card_rule.billing_model_id is 'Billing Model ID which references meta_billing_model table';
comment on column rate_card_rule.event_type_id is 'Event Type ID which references meta_event_type table';
comment on column rate_card_rule.proposition_id is 'Proposition ID which references meta_proposition table';
comment on column rate_card_rule.value is 'Value applicable for this configuration in USD';


create table channel_io_rule(
    channel_io_rule_id serial primary key,
    channel_adv_id varchar(255),
    io_details_id integer references io_details(io_details_id),
    channel_id integer references meta_channel(channel_id),
    proposition_id integer references meta_proposition(proposition_id),
    rate_card_id integer references rate_card(rate_card_id),
    created_on timestamp without time zone not null default now(),
    modified_on timestamp without time zone default now(),
    modified_by varchar(255)
);
comment on table channel_io_rule is 'This table stores Channel IO Rules';
comment on column channel_io_rule.channel_io_rule_id is 'Auto-generated ID for channel_io_rule';
comment on column channel_io_rule.channel_adv_id is 'Channel Advertiser ID which is a non-mandatory field';
comment on column channel_io_rule.io_details_id is 'IO Details ID which references io_details table';
comment on column channel_io_rule.channel_id is 'Channel ID which references meta_channel table';
comment on column channel_io_rule.proposition_id is 'Proposition ID which references meta_proposition table';
comment on column channel_io_rule.rate_card_id is 'Rate Card ID which references rate_card table';
comment on column channel_io_rule.created_on is 'Timestamp when this entry was created';
comment on column channel_io_rule.modified_on is 'Timestamp when this entry was modified';
comment on column channel_io_rule.modified_by is 'ID of the user who modified this entry';


create table campaign_details(
    campaign_details_id serial primary key,
    campaign_id varchar(255),
    channel_id integer REFERENCES meta_channel(channel_id),
    campaign_name varchar(255),
    created_on timestamp without time zone not null default now(),
    modified_on timestamp without time zone default now(),
    modified_by varchar(255)
);
comment on table campaign_details is 'This table stores Campaign related details';
comment on column campaign_details.campaign_details_id is 'Auto-generated ID for campaign_details';
comment on column campaign_details.campaign_id is 'Campaign ID which is an identifier for the Campaign';
comment on column campaign_details.campaign_name is 'Name of the campaign';
comment on column campaign_details.created_on is 'Timestamp when this entry was created';
comment on column campaign_details.modified_on is 'Timestamp when this entry was modified';
comment on column campaign_details.modified_by is 'ID of the user who modified this entry';


create table channel_io_rule_to_campaign_details_mapping(
    mapping_id serial primary key,
    channel_io_rule_id integer references channel_io_rule(channel_io_rule_id),
    campaign_details_id integer references campaign_details(campaign_details_id),
    created_on timestamp without time zone not null default now(),
    created_by varchar(255) not null
);
comment on table channel_io_rule_to_campaign_details_mapping is 'This table stores mapping between Channel IO Rule to Campaign details';
comment on column channel_io_rule_to_campaign_details_mapping.mapping_id is 'Auto-generated ID for channel_io_rule_to_campaign_details_mapping';
comment on column channel_io_rule_to_campaign_details_mapping.channel_io_rule_id is 'Channel IO Rule ID which references channel_io_rule table';
comment on column channel_io_rule_to_campaign_details_mapping.campaign_details_id is 'Campaign Details ID which references campaign_details table';




CREATE TABLE campaign_daily_reports(
  id SERIAL PRIMARY KEY,
  report_date TIMESTAMP NOT NULL,
  campaign_id VARCHAR(64) NOT NULL,
  channel_id integer not null,
  channel_advertiser_id VARCHAR(64),
  os_id integer references meta_os(os_id),
  country_id integer references meta_country(country_id),
  impressions integer,
  clicks integer,
  installs integer,
  billed_events integer,
  spend float,
  created_on timestamp with time zone not null default now(),
  created_by varchar(255),
  modified_on timestamp with time zone not null default now(),
  modified_by varchar(255)
);

CREATE TABLE campaign_custom_events(
  id SERIAL PRIMARY KEY,
  campaign_daily_report_id INTEGER REFERENCES campaign_daily_reports(id),
  custom_event_name VARCHAR(50),
  custom_event_count INTEGER
);


COMMENT ON COLUMN campaign_daily_reports.id is 'Transaction id for the ledger entry';
COMMENT ON COLUMN campaign_daily_reports.report_date is 'Spend date of the entry';
COMMENT ON COLUMN campaign_daily_reports.channel_id is 'Channel associated with the spend';
COMMENT ON COLUMN campaign_daily_reports.campaign_id is 'Campaign associated with the spend';
COMMENT ON COLUMN campaign_daily_reports.channel_advertiser_id is 'Channel Advertiser associated with the spend';
COMMENT ON COLUMN campaign_daily_reports.os_id is 'OS associated with the spend';
COMMENT ON COLUMN campaign_daily_reports.country_id is 'Country associated with the spend';
COMMENT ON COLUMN campaign_daily_reports.impressions is 'Impressions recorded for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_daily_reports.clicks is 'Clicks recorded for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_daily_reports.installs is 'Installs recorded for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_daily_reports.billed_events is 'Custom event present in io rule, for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_daily_reports.spend is 'Spend recorded for the campaign on the given spend_date';

CREATE INDEX campaign_daily_report_index ON campaign_daily_reports (channel_id, campaign_id);

CREATE TYPE report_status as ENUM ('PENDING', 'AVAILABLE', 'PROCESSED', 'RE_RUN');

CREATE TABLE channel_report_status (
  id SERIAL PRIMARY KEY,
  channel_id integer not null REFERENCES meta_channel(channel_id),
  report_date TIMESTAMP NOT NULL,
  status report_status,
  channel_report_id VARCHAR(64)
);



CREATE TABLE campaign_transactions(
    id SERIAL NOT NULL PRIMARY KEY,
    report_date date not null,
    channel_id integer not null,
    campaign_id varchar(255) not null,
    channel_advertiser_id varchar(255),
    io_id varchar(255),
    rule_card_name varchar(255),
    os_id integer references meta_os(os_id),
    country_id integer references meta_country(country_id),
    impressions integer,
    clicks integer,
    installs integer,
    billed_event varchar(100),
    billed_event_count integer,
    spend float,
    indicative_billed float,
    reconciliation_id varchar(255),
    created_on timestamp with time zone NOT NULL DEFAULT now() ,
    created_by varchar(255),
    modified_on timestamp with time zone NOT NULL DEFAULT now(),
    modified_by varchar(255)
);

COMMENT ON COLUMN campaign_transactions.id is 'Transaction id for the ledger entry';
COMMENT ON COLUMN campaign_transactions.report_date is 'Spend date of the entry';
COMMENT ON COLUMN campaign_transactions.channel_id is 'Channel associated with the spend';
COMMENT ON COLUMN campaign_transactions.campaign_id is 'Campaign associated with the spend';
COMMENT ON COLUMN campaign_transactions.channel_advertiser_id is 'Channel Advertiser associated with the spend';
COMMENT ON COLUMN campaign_transactions.io_id is 'IO number from which billable is deducted';
COMMENT ON COLUMN campaign_transactions.rule_card_name is 'Rule Card used to calculate billable';
COMMENT ON COLUMN campaign_transactions.os_id is 'OS associated with the spend';
COMMENT ON COLUMN campaign_transactions.country_id is 'Country associated with the spend';
COMMENT ON COLUMN campaign_transactions.impressions is 'Impressions recorded for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_transactions.clicks is 'Clicks recorded for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_transactions.installs is 'Installs recorded for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_transactions.billed_event is 'Custom event present in io rule, for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_transactions.billed_event_count is 'Custom event count present in io rule, for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_transactions.spend is 'Spend recorded for the campaign on the given spend_date';
COMMENT ON COLUMN campaign_transactions.indicative_billed is 'Billable amount calculated for the entry on the given spend_date';
COMMENT ON COLUMN campaign_transactions.reconciliation_id is 'Reconciliation id of the recon, if any';


CREATE INDEX campaign_transactions_index ON campaign_transactions (channel_id, campaign_id);
