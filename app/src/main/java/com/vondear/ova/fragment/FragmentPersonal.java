package com.vondear.ova.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.vondear.ova.R;
import com.vondear.ova.activity.ActivitySet;
import com.vondear.rxtools.RxActivityUtils;
import com.vondear.rxtools.RxDataUtils;
import com.vondear.rxtools.RxPhotoUtils;
import com.vondear.rxtools.RxSPUtils;
import com.vondear.rxtools.RxUtils;
import com.vondear.rxtools.fragment.FragmentLazy;
import com.vondear.rxtools.view.RxTitle;
import com.vondear.rxtools.view.RxToast;
import com.vondear.rxtools.view.dialog.RxDialog;
import com.vondear.rxtools.view.dialog.RxDialogAcfunVideoLoading;
import com.vondear.rxtools.view.dialog.RxDialogEditSureCancel;
import com.vondear.rxtools.view.dialog.RxDialogWheelYearMonthDay;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static android.app.Activity.RESULT_OK;

/**
 * Created by vonde on 2016/11/23.
 */

public class FragmentPersonal extends FragmentLazy {


    @BindView(R.id.tv_bg)
    TextView mTvBg;
    @BindView(R.id.iv_avatar_1)
    ImageView mIvAvatar;
    @BindView(R.id.ll_anchor_left)
    LinearLayout mLlAnchorLeft;
    @BindView(R.id.rl_avatar)
    RelativeLayout mRlAvatar;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_constellation)
    TextView mTvConstellation;
    @BindView(R.id.tv_birthday)
    TextView mTvBirthday;
    @BindView(R.id.ll_birthday)
    LinearLayout mLlBirthday;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_lables)
    TextView mTvLables;
    @BindView(R.id.textView2)
    TextView mTextView2;
    @BindView(R.id.editText2)
    TextView mEditText2;
    @BindView(R.id.activity_user)
    LinearLayout mActivityUser;
    Unbinder unbinder;
    @BindView(R.id.rx_title)
    RxTitle mRxTitle;


    String avatar;
    private View rootView;
    private Context context;
    private RxDialogAcfunVideoLoading spinKitLoadingView;
    private RxDialogWheelYearMonthDay mDialogWheelYearMonthDay;

    public FragmentPersonal() {

    }

    public static FragmentPersonal newInstance() {
        FragmentPersonal fragmentPersonal = new FragmentPersonal();
        return fragmentPersonal;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_personal, container, false);
        ButterKnife.bind(this, rootView);
        context = getContext();
        return rootView;
    }

    @Override
    protected void initData() {
        initView();
    }

    private void initView() {
        avatar = RxSPUtils.getContent(RxUtils.getContext(), "AVATAR");
        Glide.with(this).
                load(avatar).
                diskCacheStrategy(DiskCacheStrategy.RESULT).
                bitmapTransform(new CropCircleTransformation(context)).
                thumbnail(0.5f).
                placeholder(R.drawable.elves_ball).
                priority(Priority.LOW).
                error(R.drawable.elves_ball).
                fallback(R.drawable.elves_ball).
                dontAnimate().
                into(mIvAvatar);

        mRxTitle.setRightIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxActivityUtils.skipActivity(context, ActivitySet.class);
            }
        });

        spinKitLoadingView = new RxDialogAcfunVideoLoading(context);


        mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialogOpenAvatar();
            }
        });

        mIvAvatar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showBigImageView(Uri.parse(avatar));

                return false;
            }
        });

        mTvConstellation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxToast.showToast(context, "选择生日就会自动判断的哦", 500);
            }
        });

        mTvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final RxDialogEditSureCancel dialogEditTextSureCancle = new RxDialogEditSureCancel(context);
                dialogEditTextSureCancle.getEditText().setText(mTvName.getText());
//                dialogEditTextSureCancle.getTv_title().setText("  确认退出登录？");
//                dialogSureCancle.getTv_cancle().setTextColor(Color.parseColor("#FDBE13"));
                dialogEditTextSureCancle.getTvCancel().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogEditTextSureCancle.cancel();
                    }
                });
