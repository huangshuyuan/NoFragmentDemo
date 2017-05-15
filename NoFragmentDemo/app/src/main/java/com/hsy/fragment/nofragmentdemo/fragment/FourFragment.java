package com.hsy.fragment.nofragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hsy.fragment.nofragmentdemo.R;
import com.yanzhenjie.fragment.NoFragment;

/**
 * 作者：huangshuyuan on 2017/5/12 21:22
 * 邮箱：hshuyuan@foxmail.com
 */

public class FourFragment extends NoFragment {
    Toolbar toolbar;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_four, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        button = (Button) view.findViewById(R.id.nextButton);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(toolbar);
        //设置标题
        setTitle(R.string.title_fragment_three_info);

        // 显示关闭按钮
        displayHomeAsUpEnabled(R.mipmap.ic_back_white);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
