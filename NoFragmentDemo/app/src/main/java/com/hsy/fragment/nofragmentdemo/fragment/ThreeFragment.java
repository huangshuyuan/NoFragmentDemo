package com.hsy.fragment.nofragmentdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hsy.fragment.nofragmentdemo.R;
import com.yanzhenjie.fragment.NoFragment;

/**
 * 作者：huangshuyuan on 2017/5/12 18:23
 * 邮箱：hshuyuan@foxmail.com
 */

public class ThreeFragment extends NoFragment {
    Toolbar toolbar;
    Button button, nextButton2;
    TextView textView;
    public static final int BACK_CODE = 1000;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        button = (Button) view.findViewById(R.id.nextButton);
        textView = (TextView) view.findViewById(R.id.message);
        nextButton2 = (Button) view.findViewById(R.id.nextButton2);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(toolbar);
        //设置标题
        setTitle(R.string.title_fragment_three);

        // 显示关闭按钮
        displayHomeAsUpEnabled(R.mipmap.ic_back_white);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String message = bundle.getString("hehe") + "\r\n";
            message += bundle.getString("meng") + "\r\n";
            message += bundle.getString("bang") + "\r\n";
            message += bundle.getString("meme") + "\r\n";

            textView.setText("获取到数据：\n" + message);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回数据
                startFragmentForResult(ThreeInfoFragment.class, BACK_CODE);
            }
        });

        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不在回退栈
                startFragment(FourFragment.class, false);
            }
        });
    }

    // 不论怎样回来都会回调onFragmentResult()。
    @Override
    public void onFragmentResult(int requestCode, int resultCode, @Nullable Bundle result) {
        switch (requestCode) {
            case BACK_CODE: {
                if (resultCode == RESULT_OK) {
                    // 操作成功：result就是调用的Fragment返回的结果。
                    textView.setText("成功:" + result.get("message"));
                } else if (resultCode == RESULT_CANCELED) {
                    // 操作取消。
                    textView.setText("失败");
                }
                break;
            }
        }
    }
}
