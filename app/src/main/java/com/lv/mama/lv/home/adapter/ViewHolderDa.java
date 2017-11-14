package com.lv.mama.lv.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lv.mama.lv.R;
import com.lv.mama.lv.home.bean.HomeBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;



/**
 * Created by 武晓瑞 on 2017/10/24.
 */

public class ViewHolderDa extends RecyclerView.Adapter<ViewHolderDa.MyViewHolder> {
    List<HomeBean.DataBean.SubjectsBean.GoodsListBeanX> lists;
    Context mc;

    public ViewHolderDa(List<HomeBean.DataBean.SubjectsBean.GoodsListBeanX> lists, Context mc) {
        this.lists = lists;
        this.mc = mc;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolderDa.MyViewHolder holder = new ViewHolderDa.MyViewHolder(LayoutInflater.from(mc).inflate(R.layout.item_home_c, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(lists.get(position).getGoods_name());
        ImageLoader instance = ImageLoader.getInstance();
        instance.displayImage(lists.get(position).getGoods_img(),holder.img);
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
            tv = (TextView) view.findViewById(R.id.text_c1);
            img = (ImageView) view.findViewById(R.id.img_c1);
        }
    }
}
