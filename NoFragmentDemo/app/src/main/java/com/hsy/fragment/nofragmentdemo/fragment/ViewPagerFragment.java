package com.hsy.fragment.nofragmentdemo.fragment;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hsy.fragment.nofragmentdemo.R;
import com.hsy.fragment.nofragmentdemo.adpter.MyRecyviewAdapter;
import com.hsy.fragment.nofragmentdemo.bean.DataBean;
import com.hsy.fragment.nofragmentdemo.config.API;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;

/**
 * 作者：huangshuyuan on 2017/5/19 13:26
 * 邮箱：hshuyuan@foxmail.com
 */

public class ViewPagerFragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_viewpager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    }

    MyRecyviewAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String mType = getArguments().getString("type");
        String strUTF8 = mType;
        String strGBK = mType;
        try {

            strUTF8 = URLDecoder.decode(mType, "UTF-8");//转码
            System.out.println(strUTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = API.GanHuoURL + "/" + strUTF8 + "/10/" + 1;//第一页10条数据
        Log.i("url2", url);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyRecyviewAdapter();
        recyclerView.addItemDecoration(new SpacesItemDecoration(8));
        recyclerView.setAdapter(adapter);

        // 初始化请求队列，传入的参数是请求并发值。
        mQueue = NoHttp.newRequestQueue();
        getUrlData(url);

    }
//
//    public static String realUrl(String target) {
//        try {
//            URL url = new URL(target);
//
//            String protocol = url.getProtocol();
//            String host = url.getHost();
//            String path = url.getPath();
//            String query = url.getQuery();
//
//            path = URLEncoder.encode(path, "GBk")
//                    .replace("%3A", ":")
//                    .replace("%2B", "+")
//                    .replace("%2C", ",")
//                    .replace("%5E", "^")
//                    .replace("%2F", "/")
//                    .replace("%21", "!")
//                    .replace("%24", "$")
//                    .replace("%25", "%")
//                    .replace("%26", "&")
//                    .replace("%28", "(")
//                    .replace("%29", ")")
//                    .replace("%40", "@")
//                    .replace("%60", "`");
//            // .replace("", "#"); // not support.
//
//            StringBuilder urlBuild = new StringBuilder(protocol)
//                    .append("://")
//                    .append(host)
//                    .append(path);
//            if (query != null)
//                urlBuild.append("?").append(query);
//            return urlBuild.toString();
//        } catch (IOException e) {
//            return target;
//        }
//    }

    /**
     * 请求队列。
     */
    private RequestQueue mQueue;
    private static final int NOHTTP_WHAT_TEST = 0x001;

    public void getUrlData(String url) {
        // 创建请求对象。
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        mQueue.add(NOHTTP_WHAT_TEST, request, onResponseListener);
    }

    /**
     * 回调对象，接受请求结果.
     */
    private OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            String result = response.get();
            Gson gson = new Gson();
            DataBean dataBean = gson.fromJson(result, DataBean.class);
            List<DataBean.ResultsBean> d = dataBean.getResults();
            adapter.setData(d);
            adapter.notifyDataSetChanged();

//            String who = dataBean.getResults().get(0).getWho();
//            Toast.makeText(getActivity(), dataBean.toString(), Toast.LENGTH_SHORT).show();
            Log.i("d", dataBean.getResults().toString());

        }

        @Override
        public void onFailed(int what, Response<String> response) {

        }

        @Override
        public void onFinish(int what) {

        }
    };
}