//                dialogSureCancle.getTv_sure().setTextColor(Color.parseColor("#333333"));
                dialogEditTextSureCancle.getTvSure().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str = dialogEditTextSureCancle.getEditText().getText().toString();

                        if (RxDataUtils.isNullString(str)) {
                            RxToast.showToast(context, "昵称不能为空", 500);
                        } else {
                            spinKitLoadingView.show();
                            dialogEditTextSureCancle.cancel();
                        }
                    }
                });
                dialogEditTextSureCancle.show();
            }
        });
    }

    private void initDialogOpenAvatar() {
        final RxDialog dialog1 = new RxDialog(context);
        dialog1.getLayoutParams().gravity = Gravity.BOTTOM;
        View dialogView1 = LayoutInflater.from(context).inflate(
                R.layout.dialog_picker_pictrue, null);
        TextView tv_camera = (TextView) dialogView1
                .findViewById(R.id.tv_camera);
        TextView tv_file = (TextView) dialogView1
                .findViewById(R.id.tv_file);
        TextView tv_cancelid = (TextView) dialogView1
                .findViewById(R.id.tv_cancel);
        tv_cancelid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog1.cancel();
            }
        });
        tv_camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {//请求Camera权限
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    RxPhotoUtils.openCameraImage(FragmentPersonal.this);
                    dialog1.cancel();
                }
            }
        });
        tv_file.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                RxPhotoUtils.openLocalImage(FragmentPersonal.this);
                dialog1.cancel();
            }
        });
        dialog1.setContentView(dialogView1);
        dialog1.show();
    }

    /**
     * 查看原图
     *
     * @param uri
     */
    private void showBigImageView(Uri uri) {
        RxDialog transparentDialog = new RxDialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.image, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.page_item);
        Glide.with(context).
                load(uri).
                diskCacheStrategy(DiskCacheStrategy.RESULT).
                thumbnail(0.5f).
                placeholder(R.drawable.elves_ball).
                priority(Priority.LOW).
                error(R.drawable.elves_ball).
                fallback(R.drawable.elves_ball).
                dontAnimate().
                into(imageView);
        transparentDialog.setContentView(view);
        transparentDialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RxPhotoUtils.GET_IMAGE_FROM_PHONE:
                if (resultCode == RESULT_OK) {
//                    RxPhotoUtils.cropImage(ActivitySet.this, );// 裁剪图片
                    initUCrop(data.getData());
                }

                break;
            case RxPhotoUtils.GET_IMAGE_BY_CAMERA:
                if (resultCode == RESULT_OK) {
                   /* data.getExtras().get("data");*/
//                    RxPhotoUtils.cropImage(ActivitySet.this, RxPhotoUtils.imageUriFromCamera);// 裁剪图片
                    initUCrop(RxPhotoUtils.imageUriFromCamera);
                }

                break;
            case RxPhotoUtils.CROP_IMAGE:
                Glide.with(context).
                        load(RxPhotoUtils.cropImageUri).
                        diskCacheStrategy(DiskCacheStrategy.RESULT).
                        bitmapTransform(new CropCircleTransformation(context)).
                        thumbnail(0.5f).
                        placeholder(R.drawable.elves_ball).
                        priority(Priority.LOW).
                        error(R.drawable.elves_ball).
                        fallback(R.drawable.elves_ball).
                        dontAnimate().
                        into(mIvAvatar);
