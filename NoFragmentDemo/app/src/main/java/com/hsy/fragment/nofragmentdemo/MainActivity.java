package com.hsy.fragment.nofragmentdemo;

import android.os.Bundle;

import com.hsy.fragment.nofragmentdemo.fragment.MainFragment;
import com.yanzhenjie.fragment.CompatActivity;

public class MainActivity extends CompatActivity {
    /**
     * 绑定ID
     */
    @Override
    protected int fragmentLayoutId() {
        return R.id.mainFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /*
         * 继承CompatActivity后，显示一个fragment就这么简单，不要怀疑自己的眼睛，这是真的。
         */
        startFragment(MainFragment.class);
    }
}
