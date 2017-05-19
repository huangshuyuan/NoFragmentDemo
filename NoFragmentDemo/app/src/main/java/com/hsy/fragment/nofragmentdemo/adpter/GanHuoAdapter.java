package com.hsy.fragment.nofragmentdemo.adpter;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.hsy.fragment.nofragmentdemo.fragment.ViewPagerFragment;

/**
 * 作者：huangshuyuan on 2017/5/19 13:19
 * 邮箱：hshuyuan@foxmail.com
 */

public class GanHuoAdapter extends FragmentStatePagerAdapter {
    FragmentManager childFragmentManager;
    String[] mTitles;


    public GanHuoAdapter(FragmentManager fm, String[] mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }


    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", mTitles[position]);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        // super.restoreState(state, loader);
        //重写这个方法是为了防止在restoreState的时候导致应用崩溃，这样做虽然不太好，但是目前我也只能想到这种方法了
    }
}