//                RequestUpdateAvatar(new File(RxPhotoUtils.getRealFilePath(context, RxPhotoUtils.cropImageUri)));
              /*  if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    //--------------------------------
*//*                    if (extras != null) {
                        Bitmap photo = extras.getParcelable("data");
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);// (0 -
                        // 100)压缩文件
                        // imageView.setImageBitmap(photo);
                        ivAvatar.setImageBitmap(photo);
                        File file = new File(Environment.getExternalStorageDirectory()
                                + "/imgHead.jpg");// 将要保存图片的路径
                        OutputStream stream11 = null;
                        try {
                            stream11 = new FileOutputStream(Environment.getExternalStorageDirectory() + "/imgHead.jpg");
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        photo.compress(Bitmap.CompressFormat.JPEG, 100, stream11);*//*
                    //=================================

                    if (head != null) {
                        *//**
             * 上传服务器代码
             *//*
                        // setPicToView(head);// 保存在SD卡中
                        ivAvatar.setImageBitmap(head);// 用ImageView显示出来
                    }
                }*/
                break;

            case UCrop.REQUEST_CROP:
                if (resultCode == RESULT_OK) {
                    final Uri resultUri = UCrop.getOutput(data);
                    Glide.with(context).
                            load(resultUri).
                            diskCacheStrategy(DiskCacheStrategy.RESULT).
                            bitmapTransform(new CropCircleTransformation(context)).
                            thumbnail(0.5f).
                            placeholder(R.drawable.elves_ball).
                            priority(Priority.LOW).
                            error(R.drawable.elves_ball).
                            fallback(R.drawable.elves_ball).
                            dontAnimate().
                            into(mIvAvatar);


//                    RequestUpdateAvatar(new File(RxPhotoUtils.getImageAbsolutePath(ActivitySet.this, resultUri)));
                    avatar = resultUri.toString();
                    RxSPUtils.putContent(context, "AVATAR", avatar);
                } else if (resultCode == UCrop.RESULT_ERROR) {
                    final Throwable cropError = UCrop.getError(data);
                }
                break;
            case UCrop.RESULT_ERROR:
                final Throwable cropError = UCrop.getError(data);
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initUCrop(Uri uri) {

//        Uri destinationUri = RxPhotoUtils.createImagePathUri(this);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        long time = System.currentTimeMillis();
        String imageName = timeFormatter.format(new Date(time));

        Uri destinationUri = Uri.fromFile(new File(context.getCacheDir(), imageName + ".jpeg"));

        UCrop.Options options = new UCrop.Options();
        //设置裁剪图片可操作的手势
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        //设置隐藏底部容器，默认显示
        //options.setHideBottomControls(true);
        //设置toolbar颜色
        options.setToolbarColor(ActivityCompat.getColor(context, R.color.colorPrimary));
        //设置状态栏颜色
        options.setStatusBarColor(ActivityCompat.getColor(context, R.color.colorPrimaryDark));

        //开始设置
        //设置最大缩放比例
        options.setMaxScaleMultiplier(5);
        //设置图片在切换比例时的动画
        options.setImageToCropBoundsAnimDuration(666);
        //设置裁剪窗口是否为椭圆
//        options.setOvalDimmedLayer(true);
        //设置是否展示矩形裁剪框
//        options.setShowCropFrame(false);
        //设置裁剪框横竖线的宽度
//        options.setCropGridStrokeWidth(20);
        //设置裁剪框横竖线的颜色
//        options.setCropGridColor(Color.GREEN);
        //设置竖线的数量
//        options.setCropGridColumnCount(2);
        //设置横线的数量
//        options.setCropGridRowCount(1);

        UCrop.of(uri, destinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(1000, 1000)
                .withOptions(options)
                .start(context, FragmentPersonal.this);
    }

    @OnClick({R.id.ll_birthday})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_birthday:
                if (mDialogWheelYearMonthDay == null) {
                    initWheelYearMonthDayDialog();
                }
                if (!mDialogWheelYearMonthDay.isShowing()) {
                    mDialogWheelYearMonthDay.show();
                }
                break;
        }
    }

    private void initWheelYearMonthDayDialog() {
        // ------------------------------------------------------------------选择日期开始
        mDialogWheelYearMonthDay = new RxDialogWheelYearMonthDay(getActivity(), 1950);
        mDialogWheelYearMonthDay.getTv_sure().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        if (mDialogWheelYearMonthDay.getCheckBox_day().isChecked()) {
                            mTvBirthday.setText(mDialogWheelYearMonthDay.getSelectorYear() + "年"
                                    + mDialogWheelYearMonthDay.getSelectorMonth() + "月"
                                    + mDialogWheelYearMonthDay.getSelectorDay() + "日");
                        } else {
                            mTvBirthday.setText(mDialogWheelYearMonthDay.getSelectorYear() + "年"
                                    + mDialogWheelYearMonthDay.getSelectorMonth() + "月");
                        }
                        mTvConstellation.setText(RxDataUtils.getAstro(
                                RxDataUtils.stringToInt(mDialogWheelYearMonthDay.getSelectorMonth()),
                                RxDataUtils.stringToInt(mDialogWheelYearMonthDay.getSelectorDay())));
                        mDialogWheelYearMonthDay.cancel();
                    }
                });
        mDialogWheelYearMonthDay.getTv_cancle().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        mDialogWheelYearMonthDay.cancel();
                    }
                });
        // ------------------------------------------------------------------选择日期结束
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
