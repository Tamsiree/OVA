package com.vondear.ova.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vondear.ova.R;
import com.vondear.ova.adapter.AdapterRecyclerViewTools;
import com.vondear.ova.bean.ToolsBean;
import com.vondear.rxtools.activity.ActivityCodeTool;
import com.vondear.rxtools.fragment.FragmentLazy;
import com.vondear.rxtools.view.RxTitle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentTools extends FragmentLazy {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rx_title)
    RxTitle mRxTitle;
    @BindView(R.id.recycler_list)
    RecyclerView mRecyclerList;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeLayout;
    Unbinder unbinder;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<ToolsBean> mToolsBeen = new ArrayList<>();

    public FragmentTools() {
        // Required empty public constructor
    }


    public static FragmentTools newInstance(String param1, String param2) {
        FragmentTools fragment = new FragmentTools();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    protected void initData() {

    }

    private void initView() {
        mRecyclerList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        if (mToolsBeen.isEmpty()) {
            mToolsBeen.add(new ToolsBean("二维码与条形码\n扫描与生成", R.drawable.scan_barcode, ActivityCodeTool.class));
        }
        mRecyclerList.setAdapter(new AdapterRecyclerViewTools(mToolsBeen));
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
