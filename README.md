# NoFragmentDemo
Activity + 多个Fragment的形式
# Demo中包括：

* NoFragment的使用
* Design-CollapsingToobarLayout、ToolBar使用（沉浸式标题栏）5.0+
* 自动滚动的ViewPager的使用（自定义、沉浸式样式）5.0+
* TableLayout使用

***
代码开源在Github：[https://github.com/yanzhenjie/NoFragment](https://github.com/yanzhenjie/NoFragment)

Demo：https://github.com/huangshuyuan/NoFragmentDemo/tree/master

我的简书：http://www.jianshu.com/p/0df959c0a7f5

![](http://upload-images.jianshu.io/upload_images/3805053-fc8561c781d93100.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![tablelayout ](http://upload-images.jianshu.io/upload_images/3805053-e0a133c647439b88.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![ 2](http://upload-images.jianshu.io/upload_images/3805053-6fb4a288dda931c0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
***
#  NoFragment 特点

支持传统Fragment的所有用法。
支持startFragmentForResult(Fragment)、onFragmentResult(int, int, Bundle)，原生只有Activity。
支持同一个Fragment启动多个实例。
支持自动维护Back Stack，不会错乱。
支持在Fragment中直接setToolbar()、setTitle()、displayHomeButton()。
返回键和homeButton自动处理，支持开发者拦截处理。
支持ActionBar Menu、溢出Menu等。
当然最基本的是一个Activity + 多个Fragment。


# 使用方法

Gradle一句话远程依赖
```
compile 'com.yanzhenjie:fragment:1.0.1'
```

### 主Activity需要继承CompatActivity，然后启动一个Fragment：
```
public class MainActivity extends CompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * 一句话即可，不要怀疑自己的眼睛，这是真的。
         */
        startFragment(MainFragment.class);
    }

    @Override
    protected int fragmentLayoutId() {
        return R.id.fragment_root;
    }

}
```

### 一、以standard模式启动一个Fragment
```
startFragment(MoreMenuFragment.class);
```
### 二、以startActivityForResult()方式启动一个Fragment
```
// 启动，等待回调结果。
startFragmentForResult(StartResultFragment.class, 100);

// 不论怎样回来都会回调onFragmentResult()。
@Override
public void onFragmentResult(int requestCode, int resultCode, @Nullable Bundle result) {
    switch (requestCode) {
        case 100: {
            if (resultCode == RESULT_OK) {
                // 操作成功：result就是调用的Fragment返回的结果。
            } else if (resultCode == RESULT_CANCELED) {
                // 操作取消。
            }
            break;
        }
    }
}
```
在StartResultFragment中如果要返回结果，那么：
```
Bundle bundle = new Bundle();
bundle.putString("message", result);
setResult(RESULT_OK, bundle);
finish();
```
当然你也不设置，那么resultCode的默认值是RESULT_CANCELED。
### 三、跳转时带参数
```
// 封装参数：
Bundle bundle = new Bundle();
bundle.putString("hehe", "呵呵哒");
bundle.putString("meng", "萌萌哒");
bundle.putString("bang", "棒棒哒");
bundle.putString("meme", "么么哒");

// 在Activity中或者Fragment调用此方法：  
NoFragment fragment = fragment(ArgumentFragment.class, bundle);

// 最后启动：
startFragment(fragment);
```

### 四、跳转的Fragment不保存在Back Stack

这种方式显示的fragment中如果调用了其它fragment，从其它fragment中回来时，这个fragment将会跳过，不会显示，也就是说：A-B-C-[back]-A，从A到B，B不加入回退栈，B再到C，C按下返回键，或者调用finish()方法，将会直接回到A。
```
startFragment(StackFragment.class, false);
```
### 五、同一个Fragment，启动多个实例
```
startFragment(MoreMenuFragment.class);
startFragment(MoreMenuFragment.class);
startFragment(MoreMenuFragment.class);
startFragment(MoreMenuFragment.class);
```
比如我们这里调用四次，那么回退栈中有四个MoreMenuFragment
，按下返回键时将一个个退出。

### 六、Toolbar菜单的加载和处理

我们知道MD设计中，Toolbar的菜单很好看，而且利用Toolbar也很好加载，那么NoFragment也是完美支持的，当重写了onCreateOptionsMenu()方法后，调用setToolbar(Toolbar)方法时，将会调用onCreateOptionsMenu()方法，此时你就该加载菜单了，当然也只需要一句话。
```
@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    // Load your menu.
    inflater.inflate(R.menu.menu_fragment_main, menu);
}
```
当用户点击meun的item时将会回调这个方法，和原生Activity是一样的。
```
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle menu item click.
    int id = item.getItemId();
    switch (id) {
        case R.id.action_settings: {
            Snackbar.make(mToolbar, R.string.action_settings, Snackbar.LENGTH_SHORT).show();
            break;
        }
        case R.id.action_exit: {
            Snackbar.make(mToolbar, R.string.action_exit, Snackbar.LENGTH_SHORT).show();
            break;
        }
    }
    return true;
}
```

### 七、Toolbar的返回按钮的处理
在正常开发中给Toolbar设置返回按钮也要好几行代码的，如果使用了NoFragment，那么：
```
@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    // 首先设置Toolbar：
    setToolbar(mToolbar);

    // 设置标题：
    setTitle(R.string.title_fragment_main);

    // 显示返回按钮，图标开发者指定：
    displayHomeAsUpEnabled(R.drawable.ic_close_white);
}
```

设置了返回按钮后，用户点击返回按钮将自动杀死当前Fragment，当然你也可以拦截用户的返回行为：
```
@Override
    public boolean onInterceptToolbarBack() {
        // 返回true将拦截，返回false将不拦截。
        return true;
    }
```

### 八、Toolbar的标题自定义
xml
```
<android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?actionBarSize"
            android:background="?attr/colorPrimary"
            android:gravity="center_horizontal"
            app:layout_scrollFlags="scroll|enterAlways|snap"
            app:popupTheme="@style/AppTheme.PopupOverlay">
            <!--自定义标题位置-->
            <TextView
                android:id="@+id/toolbar_title"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:textColor="#ffffff"
                android:textSize="20sp" />
 </android.support.v7.widget.Toolbar>
```
BaseFargment中，extends NoFragment 
```
 /**
     * @param resId 资源文件
     */
    @Override
    public void setTitle(@StringRes int resId) {
        TextView titleTV = (TextView) getView().findViewById(R.id.toolbar_title);
        titleTV.setText(getContext().getText(resId));
    }
```
### 九、Toolbar跟随RecylerView滚动设置
需要在xml中设置app:layout_behavior、 app:layout_scrollFlags 
注意一点： 需要嵌套在CoordinatorLayout中
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true">


    <android.support.design.widget.AppBarLayout
        android:id="@+id/appbar_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/AppTheme.AppBarOverlay">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?actionBarSize"
            android:background="?attr/colorPrimary"
            app:layout_scrollFlags="scroll|enterAlways|snap"
            app:popupTheme="@style/AppTheme.PopupOverlay" />
        <!--标题跟随滚动 1.toolbar  app:layout_scrollFlags="scroll|enterAlways|snap"
               下方：app:layout_behavior="@string/appbar_scrolling_view_behavior"-->
    </android.support.design.widget.AppBarLayout>


    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"

 app:layout_behavior="@string/appbar_scrolling_view_behavior"

> </android.support.v7.widget.RecyclerView>

  <!--标题跟随滚动 1.toolbar  app:layout_scrollFlags="scroll|enterAlways|snap"
               下方：app:layout_behavior="@string/appbar_scrolling_view_behavior"-->
</android.support.design.widget.CoordinatorLayout>
```


### 混淆
```
-keep public class * extends android.support.v4.app.Fragment
```
