package com.vondear.ova.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vondear.ova.R;

import java.util.List;

public class AdapterRecyclerViewAnchorTag extends RecyclerView.Adapter<AdapterRecyclerViewAnchorTag.ViewHolder> {

    private final List<String> mValues;
    private final OnListAnchorListener mListener;
    private View view;
    private Context context;

    public AdapterRecyclerViewAnchorTag(List<String> items, OnListAnchorListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anchor_tag, parent, false);
        context = view.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.tv_tag_name.setText(mValues.get(position));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentAnchor(holder.mItem);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface OnListAnchorListener {
        // TODO: Update argument type and name
        void onListFragmentAnchor(String item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tv_tag_name;
        public String mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tv_tag_name = (TextView) view.findViewById(R.id.tv_tag_name);
        }

    }
}
