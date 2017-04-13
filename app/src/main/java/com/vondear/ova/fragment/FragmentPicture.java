package com.vondear.ova.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.GetRequest;
import com.vondear.ova.Constants;
import com.vondear.ova.R;
import com.vondear.ova.adapter.AdapterRecyclerViewJokePicture;
import com.vondear.ova.bean.JokePictureBean;
import com.vondear.ova.view.CustomAnimation;
import com.vondear.rxtools.fragment.FragmentLazy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPicture#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPicture extends FragmentLazy implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.recycler_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.iv_top)
    ImageView mIvTop;
    int page = 2;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootView;
    private LayoutInflater inflater;
    private Context mContext;
    private View errorView;
    private View loadingView;
    private boolean mLoadMoreEndGone = false;

    private boolean mError = true;

    private AdapterRecyclerViewJokePicture mAdapterRecyclerViewJokePicture;

    private List<JokePictureBean> mList = new ArrayList<>();

    public FragmentPicture() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPicture.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPicture newInstance(String param1, String param2) {
        FragmentPicture fragment = new FragmentPicture();
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
        rootView = inflater.inflate(R.layout.fragment_picture, container, false);
        ButterKnife.bind(this, rootView);
        mContext = getActivity();
        this.inflater = inflater;
        initView();
        mAdapterRecyclerViewJokePicture.setEmptyView(loadingView);
        return rootView;
    }

    @Override
    protected void initData() {
        initData(1);
    }


    private void initView() {
        initEvent();
        initLoadingView();
        initFragmentView();
    }

    private void initEvent() {
        mIvTop.setVisibility(View.GONE);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (manager.findFirstVisibleItemPosition() > 2) {
                    //dy用来判断纵向滑动方向
                    if (dy > 5) {
                        //大于0表示正在向上滚动
//                        ivTop.startAnimation(AnimationUtils.loadAnimation(context,R.anim.activity_open_down));
                        mIvTop.setVisibility(View.GONE);
                    } else if (dy < -5) {
//                        ivTop.startAnimation(AnimationUtils.loadAnimation(context,R.anim.activity_close_up));
                        mIvTop.setVisibility(View.VISIBLE);
                    }
                } else {
                    mIvTop.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initLoadingView() {
        loadingView = inflater.inflate(R.layout.loading_view, (ViewGroup) mRecyclerView.getParent(), false);
        errorView = inflater.inflate(R.layout.error_view, (ViewGroup) mRecyclerView.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterRecyclerViewJokePicture.setEmptyView(loadingView);
                onRefresh();
            }
        });
    }

    private void initFragmentView() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        initAdapter();
    }

    private void initAdapter() {
        mAdapterRecyclerViewJokePicture = new AdapterRecyclerViewJokePicture(mList);
        mAdapterRecyclerViewJokePicture.setOnLoadMoreListener(this);
        mAdapterRecyclerViewJokePicture.openLoadAnimation(new CustomAnimation());
//        mQuickAdapter.setAutoLoadMoreSize(3);
        mRecyclerView.setAdapter(mAdapterRecyclerViewJokePicture);
    }

    @Override
    public void onRefresh() {
        mAdapterRecyclerViewJokePicture.setEnableLoadMore(false);
        initData(1);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        initData(page);
    }

    private void initData(final int p) {
        GetRequest baseRequest = OkGo.get(Constants.URL_BORING_PICTURE + p);     // 请求方式和请求url

        baseRequest
                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)    // 缓存模式，详细请看缓存介绍
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        // s 即为所需要的结果
                        try {
//                            Logger.json(s);
                            JSONObject mJsonObject = new JSONObject(s);
                            mError = true;
                            if (mJsonObject.getString("status").equals("ok")) {
                                JSONArray dataJson = mJsonObject.getJSONArray("comments");
                                Gson gson = new Gson();
                                List<JokePictureBean> jokeBeanList = gson.fromJson(dataJson.toString(), new TypeToken<List<JokePictureBean>>() {
                                }.getType());
                                if (p == 1) {
                                    mError = true;
                                    mList = jokeBeanList;
                                    page = 2;
                                } else {
                                    page++;
                                    mAdapterRecyclerViewJokePicture.addData(jokeBeanList);
                                    mLoadMoreEndGone = true;
                                    mAdapterRecyclerViewJokePicture.loadMoreComplete();
                                }
                            } else {
                                mLoadMoreEndGone = false;
                                mAdapterRecyclerViewJokePicture.loadMoreEnd(mLoadMoreEndGone);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        if (p == 1) {
                            mError = false;
                        }
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);
                        if (p == 1) {
                            if (mError) {
                                mAdapterRecyclerViewJokePicture.setNewData(mList);
                                mSwipeRefreshLayout.setRefreshing(false);
                                mAdapterRecyclerViewJokePicture.setEnableLoadMore(true);
                            } else {
                                mAdapterRecyclerViewJokePicture.setEmptyView(errorView);
                                mError = true;
                            }
                        } else {
                            mSwipeRefreshLayout.setEnabled(true);
                        }
                    }
                });
    }

    @OnClick(R.id.iv_top)
    public void onClick() {
        LinearLayoutManager manager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        if (manager.findFirstVisibleItemPosition() != 0) {
            mRecyclerView.scrollToPosition(10);
            mRecyclerView.smoothScrollToPosition(0);
        }
    }
}
