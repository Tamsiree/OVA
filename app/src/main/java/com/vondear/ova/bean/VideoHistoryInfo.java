package com.vondear.ova.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vonde on 2016/6/23.
 */
public class VideoHistoryInfo implements Parcelable {
    public static final Creator<VideoHistoryInfo> CREATOR = new Creator<VideoHistoryInfo>() {
        @Override
        public VideoHistoryInfo createFromParcel(Parcel in) {
            return new VideoHistoryInfo(in);
        }

        @Override
        public VideoHistoryInfo[] newArray(int size) {
            return new VideoHistoryInfo[size];
        }
    };
    /**
     * id : 26845
     * source_id : 1
     * cid : 3
     * anchor_id : 22
     * anchor_name : 谷阿莫说故事
     * avatar : http://106.75.18.222/Uploads/Picture/2016-07-07/577dec81a145f255236982.jpg
     * url : http://v.youku.com/v_show/id_XMTYzOTc3OTI5Ng==.html?from=y1.7-1.2
     * title : 【谷阿莫】5分鐘看完電影《2013超人：钢铁之躯+2016 蝙蝠侠大战超人》
     * duration : 05:48
     * publish_time : 1468231110
     * thumb : http://r3.ykimg.com/0541040857836CA96A0A4D2D90D279E2.jpg
     * play_count : 0
     */
    private int isCheck;
    private String lastPlayTime;
    private String id;
    private String source_id;
    private String cid;
    private String anchor_id;
    private String anchor_name;
    private String avatar;
    private String url;
    private String title;
    private String duration;
    private String publish_time;
    private String thumb;
    private String play_count;

    public VideoHistoryInfo(String id, String source_id, String cid, String anchor_id, String anchor_name, String avatar, String url, String title, String duration, String publish_time, String thumb, String play_count) {
        this.id = id;
        this.source_id = source_id;
        this.cid = cid;
        this.anchor_id = anchor_id;
        this.anchor_name = anchor_name;
        this.avatar = avatar;
        this.url = url;
        this.title = title;
        this.duration = duration;
        this.publish_time = publish_time;
        this.thumb = thumb;
        this.play_count = play_count;
    }

    protected VideoHistoryInfo(Parcel in) {
        id = in.readString();
        source_id = in.readString();
        cid = in.readString();
        anchor_id = in.readString();
        anchor_name = in.readString();
        avatar = in.readString();
        url = in.readString();
        title = in.readString();
        duration = in.readString();
        publish_time = in.readString();
        thumb = in.readString();
        play_count = in.readString();
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public String getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(String lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAnchor_id() {
        return anchor_id;
    }

    public void setAnchor_id(String anchor_id) {
        this.anchor_id = anchor_id;
    }

    public String getAnchor_name() {
        return anchor_name;
    }

    public void setAnchor_name(String anchor_name) {
        this.anchor_name = anchor_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPlay_count() {
        return play_count;
    }

    public void setPlay_count(String play_count) {
        this.play_count = play_count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(source_id);
        dest.writeString(cid);
        dest.writeString(anchor_id);
        dest.writeString(anchor_name);
        dest.writeString(avatar);
        dest.writeString(url);
        dest.writeString(title);
        dest.writeString(duration);
        dest.writeString(publish_time);
        dest.writeString(thumb);
        dest.writeString(play_count);
    }

    /**
     {
     "id":"26845",
     "source_id":"1",
     "cid":"3",
     "anchor_id":"22",
     "anchor_name":"谷阿莫说故事",
     "avatar":"http://106.75.18.222/Uploads/Picture/2016-07-07/577dec81a145f255236982.jpg",
     "url":"http://v.youku.com/v_show/id_XMTYzOTc3OTI5Ng==.html?from=y1.7-1.2",
     "title":"【谷阿莫】5分鐘看完電影《2013超人：钢铁之躯+2016 蝙蝠侠大战超人》",
     "duration":"05:48",
     "publish_time":"1468231110",
     "thumb":"http://r3.ykimg.com/0541040857836CA96A0A4D2D90D279E2.jpg",
     "play_count":"0"
     }
     */


}
