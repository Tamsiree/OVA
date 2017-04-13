package com.vondear.ova.utils;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Window;

import com.lzy.okgo.request.BaseRequest;
import com.vondear.ova.Constants;
import com.vondear.rxtools.RxDataUtils;
import com.vondear.rxtools.RxDeviceUtils;
import com.vondear.rxtools.RxSPUtils;
import com.vondear.rxtools.RxUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by vonde on 2017/1/3.
 */

public class AppTools {
    public static void addRequestHeader(Context context, BaseRequest baseRequest, String url) {
        long time = System.currentTimeMillis() / 1000;

        baseRequest.headers("APP_KEY", Constants.INTERFACE_APP_KEY);
        baseRequest.headers("APP_VERSION", RxDeviceUtils.getAppVersionNo(context) + "");
        baseRequest.headers("APP_OS", "android" + "#" + android.os.Build.VERSION.SDK_INT);
        baseRequest.headers("IMEI_CODE", RxDeviceUtils.getIMEI(context) + "");
        baseRequest.headers("DEVICE_INFO", Build.BRAND + "|" + Build.MODEL);
        baseRequest.headers("CHANNEL_ID", "0");

        String[] urlArray = url.split("/");

//        if (Constants.HOST.contains("192.168.1")){
//            Log.d("MD5", urlArray[5]);
//            baseRequest.headers("SIGNATURE", "" + VonDataUtils.Md5(urlArray[5] + VonSPUtils.getContent(context, "TOKEN") + time));
//        }else{
        Log.d("MD5", urlArray[4]);
        baseRequest.headers("SIGNATURE", "" + RxUtils.Md5(urlArray[4] + RxSPUtils.getContent(context, "TOKEN") + time));
//        }

        baseRequest.headers("TIMESTAMP", time + "");
        baseRequest.headers("TOKEN", RxSPUtils.getContent(context, "TOKEN"));
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * 转换日期格式到用户体验好的时间格式
     *
     * @param time 2015-04-11 12:45:06
     * @return
     */
    public static String dateString2GoodExperienceFormat(String time) {
        if (RxDataUtils.isNullString(time)) {
            return "";
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            try {
                String timeString;
                Date parse = simpleDateFormat.parse(time);
                long distanceTime = new Date().getTime() - parse.getTime();
                if (distanceTime < 0L) {
                    timeString = "0 mins ago";
                } else {
                    long n2 = distanceTime / 60000L;
                    new SimpleDateFormat("HH:mm");
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM-dd");
                    if (n2 < 60L) {
                        timeString = String.valueOf(n2) + " mins ago";
                    } else if (n2 < 720L) {
                        timeString = String.valueOf(n2 / 60L) + " hours ago";
                    } else {
                        timeString = simpleDateFormat2.format(parse);
                    }
                }
                return timeString;
            } catch (Exception ex) {
                ex.printStackTrace();
                return "";
            }
        }
    }
}
