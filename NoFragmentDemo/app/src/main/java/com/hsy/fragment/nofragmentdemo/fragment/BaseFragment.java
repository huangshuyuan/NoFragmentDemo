package com.hsy.fragment.nofragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hsy.fragment.nofragmentdemo.R;
import com.yanzhenjie.fragment.NoFragment;

/**
 * 作者：huangshuyuan on 2017/5/15 11:29
 * 邮箱：hshuyuan@foxmail.com
 */

public class BaseFragment extends NoFragment {
    private Toolbar mToolbar;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(mToolbar);//初始化标题栏


    }


    /**
     * @param resId 资源文件
     */
    @Override
    public void setTitle(@StringRes int resId) {
        TextView titleTV = (TextView) getView().findViewById(R.id.toolbar_title);
        titleTV.setText(getContext().getText(resId));
    }

    public void setTitle(String title) {
        TextView titleTV = (TextView) getView().findViewById(R.id.toolbar_title);
        titleTV.setText(title);
    }
}
