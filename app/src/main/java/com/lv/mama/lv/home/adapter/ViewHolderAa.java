package com.lv.mama.lv.home.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lv.mama.lv.ClistActivity;
import com.lv.mama.lv.R;
import com.lv.mama.lv.home.bean.HomeBean;

import java.util.List;


/**
 * Created by 武晓瑞 on 2017/10/24.
 */

public class ViewHolderAa extends RecyclerView.Adapter<ViewHolderAa.MyViewHolder> {
    List<HomeBean.DataBean.Ad5Bean> lists;
    Context mc;

    public ViewHolderAa(List<HomeBean.DataBean.Ad5Bean> lists, Context mc) {
        this.lists = lists;
        this.mc = mc;
    }

    @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mc).inflate(R.layout.item_home, parent, false));
            return holder;
        }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(lists.get(position).getTitle());
        Uri uri = Uri.parse(lists.get(position).getImage());
        holder.img.setImageURI(uri);
        /*ImageLoader instance = ImageLoader.getInstance();
        instance.displayImage(lists.get(position).getImage(),holder.img);*/
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
            SimpleDraweeView img;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.text_s1);
                img = (SimpleDraweeView) view.findViewById(R.id.img_s1);
            }
        }
    }
