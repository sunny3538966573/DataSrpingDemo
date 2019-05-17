package com.sunny.datasrping;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtil {

    private static final String TAG = "TimeUtil";

    public static final String FORMAT_TIME_CN = "yyyy年MM月dd HH时mm分ss秒";


    private static final SimpleDateFormat SDF = new SimpleDateFormat(FORMAT_TIME_CN, Locale.CHINA);


    /**
     * string型时间转换
     *
     * @param timeFormat 时间格式
     * @param timestamp  时间
     * @return 刚刚  x分钟  小时前  ...
     */
    public static String convertTime(String timeFormat, long timestamp) {
        try {
            Date date = new Date();
            date.setTime(timestamp);

            return format(timeFormat, date);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage());
            return "";
        }
    }

    private static String format(String timeFormat, Date date) {
        SDF.setTimeZone(TimeZone.getDefault());
        SDF.applyPattern(timeFormat);

        return SDF.format(date);
    }
}
