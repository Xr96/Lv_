package com.lv.mama.lv.kind.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.lv.mama.lv.R;
import com.lv.mama.lv.kind.bean.RightBean;

import java.util.List;

/**
 * Created by admin on 2017/11/14.
 */

public class GridAdapter extends BaseAdapter{
    List<RightBean.DataBean.ListBean> data;
    Context context;
    private String name;

    public GridAdapter(List<RightBean.DataBean.ListBean> data, Context context) {
        this.data = data;
        this.context = context;
    }
    /*
    * item 点击事件接口
    * */
    public interface Itemclick{
        void onItimclicks(int positions,View view);
    }
    private Itemclick itemclick;

    public void setItemclick(Itemclick itemclick) {
        this.itemclick = itemclick;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.type_grid_item,null);
            holder.button= (Button) convertView.findViewById(R.id.tv_gv_type);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        name = data.get(position).getName();
        holder.button.setText(name);
        if (itemclick!=null){
            final ViewHolder finalHolder = holder;
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pscid = data.get(position).getPscid();
                    itemclick.onItimclicks(position, finalHolder.button);
                }
            });
        }
        return convertView;
    }
    class ViewHolder{
        private Button button;
    }
}
