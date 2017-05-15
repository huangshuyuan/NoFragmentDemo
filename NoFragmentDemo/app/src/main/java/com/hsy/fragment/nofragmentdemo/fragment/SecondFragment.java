package com.hsy.fragment.nofragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.hsy.fragment.nofragmentdemo.R;
import com.hsy.fragment.nofragmentdemo.adpter.MyMainItemAdaper;
import com.yanzhenjie.fragment.NoFragment;

/**
 * 作者：huangshuyuan on 2017/5/12 17:48
 * 邮箱：hshuyuan@foxmail.com
 */

public class SecondFragment extends NoFragment {
    Toolbar toolbar;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(toolbar);

        //设置标题
        setTitle(R.string.title_fragment_second);

        // 显示关闭按钮
        displayHomeAsUpEnabled(R.mipmap.ic_back_white);

        initRecyle();
    }

    private void initRecyle() {
        String[] itemArr = new String[100];
        for (int i = 0; i < 100; i++) {
            itemArr[i] = "第" + i + "行数据";
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyMainItemAdaper adpter = new MyMainItemAdaper(getActivity(), itemArr);
        recyclerView.setAdapter(adpter);
        adpter.setOnItemClickListener(new MyMainItemAdaper.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("点击", position + "");

            }
        });
    }


    // ========================= Menu Sample ========================= //

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Load your menu.
        inflater.inflate(R.menu.menu_fragment_second, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item click.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings: {
                Snackbar.make(toolbar, R.string.setting, Snackbar.LENGTH_SHORT).show();
                break;
            }
            case R.id.action_exit: {
                Snackbar.make(toolbar, R.string.exit, Snackbar.LENGTH_SHORT).show();
                break;

            }
            default:
                Snackbar.make(toolbar, id + "....", Snackbar.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    // ========================= Close Button ========================= //
}
