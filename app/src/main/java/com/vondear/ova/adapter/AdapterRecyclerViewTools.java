package com.vondear.ova.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.vondear.ova.R;
import com.vondear.ova.bean.ToolsBean;
import com.vondear.rxtools.RxActivityUtils;

import java.util.List;


public class AdapterRecyclerViewTools extends BaseQuickAdapter<ToolsBean, BaseViewHolder> {


    public AdapterRecyclerViewTools(List<ToolsBean> items) {
        super(R.layout.item_tools, items);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final ToolsBean toolsBean) {
        holder.setText(R.id.tv_name, toolsBean.getName());

        Glide.with(mContext).
                load(toolsBean.getIconRes()).
                diskCacheStrategy(DiskCacheStrategy.RESULT).
                thumbnail(0.5f).
                priority(Priority.HIGH).
                placeholder(R.drawable.pikachu_video).
                error(R.drawable.pikachu_video).
                fallback(R.drawable.pikachu_video).
                into(((ImageView) holder.getView(R.id.iv_tool_icon)));

        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxActivityUtils.skipActivity(mContext, toolsBean.getActivity());
            }
        });

    }
}
