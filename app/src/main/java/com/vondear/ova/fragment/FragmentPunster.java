package com.vondear.ova.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.vondear.ova.R;
import com.vondear.rxtools.fragment.FragmentLazy;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPunster#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPunster extends FragmentLazy {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final String[] Cname = {"段子", "图片", "美女", "音乐", "视频"};//视频 分类
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootView;

    public FragmentPunster() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPunster.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPunster newInstance(String param1, String param2) {
        FragmentPunster fragment = new FragmentPunster();
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
        rootView = inflater.inflate(R.layout.fragment_punster, container, false);

        return rootView;
    }

    @Override
    protected void initData() {
        initView();
    }

    private void initView() {
        SlidingTabLayout tabLayout_7 = (SlidingTabLayout) rootView.findViewById(R.id.tl_punster);
        ViewPager main_viewpager = (ViewPager) rootView.findViewById(R.id.punster_viewpager);
        main_viewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        FragmentJoke fragmentJoke = FragmentJoke.newInstance("", "");
                        return fragmentJoke;
                    case 1:
                        FragmentPicture fragmentPicture = FragmentPicture.newInstance("", "");
                        return fragmentPicture;
                    case 2:
                        FragmentPicturePeri fragmentPicturePeri = FragmentPicturePeri.newInstance("", "");
                        return fragmentPicturePeri;
                    case 3:
                        FragmentMusic fragmentMusic = FragmentMusic.newInstance("", "");
                        return fragmentMusic;
                    default:
                        FragmentBlank fragmentItem = FragmentBlank.newInstance("", "");
                        return fragmentItem;
                }

            }

            @Override
            public int getCount() {
                return Cname.length;
            }
        });
        tabLayout_7.setViewPager(main_viewpager, Cname);
    }
}
