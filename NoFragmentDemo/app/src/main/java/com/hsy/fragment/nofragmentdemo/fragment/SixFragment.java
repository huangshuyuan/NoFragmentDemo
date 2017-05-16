package com.hsy.fragment.nofragmentdemo.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.hsy.fragment.nofragmentdemo.R;
import com.hsy.fragment.nofragmentdemo.adpter.BannerAdapter;
import com.hsy.fragment.nofragmentdemo.view.AutoPlayViewPager;
import com.yanzhenjie.fragment.NoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：huangshuyuan on 2017/5/16 14:46
 * 邮箱：hshuyuan@foxmail.com
 */

public class SixFragment extends NoFragment implements View.OnClickListener {
    private AutoPlayViewPager autoPlayViewPage;
    List<Integer> resIds;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_six, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        autoPlayViewPage = (AutoPlayViewPager) view.findViewById(R.id.autoviewPager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener();
        initData();
        initViewPager();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0之上使用
            //沉浸式状态栏
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }

    private void initViewPager() {
        BannerAdapter bannerAdapter = new BannerAdapter(getActivity());
        bannerAdapter.update(resIds);

        autoPlayViewPage.setAdapter(bannerAdapter);

        autoPlayViewPage.setDirection(AutoPlayViewPager.Direction.LEFT);// 设置播放方向
        autoPlayViewPage.setCurrentItem(200); // 设置每个Item展示的时间
        autoPlayViewPage.start(); // 开始轮播
    }

    private void initData() {
        resIds = new ArrayList<>();
        // 模拟几张图片
        resIds.add(R.mipmap.img5);
        resIds.add(R.mipmap.img);
        resIds.add(R.mipmap.img1);
        resIds.add(R.mipmap.img2);
        resIds.add(R.mipmap.img3);
        resIds.add(R.mipmap.img4);
        resIds.add(R.mipmap.img5);
        resIds.add(R.mipmap.img);

    }

    private void listener() {
        getView().findViewById(R.id.btn_scroll_change_left).setOnClickListener(this);
        getView().findViewById(R.id.btn_scroll_change_right).setOnClickListener(this);
        getView().findViewById(R.id.btn_scroll_previous).setOnClickListener(this);
        getView().findViewById(R.id.btn_scroll_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //点击事件
        switch (v.getId()) {
            case R.id.btn_scroll_previous:// 播放上一个
                autoPlayViewPage.previous();
                break;
            case R.id.btn_scroll_next:// 播放下一个
                autoPlayViewPage.next();
                break;
            case R.id.btn_scroll_change_left:// 改变为向左滑动
                autoPlayViewPage.setDirection(AutoPlayViewPager.Direction.LEFT);
                break;
            case R.id.btn_scroll_change_right:// 改变为向右滑动
                autoPlayViewPage.setDirection(AutoPlayViewPager.Direction.RIGHT);
                break;

        }
    }
}
