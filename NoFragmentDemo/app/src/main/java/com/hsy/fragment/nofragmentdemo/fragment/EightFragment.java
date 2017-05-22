package com.hsy.fragment.nofragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsy.fragment.nofragmentdemo.R;
import com.yanzhenjie.fragment.NoFragment;

/**
 * 作者：huangshuyuan on 2017/5/22 09:22
 * 邮箱：hshuyuan@foxmail.com
 */

public class EightFragment extends NoFragment {
    Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;//侧边菜单视图
    private ActionBarDrawerToggle mDrawerToggle;  //菜单开关
    private NavigationView mNavigationView;//侧边菜单项
    private MenuItem mPreMenuItem;
    private TextView message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_eight, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) view.findViewById(R.id.navigation_view);
        message = (TextView) view.findViewById(R.id.message);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setToolbar(mToolbar);
        //设置标题
        setTitle(R.string.title_fragment_eghit);


        // 显示关闭按钮
        displayHomeAsUpEnabled(R.mipmap.ic_drawer_home);
        //绑定到标题栏，
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        //对头部操作
        setHead();

        setNavigationViewItemClickListener();

    }

    private void setHead() {
        View headerView = mNavigationView.getHeaderView(0);
        ImageView img = (ImageView) headerView.findViewById(R.id.profile_image);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "你点击了头像", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setNavigationViewItemClickListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (null != mPreMenuItem) {
                    mPreMenuItem.setChecked(false);
                }
                switch (item.getItemId()) {
                    case R.id.navigation_item_home:
                        mToolbar.setTitle("首页");
                        message.setText(item.getItemId() + "选中");
                        break;
                    case R.id.navigation_item_ganhuo:
                        mToolbar.setTitle("干货");
                        break;
                    case R.id.navigation_item_blog:
                        mToolbar.setTitle("我的博客");
                        break;
                    case R.id.navigation_item_custom_view:
                        mToolbar.setTitle("自定义View");
                        break;
                    case R.id.navigation_item_snackbar:
                        mToolbar.setTitle("Snackbar演示");
                        break;
                    case R.id.navigation_item_switch_theme:
                        mToolbar.setTitle("主题换肤");
                        break;
                    case R.id.navigation_item_about:
                        mToolbar.setTitle("关于");
                        break;
                    default:
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                mPreMenuItem = item;
                return false;
            }
        });
    }

}
