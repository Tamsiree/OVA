package com.vondear.ova.bean;

/**
 * Created by vonde on 2017/1/25.
 */

public class ToolsBean {

    private Class activity;

    private String name;

    private int iconRes;

    public ToolsBean(String name, int iconRes, Class activity) {
        this.activity = activity;
        this.name = name;
        this.iconRes = iconRes;
    }

    public ToolsBean(String name, int iconRes) {
        this.name = name;
        this.iconRes = iconRes;
    }

    public Class getActivity() {
        return activity;
    }

    public void setActivity(Class activity) {
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }
}
