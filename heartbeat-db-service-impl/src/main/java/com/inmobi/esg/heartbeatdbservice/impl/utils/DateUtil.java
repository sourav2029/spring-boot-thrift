package com.inmobi.esg.heartbeatdbservice.impl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtil {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static Logger log = LoggerFactory.getLogger(DateUtil.class);


    public static String getDateStr(final Date date) {
        if(Objects.nonNull(date)){
            final SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
            return sdf.format(date);
        }
        log.error("Null date : {}",date);
        return null;
    }

    public static Date getDateFromString(final String dateStr) {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            log.error("Failed to parse, Invalid Date:{}", dateStr);
            e.printStackTrace();
        }
        return null;
    }

}
