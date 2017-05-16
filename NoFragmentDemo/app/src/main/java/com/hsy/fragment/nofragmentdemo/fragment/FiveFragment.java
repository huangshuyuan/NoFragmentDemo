package com.hsy.fragment.nofragmentdemo.fragment;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
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
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hsy.fragment.nofragmentdemo.R;
import com.hsy.fragment.nofragmentdemo.adpter.MyMainItemAdaper;
import com.hsy.fragment.nofragmentdemo.utils.AppBarStateChangeListener;
import com.hsy.fragment.nofragmentdemo.utils.DisplayUtils;
import com.yanzhenjie.fragment.NoFragment;

import java.lang.reflect.Field;

/**
 * 作者：huangshuyuan on 2017/5/15 15:07
 * 邮箱：hshuyuan@foxmail.com
 */

public class FiveFragment extends NoFragment {
    Toolbar toolbar;
    RecyclerView recyclerView;

    AppBarLayout mAppBarLayout;//标题部分
    private int headViewSize;
    ImageView headImage;
    CollapsingToolbarLayout mCollapsingToolbarLayout;//折叠式标题栏

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_five, container, false);
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.appbar_layout);
        headImage = (ImageView) view.findViewById(R.id.headImage);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);

        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
                Log.d("STATE", state.name());
                if( state == State.EXPANDED ) {

                    //展开状态
                    Toast.makeText(getActivity(),"展开",Toast.LENGTH_SHORT).show();

                }else if(state == State.COLLAPSED){

                    //折叠状态
                    Toast.makeText(getActivity(),"折叠状态",Toast.LENGTH_SHORT).show();
                }else {

                    //中间状态
//                    Toast.makeText(getActivity(),"中间状态",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(toolbar);
        //初始化
        DisplayUtils.initScreen(getActivity());
        //设置标题
        setTitle(R.string.title_fragment_five);

        // 显示关闭按钮
        displayHomeAsUpEnabled(R.mipmap.ic_back_white);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0之上使用
            //沉浸式状态栏
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        mCollapsingToolbarLayout.setTitle(getContext().getText(R.string.title_fragment_five));
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色

        initRecyle();
    }

    /**
     * AppBarLayout的offset监听。
     */
    private AppBarLayout.OnOffsetChangedListener offsetChangedListener = new AppBarLayout.OnOffsetChangedListener() {
        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            int maxScroll = appBarLayout.getTotalScrollRange();
            float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
            headImage.setAlpha(percentage);

            int background = (int) (250 * percentage);
            toolbar.getBackground().mutate().setAlpha(background);

            int realSize = (int) (headViewSize * percentage);
            toolbar.setTranslationX(realSize);
        }
    };


    private void initRecyle() {
        String[] itemArr = new String[100];
        for (int i = 0; i < 30; i++) {
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
