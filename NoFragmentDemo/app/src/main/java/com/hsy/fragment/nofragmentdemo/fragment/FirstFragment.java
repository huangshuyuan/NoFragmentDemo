package com.hsy.fragment.nofragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hsy.fragment.nofragmentdemo.R;
import com.yanzhenjie.fragment.NoFragment;

/**
 * 作者：huangshuyuan on 2017/5/12 15:21
 * 邮箱：hshuyuan@foxmail.com
 */

public class FirstFragment extends NoFragment {
    Button button;
    Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        button = (Button) view.findViewById(R.id.fistButton);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(mToolbar);

        //设置标题
        setTitle(R.string.title_fragment_first);

        // 显示关闭按钮
        displayHomeAsUpEnabled(R.mipmap.ic_back_white);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动一个新的Fragment
                startFragment(FirstFragment.class);
            }
        });
        Snackbar.make(mToolbar, "启动一次", Snackbar.LENGTH_SHORT).show();
    }
    // ========================= Close Button ========================= //

    @Override
    public boolean onInterceptToolbarBack() {
        Log.i("关闭", "---------------------关闭");
        return super.onInterceptToolbarBack();
    }




/*自定义关闭事件*/
//    @Override
//    public boolean onInterceptToolbarBack() {
//        // Intercept close button click event.
//        Snackbar.make(mToolbar,"关闭", Snackbar.LENGTH_SHORT).show();
//        return false;
//    }


    // ========================= Menu Sample ========================= //

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Load your menu.
        inflater.inflate(R.menu.menu_fragment_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item click.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings: {
                Snackbar.make(mToolbar, R.string.setting, Snackbar.LENGTH_SHORT).show();
                break;
            }
            case R.id.action_exit: {
                Snackbar.make(mToolbar, R.string.exit, Snackbar.LENGTH_SHORT).show();
                break;
            }
        }
        return true;
    }

    // ========================= Close Button ========================= //
}
