package com.lv.mama.lv.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lv.mama.lv.ClistActivity;
import com.lv.mama.lv.R;
import com.lv.mama.lv.home.bean.HomeBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;



/**
 * Created by 武晓瑞 on 2017/10/24.
 */

public class ViewHolderEa extends RecyclerView.Adapter<ViewHolderEa.MyViewHolder> {
    List<HomeBean.DataBean.DefaultGoodsListBean> lists;
    Context mc;

    public ViewHolderEa(List<HomeBean.DataBean.DefaultGoodsListBean> lists, Context mc) {
        this.lists = lists;
        this.mc = mc;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolderEa.MyViewHolder holder = new ViewHolderEa.MyViewHolder(LayoutInflater.from(mc).inflate(R.layout.item_home_d, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(lists.get(position).getGoods_name());
        ImageLoader instance = ImageLoader.getInstance();
        instance.displayImage(lists.get(position).getGoods_img(),holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mc, ClistActivity.class);
                mc.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.text_d1);
            img = (ImageView) view.findViewById(R.id.img_d1);
        }
    }
}
