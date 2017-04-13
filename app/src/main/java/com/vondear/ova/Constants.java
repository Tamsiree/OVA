package com.vondear.ova;

/**
 * Created by vonde on 2017/1/3.
 */

public class Constants {

    //-------------------------------------------------------------------------------------------------------------短视频start
    //----------------------------------------------------------------------------------------------接口 密钥 start
    public static final String INTERFACE_APP_KEY = "btyltv&*!2\"2016But~s:<iz+|/yj>DA+aotyx";
    public static final int CODE_LOGIN_NOW = 10001;
    public static final int CODE_LOGIN_OUT = 10002;
    //==============================================================================================
    public static final int CODE_UPDATE = 10003;
    public static final String TAG_HISTORY_PLAY = "history_play";
    public static final String[] VIDEO_CLARITY = {"normal", "high", "super"};
    public static final String[] VIDEO_CLARITY_CN = {"标清", "高清", "超清"};
    public static final String[] Cid = {"推荐", "脱口", "逗逼", "恶搞", "网剧", "萌宠", "美食"};//视频 分类
    public static final String URL_BORING_PICTURE = "http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_pic_comments&page=";
    public static final String URL_PERI_PICTURE = "http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_ooxx_comments&page=";
    //==============================================================================================================短视频end
    public static final String URL_JOKE_MUSIC = "http://route.showapi.com/255-1?type=31&showapi_appid=20569&showapi_sign=0707a6bfb3e842fb8c8aa450012d9756&page=";
    public static final String URL_SUFFIX = ".html";
    // 最新笑话
    public static final String PENGFU_NEW_JOKES = "http://m.pengfu.com/index_";
    // 捧腹段子
    public static final String PENGFU_NEW_XIAOHUA = "http://m.pengfu.com/xiaohua_";
    //----------------------------------------------------------------------------------------------Joke API
    // 趣图
    public static final String PENGFU_NEW_QUTU = "http://m.pengfu.com/qutu_";
    // 神回复
    public static final String PENGFU_NEW_SHEN = "http://m.pengfu.com/shen_";
    //**********************************************************************************************接口 密钥 end
    public static final String URL_VIDEO = HOST + "App/home";
    public static final String URL_PARSE_VIDEO = HOST + "App/video/play_url";
    public static final String URL_ANCHOR = HOST + "App/anchor";
    public static final String URL_ANCHOR_GET_VIDEOS = HOST + "App/anchor/get_videos";
    public static final String URL_REGISTER = HOST + "App/user";
    public static final String URL_LOGIN = HOST + "App/user/login";
    public static final String URL_CHECK_REG = HOST + "App/user/check_reg";
    public static final String URL_MOOD = HOST + "App/mood";
    public static final String URL_LOGOUT = HOST + "App/user/logout";
    public static final String URL_UPDATE = HOST + "App/user/update";
    private static final String REAL_HOST = "106.75.18.222";
    public static final String HOST = "http://" + REAL_HOST + "/";
    public static String URL_JOKE = "http://ic.snssdk.com/neihan/stream/mix/v1/?" +
            "mpic=1&essence=1" +
            "&content_type=-102" +
            "&message_cursor=-1" +
            "&bd_Stringitude=113.369569" +
            "&bd_latitude=23.149678" +
            "&bd_city=%E5%B9%BF%E5%B7%9E%E5%B8%82" +
            "&am_Stringitude=113.367846" +
            "&am_latitude=23.149878" +
            "&am_city=%E5%B9%BF%E5%B7%9E%E5%B8%82" +
            "&am_loc_time=1465213692154&count=30" +
            "&min_time=1465213700&screen_width=720&iid=4512422578" +
            "&device_id=17215021497" +
            "&ac=wifi" +
            "&channel=NHSQH5AN" +
            "&aid=7" +
            "&app_name=joke_essay" +
            "&version_code=431" +
            "&device_platform=android" +
            "&ssmix=a" +
            "&device_type=6s+Plus" +
            "&os_api=19" +
            "&os_version=4.4.2" +
            "&uuid=864394108025091" +
            "&openudid=80FA5B208E050000" +
            "&manifest_version_code=431";

}
