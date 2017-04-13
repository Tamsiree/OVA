package com.vondear.ova.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.vondear.ova.R;
import com.vondear.ova.bean.TabEntity;
import com.vondear.ova.fragment.FragmentIM;
import com.vondear.ova.fragment.FragmentMultiple;
import com.vondear.ova.fragment.FragmentPersonal;
import com.vondear.ova.fragment.FragmentTools;
import com.vondear.rxtools.activity.ActivityBase;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class ActivityMain extends ActivityBase {

    CommonTabLayout mTabLayout_7;

    private String[] mTitles = {"首页", "消息", "工具", "我的"};

    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
        mTabLayout_7 = (CommonTabLayout) findViewById(R.id.app_7);
        mTabLayout_7.setTabData(mTabEntities, this, R.id.fl_change, mFragments);
    }

    private void initData() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mFragments.add(FragmentMultiple.newInstance("", ""));
        mFragments.add(FragmentIM.newInstance("", ""));
        mFragments.add(FragmentTools.newInstance("", ""));
        mFragments.add(FragmentPersonal.newInstance());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
