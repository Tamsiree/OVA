package com.vondear.ova.bean;

import java.util.List;

/**
 * Created by vonde on 2016/7/5.
 */
public class VideoParse1 {

    /**
     * source : 优酷网
     * title : papi酱的心得——没事别逛家具店
     * formatList : 标清|高清|超清
     * formatCodeList : normal|high|super
     * type : CUSTOM
     * total_duration : 249
     * total_filesize : 9561600
     * url : [{"U":"http://pl.youku.com/playlist/m3u8?ts=1467699360&keyframe=0&pid=65a965fbf632be6f&vid=XMTYyODI1NTU5Ng==&type=flv&r=/3sLngL0Q6CXymAIiF9JUfR5MDecwxp/gSVk/o8apWJ3KUkaGrqktKh7cO9ZZoqYN5iGQUM9dNrj6YzDV+fl4NQF78OEDv/YT1AcUy5M9J3ekR0uLgbxYSYat2SmW+B2IHRV+AE+ATvaej8eiiE47jENRqm3F2I8Fjfoz1ZJ29U52XtnhPT//vVcHrDxgSDiZv5V74oX7DngC2F1D7BT3A==&sid=846769936051320cc1c91&token=4412&ctype=20&did=0368ad14f7460a81d12f26d34029bfbe&ev=1&oip=2014996627&ep=V1JiQLL%2Fa5lSDbqDVuGsCvs9Ry6SKnT1nhIJbJLAtpRfY0Ivtth7N2jLcNA3PLG8"}]
     */

    private String source;
    private String title;
    private String formatList;
    private String formatCodeList;
    private String type;
    private String total_duration;
    private String total_filesize;
    private String barrage;
    /**
     * U : http://pl.youku.com/playlist/m3u8?ts=1467699360&keyframe=0&pid=65a965fbf632be6f&vid=XMTYyODI1NTU5Ng==&type=flv&r=/3sLngL0Q6CXymAIiF9JUfR5MDecwxp/gSVk/o8apWJ3KUkaGrqktKh7cO9ZZoqYN5iGQUM9dNrj6YzDV+fl4NQF78OEDv/YT1AcUy5M9J3ekR0uLgbxYSYat2SmW+B2IHRV+AE+ATvaej8eiiE47jENRqm3F2I8Fjfoz1ZJ29U52XtnhPT//vVcHrDxgSDiZv5V74oX7DngC2F1D7BT3A==&sid=846769936051320cc1c91&token=4412&ctype=20&did=0368ad14f7460a81d12f26d34029bfbe&ev=1&oip=2014996627&ep=V1JiQLL%2Fa5lSDbqDVuGsCvs9Ry6SKnT1nhIJbJLAtpRfY0Ivtth7N2jLcNA3PLG8
     */


    private List<UrlBean> url;

    public VideoParse1(String source, String title, String formatList, String formatCodeList, String type, String total_duration, String total_filesize, List<UrlBean> url, String barrage) {
        this.source = source;
        this.title = title;
        this.formatList = formatList;
        this.formatCodeList = formatCodeList;
        this.type = type;
        this.total_duration = total_duration;
        this.total_filesize = total_filesize;
        this.url = url;
        this.barrage = barrage;
    }

    public String getBarrage() {
        return barrage;
    }

    public void setBarrage(String barrage) {
        this.barrage = barrage;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormatList() {
        return formatList;
    }

    public void setFormatList(String formatList) {
        this.formatList = formatList;
    }

    public String getFormatCodeList() {
        return formatCodeList;
    }

    public void setFormatCodeList(String formatCodeList) {
        this.formatCodeList = formatCodeList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTotal_duration() {
        return total_duration;
    }

    public void setTotal_duration(String total_duration) {
        this.total_duration = total_duration;
    }

    public String getTotal_filesize() {
        return total_filesize;
    }

    public void setTotal_filesize(String total_filesize) {
        this.total_filesize = total_filesize;
    }

    public List<UrlBean> getUrl() {
        return url;
    }

    public void setUrl(List<UrlBean> url) {
        this.url = url;
    }

    public static class UrlBean {
        private String U;

        public UrlBean(String U) {
            this.U = U;
        }

        public String getU() {
            return U;
        }

        public void setU(String U) {
            this.U = U;
        }
    }
}
