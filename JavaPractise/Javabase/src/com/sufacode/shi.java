package com.sufacode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Classname shi
 * @Description TODO
 * @Date 19-10-9 下午3:36
 * @Created by xns
 */
public class shi {

    public static void main(String args[]) throws ParseException {

        UTCToCST("2019-10-09T09:50:00.000Z", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }

    public static void UTCToCST(String UTCStr, String format) throws ParseException {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        date = sdf.parse(UTCStr);
        System.out.println("UTC时间: " + sdf.format(date));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        //calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
        System.out.println("北京时间: " + sdf.format(calendar.getTime()));
    }
}
