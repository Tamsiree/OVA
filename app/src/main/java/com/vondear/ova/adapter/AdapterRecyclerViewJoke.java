package com.vondear.ova.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.vondear.ova.R;
import com.vondear.ova.bean.JokeBean;
import com.vondear.rxtools.RxTimeUtils;

import java.util.List;

public class AdapterRecyclerViewJoke extends BaseQuickAdapter<JokeBean, BaseViewHolder> {

    public AdapterRecyclerViewJoke(List<JokeBean> items) {
        super(R.layout.item_joke, items);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final JokeBean jokeBean) {
        holder.setText(R.id.tv_content_joke, jokeBean.getGroup().getContent());
        holder.setText(R.id.tv_author_joke, jokeBean.getGroup().getUser().getName());
        holder.setText(R.id.tv_time_joke, RxTimeUtils.getDate(jokeBean.getGroup().getCreate_time() + "", "yyyy-MM-dd"));
        holder.setText(R.id.tv_like_joke, jokeBean.getGroup().getDigg_count() + "");
        holder.setText(R.id.tv_comment_count_joke, jokeBean.getGroup().getComment_count() + "");
        holder.setText(R.id.tv_unlike_joke, jokeBean.getGroup().getBury_count() + "");
    }
}
