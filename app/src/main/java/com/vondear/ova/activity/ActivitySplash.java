package com.vondear.ova.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import com.vondear.ova.R;
import com.vondear.ova.rong.SealAppContext;
import com.vondear.rxtools.RxActivityUtils;
import com.vondear.rxtools.RxBarUtils;
import com.vondear.rxtools.RxUtils;

import io.rong.imkit.RongIM;

public class ActivitySplash extends Activity implements RxUtils.DelayListener {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBarUtils.noTitle(this);
        RxBarUtils.setTransparentStatusBar(this);
        setContentView(R.layout.activity_splash);
        mContext = this;
        RxUtils.delayToDo(this, 3000);
    }

    @Override
    public void doSomething() {
        /*if (VonDataUtils.isNullString(VonSPUtils.getContent(this,"uid"))) {
            VonActivityUtils.skipActivityAndFinish(mContext, ActivityLogin.class);
        }else{
            VonActivityUtils.skipActivityAndFinish(mContext, ActivityMain.class);
        }*/
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        String cacheToken = sp.getString("loginToken", "");
        if (!TextUtils.isEmpty(cacheToken)) {
            RongIM.connect(cacheToken, SealAppContext.getInstance().getConnectCallback());
            RxActivityUtils.skipActivityAndFinish(mContext, ActivityMain.class);
        } else {
            RxActivityUtils.skipActivityAndFinish(mContext, ActivityLogin.class);
        }
    }
}
