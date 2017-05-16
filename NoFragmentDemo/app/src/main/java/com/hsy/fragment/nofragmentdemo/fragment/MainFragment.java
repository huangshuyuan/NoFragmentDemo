package com.hsy.fragment.nofragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsy.fragment.nofragmentdemo.R;
import com.hsy.fragment.nofragmentdemo.adpter.MyMainItemAdaper;
import com.yanzhenjie.fragment.NoFragment;

/**
 * 作者：huangshuyuan on 2017/5/12 14:46
 * 邮箱：hshuyuan@foxmail.com
 */

public class MainFragment extends BaseFragment {
    /**/
//    private Toolbar mToolbar;
    private RecyclerView recyclerView;
    private String[] itemArr = {"启动新的Fragment", "溢出菜单+响应式布局", "回传数据", "不在回退栈", "折叠式标题栏", "自动播放ViewPager"};

    /**
     * 绑定界面
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    /**
     * 绑定组件
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

    }

    /**
     * 主要Activity操作
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // First must set toolbar, will invoke: onCreateOptionsMenu();
//        setToolbar(mToolbar);

        //设置标题
        setTitle(R.string.title_fragment_main);


        // 显示关闭按钮
        displayHomeAsUpEnabled(R.mipmap.ic_close_white);
        initRecyclerview();
    }

    /*初始化*/
    private void initRecyclerview() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyMainItemAdaper adpter = new MyMainItemAdaper(getActivity(), itemArr);
        recyclerView.setAdapter(adpter);
        adpter.setOnItemClickListener(new MyMainItemAdaper.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("点击", position + "");
                switch (position) {
                    case 0:
                        //启动一个新的Fragment
                        startFragment(FirstFragment.class);
                        break;
                    case 1:
                        //溢出菜单
                        startFragment(SecondFragment.class);

                        break;
                    case 2:
                        // 封装参数：
                        Bundle bundle = new Bundle();
                        bundle.putString("hehe", "呵呵哒");
                        bundle.putString("meng", "萌萌哒");
                        bundle.putString("bang", "棒棒哒");
                        bundle.putString("meme", "么么哒");

                        // 在Activity中或者Fragment调用此方法：
                        NoFragment fragment = fragment(ThreeFragment.class, bundle);

                        startFragment(fragment);
                        break;
                    case 3:
                        // 封装参数：
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("hehe", "等会我不在了");
                        bundle2.putString("meng", "");
                        bundle2.putString("bang", " ");
                        bundle2.putString("meme", " ");

                        // 在Activity中或者Fragment调用此方法：
                        NoFragment fragment2 = fragment(ThreeFragment.class, bundle2);

                        startFragment(fragment2, false);
                        break;
                    case 4:
                        startFragment(FiveFragment.class);
                        break;
                    case 5:
                        startFragment(SixFragment.class);
                        break;
                }
            }
        });

    }
}
