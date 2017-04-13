package com.vondear.ova.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vondear.ova.R;
import com.vondear.ova.rong.SealConst;
import com.vondear.ova.rong.server.broadcast.BroadcastManager;
import com.vondear.rxtools.RxSPUtils;
import com.vondear.rxtools.RxUtils;
import com.vondear.rxtools.activity.ActivityBase;
import com.vondear.rxtools.view.dialog.RxDialogAcfunVideoLoading;
import com.vondear.rxtools.view.dialog.RxDialogSureCancel;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ActivitySet extends ActivityBase {

    @BindView(R.id.iv_finish)
    ImageView mIvFinish;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.ll_include_title)
    LinearLayout mLlIncludeTitle;
    @BindView(R.id.ll_live)
    LinearLayout mLlLive;
    @BindView(R.id.ll_goods_manager)
    LinearLayout mLlGoodsManager;
    @BindView(R.id.ll_buyer_reading)
    LinearLayout mLlBuyerReading;
    @BindView(R.id.ll_platform_agreement)
    LinearLayout mLlPlatformAgreement;
    @BindView(R.id.ll_about_us)
    LinearLayout mLlAboutUs;
    @BindView(R.id.ll_update)
    LinearLayout mLlUpdate;
    @BindView(R.id.btn_exit)
    Button mBtnExit;
    private Context context;
    private RxDialogAcfunVideoLoading spinKitLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题栏
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
        context = this;

        initView();
    }

    private void initView() {
        mLlIncludeTitle.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        spinKitLoadingView = new RxDialogAcfunVideoLoading(context);
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RxDialogSureCancel dialogSureCancle = new RxDialogSureCancel(context);

                dialogSureCancle.setTitle("  确认退出登录？");
//                dialogSureCancle.getTv_cancle().setTextColor(Color.parseColor("#FDBE13"));
                dialogSureCancle.getTvCancel().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogSureCancle.cancel();
                    }
                });
//                dialogSureCancle.getTv_sure().setTextColor(Color.parseColor("#333333"));
                dialogSureCancle.getTvSure().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinKitLoadingView.setCancelable(false);
                        spinKitLoadingView.show();
                        RxSPUtils.clearPreference(context, "uid", null);
                        RxSPUtils.clearPreference(context, "NICKNAME", null);
                        RxSPUtils.clearPreference(context, "AVATAR", null);
                        BroadcastManager.getInstance(mContext).sendBroadcast(SealConst.EXIT);
                        RxUtils.delayToDo(new RxUtils.DelayListener() {
                            @Override
                            public void doSomething() {
                                dialogSureCancle.cancel();
                                spinKitLoadingView.cancel();
                            }
                        }, 2000);
                    }
                });
                dialogSureCancle.show();
            }
        });

        mIvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

