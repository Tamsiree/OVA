package com.vondear.ova.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.vondear.ova.R;
import com.vondear.ova.bean.JokePictureBean;
import com.vondear.ova.utils.AppTools;
import com.vondear.rxtools.RxDeviceUtils;

import java.util.List;

public class AdapterRecyclerViewJokePicture extends BaseQuickAdapter<JokePictureBean, BaseViewHolder> {

    public AdapterRecyclerViewJokePicture(List<JokePictureBean> items) {
        super(R.layout.item_pic, items);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final JokePictureBean jokeBean) {
        final String picUrl = jokeBean.getPics().get(0);
        final ImageView img = holder.getView(R.id.img);
        if (picUrl.endsWith(".gif")) {
            holder.getView(R.id.img_gif).setVisibility(View.GONE);
            //非WIFI网络情况下，GIF图只加载缩略图，详情页才加载真实图片
            Glide.with(mContext).
                    load(picUrl).
                    diskCacheStrategy(DiskCacheStrategy.SOURCE).
                    thumbnail(0.5f).
                    priority(Priority.LOW).
                    error(R.drawable.failure).
                    dontAnimate().
                    into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            int imageWidth = resource.getIntrinsicWidth();
                            int imageHeight = resource.getIntrinsicHeight();
                            int height = RxDeviceUtils.getScreenWidth(mContext) * imageHeight / imageWidth;
                            ViewGroup.LayoutParams para = img.getLayoutParams();
                            para.height = height;
                            img.setLayoutParams(para);
                            Glide.with(mContext).
                                    load(picUrl).
                                    placeholder(R.color.brown3).
                                    fallback(R.color.brown3).
                                    into(img);
                        }
                    });
        } else {
            holder.getView(R.id.img_gif).setVisibility(View.GONE);

            Glide.with(mContext).
                    load(picUrl).
                    diskCacheStrategy(DiskCacheStrategy.SOURCE).
                    thumbnail(0.5f).
                    priority(Priority.HIGH).
                    error(R.drawable.failure).
                    dontAnimate().
                    into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            int imageWidth = resource.getIntrinsicWidth();
                            int imageHeight = resource.getIntrinsicHeight();
                            int height = RxDeviceUtils.getScreenWidth(mContext) * imageHeight / imageWidth;
                            ViewGroup.LayoutParams para = img.getLayoutParams();
                            para.height = height;
                            img.setLayoutParams(para);
                            Glide.with(mContext).
                                    load(picUrl).
                                    placeholder(R.color.brown3).
                                    fallback(R.color.brown3).
                                    into(img);
                        }
                    });
        }
        ProgressBar progress = holder.getView(R.id.progress);
        progress.setProgress(0);
        progress.setVisibility(View.VISIBLE);

        TextView tv_content = holder.getView(R.id.tv_content);

        if (TextUtils.isEmpty(jokeBean.getText_content().trim())) {
            tv_content.setVisibility(View.GONE);
        } else {
            tv_content.setVisibility(View.VISIBLE);
            tv_content.setText(jokeBean.getText_content().trim());
        }
        holder.setText(R.id.tv_author, jokeBean.getComment_author());
        holder.setText(R.id.tv_time, AppTools.dateString2GoodExperienceFormat(jokeBean.getComment_date()));
        holder.setText(R.id.tv_like, jokeBean.getVote_positive());
        holder.setText(R.id.tv_unlike, jokeBean.getVote_negative());
        holder.setText(R.id.tv_comment_count, 109 + "");

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (picUrl.endsWith(".gif")) {

                }
            }
        });
    }
}
