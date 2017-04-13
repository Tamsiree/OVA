package com.vondear.ova.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by vonde on 2016/6/23.
 */
public class VideoInfo implements Parcelable, Serializable {


    public static final Creator<VideoInfo> CREATOR = new Creator<VideoInfo>() {
        @Override
        public VideoInfo createFromParcel(Parcel in) {
            return new VideoInfo(in);
        }

        @Override
        public VideoInfo[] newArray(int size) {
            return new VideoInfo[size];
        }
    };
    private int cache_state;//缓存状态
    private String push_time;//推送时间
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
    //----------------------------------------------------------------------------------------------1.0.1新增 属性
    private String main_mid;
    private String main_icon;
    private String label;

    public VideoInfo(String id, String source_id, String cid, String anchor_id, String anchor_name, String avatar, String url, String title, String duration, String publish_time, String thumb, String play_count) {
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

    protected VideoInfo(Parcel in) {
        cache_state = in.readInt();
        push_time = in.readString();
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
        main_mid = in.readString();
        main_icon = in.readString();
        label = in.readString();
    }

    public int getCache_state() {
        return cache_state;
    }

    public void setCache_state(int cache_state) {
        this.cache_state = cache_state;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cache_state);
        dest.writeString(push_time);
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
        dest.writeString(main_mid);
        dest.writeString(main_icon);
        dest.writeString(label);
    }

    public String getPush_time() {
        return push_time;
    }

    public void setPush_time(String push_time) {
        this.push_time = push_time;
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

    public String getMain_mid() {
        return main_mid;
    }

    public void setMain_mid(String main_mid) {
        this.main_mid = main_mid;
    }

    public String getMain_icon() {
        return main_icon;
    }

    public void setMain_icon(String main_icon) {
        this.main_icon = main_icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
