package com.hsy.fragment.nofragmentdemo.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hsy.fragment.nofragmentdemo.R;
import com.hsy.fragment.nofragmentdemo.adpter.GanHuoAdapter;
import com.yanzhenjie.fragment.NoFragment;

/**
 * 作者：huangshuyuan on 2017/5/19 11:51
 * 邮箱：hshuyuan@foxmail.com
 */

public class SevenFragment extends NoFragment {
    private AppBarLayout appbarLayout;
    private Toolbar toolbar;
    private ViewPager viewpager;
    private String[] mTitles;
    private TabLayout mTabLayout;//标题栏

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_seven, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appbarLayout = (AppBarLayout) view.findViewById(R.id.appbar_layout);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(toolbar);
        //设置标题
        setTitle(R.string.title_fragment_seven);

        // 显示关闭按钮
        displayHomeAsUpEnabled(R.mipmap.ic_back_white);
        initView();
    }

    GanHuoAdapter adpter;

    private void initView() {
        /**
         * 标题栏
         */
        mTitles = new String[]{"all", "福利", "Android", "iOS", "前端", "拓展资源", "休息视频", "瞎推荐"};
        for (int i = 0; i < mTitles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles[i]));
        }

        adpter = new GanHuoAdapter(getChildFragmentManager(), mTitles);
        viewpager.setAdapter(adpter);

        new SetAdapterTask().execute();
    }


    private class SetAdapterTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            if (adpter != null) {
                viewpager.setAdapter(adpter);
                mTabLayout.setupWithViewPager(viewpager);
            }
        }
    }
}
