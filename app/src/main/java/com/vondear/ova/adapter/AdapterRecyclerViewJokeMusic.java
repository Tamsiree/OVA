package com.vondear.ova.adapter;


import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.vondear.ova.R;
import com.vondear.ova.bean.JokeMusicBean;
import com.vondear.ova.bean.JokeVideoBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class AdapterRecyclerViewJokeMusic extends BaseQuickAdapter<JokeMusicBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean, BaseViewHolder> {

    public AdapterRecyclerViewJokeMusic(List<JokeMusicBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> items) {
        super(R.layout.item_video, items);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final JokeMusicBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean jokeBean) {
        JCVideoPlayer videoplayer = holder.getView(R.id.videoplayer);
        if (jokeBean != null) {
            videoplayer.setUp(jokeBean.getVoice_uri(), jokeBean.getText().trim().replaceAll("\\\\s*|\\t|\\r|\\n", ""));

            Glide.with(mContext).
                    load(jokeBean.getImage3()).
                    diskCacheStrategy(DiskCacheStrategy.RESULT).
                    thumbnail(0.5f).
                    priority(Priority.HIGH).
                    placeholder(R.drawable.pikachu_video).
                    error(R.drawable.pikachu_video).
                    fallback(R.drawable.pikachu_video).
                    dontAnimate().
                    into(videoplayer.ivThumb);

            holder.setText(R.id.tv_author, jokeBean.getName());
            holder.setText(R.id.tv_time, jokeBean.getCreate_time());
            holder.setText(R.id.tv_like, jokeBean.getLove());
            holder.setText(R.id.tv_comment_count, jokeBean.getLove());
            holder.setText(R.id.tv_unlike, String.valueOf(jokeBean.getHate()));
        } else {
            videoplayer.setUp(JokeVideoBean.lckmp4url, "个人视频");
            Glide.with(mContext).
                    load(JokeVideoBean.lckimg).
                    diskCacheStrategy(DiskCacheStrategy.RESULT).
                    thumbnail(0.5f).
                    priority(Priority.HIGH).
                    placeholder(R.drawable.pikachu_video).
                    error(R.drawable.pikachu_video).
                    fallback(R.drawable.pikachu_video).
                    dontAnimate().
                    into(videoplayer.ivThumb);
        }
    }
}
