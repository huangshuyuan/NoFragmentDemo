package com.hsy.fragment.nofragmentdemo.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hsy.fragment.nofragmentdemo.R;
import com.hsy.fragment.nofragmentdemo.bean.DataBean;

import java.util.List;

/**
 * 作者：huangshuyuan on 2017/5/19 14:08
 * 邮箱：hshuyuan@foxmail.com
 */

public class MyRecyviewAdapter extends RecyclerView.Adapter<MyRecyviewAdapter.ItemViewHolder> {
    List<DataBean.ResultsBean> data;
    Context context;

    public void setData(List<DataBean.ResultsBean> data) {
        this.data = data;
    }

    @Override
    public MyRecyviewAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null, false);
        context = parent.getContext();
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyviewAdapter.ItemViewHolder holder, int position) {

        holder.getView(R.id.tv_desc).setVisibility(View.GONE);
        holder.getView(R.id.iv_img).setVisibility(View.GONE);
        holder.getView(R.id.fl_head_date_wrap).setVisibility(View.GONE);

        if (position == 0) {
            holder.getView(R.id.fl_head_date_wrap).setVisibility(View.VISIBLE);
        } else {
            boolean isEqual = data.get(position - 1).getPublishedAt().equals(data.get(position).getPublishedAt());
            if (!isEqual) {
                holder.getView(R.id.fl_head_date_wrap).setVisibility(View.VISIBLE);
            } else {
                holder.getView(R.id.fl_head_date_wrap).setVisibility(View.GONE);
            }
        }


        if (data.get(position).getUrl().endsWith(".jpg")) {//if it's image
            holder.getView(R.id.iv_img).setVisibility(View.VISIBLE);
            ImageView imageView =(ImageView) holder.getView(R.id.iv_img);
            Glide.with(context).load(data.get(position).getUrl())// 加载图片
                    .crossFade()// 设置淡入淡出效果，默认300ms，可以传参
                    .into(imageView);

        } else {
            holder.getView(R.id.tv_desc).setVisibility(View.VISIBLE);
            holder.setText(R.id.tv_desc, data.get(position).getDesc());
        }

        holder.setText(R.id.tv_head_date, data.get(position).getPublishedAt());
        holder.setText(R.id.tv_source, data.get(position).getSource());
        holder.setText(R.id.tv_people, data.get(position).getWho());
        holder.setText(R.id.tv_time, data.get(position).getPublishedAt().substring(0, 10));
        holder.setText(R.id.tv_tag, data.get(position).getType());


    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        View itemView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public View getView(int id) {
            View img = (View) itemView.findViewById(id);
            return img;
        }

        public void setText(int id, String value) {
            TextView t = (TextView) itemView.findViewById(id);
            t.setText(value);
        }
    }
}
