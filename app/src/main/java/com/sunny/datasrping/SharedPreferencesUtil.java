package com.sunny.datasrping;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {

    private static final String PRE_NAME = "config";
    private static SharedPreferences sp;

    /**
     * 设置 boolean 值
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setBooleanValue(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 返回 boolean 值
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBooleanValue(Context context, String key, boolean defaultValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defaultValue);
    }

    /**
     * 设置 String 值
     *
     * @param context
     * @param key
     * @param
     */
    public static void setStringValue(Context context, String key, String Value) {
        if (sp == null) {
            sp = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, Value).commit();
    }

    /**
     * 返回 String 值
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getStringValue(Context context, String key, String defaultValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defaultValue);
    }

    /**
     * 设置Int值
     *
     * @param context
     * @param key
     * @param defaultValue
     */
    public static void setIntValue(Context context, String key, int defaultValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, defaultValue).commit();
    }

    /**
     * 返回Int值
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getIntValue(Context context, String key, int defaultValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defaultValue);
    }

}

