package com.lv.mama.lv.kind.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lv.mama.lv.R;
import com.lv.mama.lv.kind.bean.PidUser;
import com.lv.mama.lv.kind.bean.SplbBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 武晓瑞 on 2017/11/16.
 */

public class SplbAdapter extends BaseAdapter {
    List<SplbBean.DataBean> splbdata;
    Context context;

    public SplbAdapter(List<SplbBean.DataBean> splbdata, Context context) {
        this.splbdata = splbdata;
        this.context = context;
    }

    private View view;

    @Override
    public int getCount() {
        return splbdata.size();
    }

    @Override
    public Object getItem(int i) {
        return splbdata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHondel viewHondel=null;
        if (view==null){
            view = View.inflate(context, R.layout.splb_item, null);
            viewHondel=new ViewHondel();
            viewHondel.text1=(TextView)view.findViewById(R.id.splb_text1);
            viewHondel.img=(SimpleDraweeView)view.findViewById(R.id.simpledraweeview);
            view.setTag(viewHondel);
        }else{
            viewHondel= (ViewHondel) view.getTag();
        }
        String title = splbdata.get(i).getTitle().toString();
        viewHondel.text1.setText(title);
        /*
        * 截取字符串  split
        * */
        String images = splbdata.get(i).getImages();
        String[] split = images.split("[|]");
        viewHondel.img.setImageURI(split[0]);
        String pid = splbdata.get(i).getPid();
        /*
        * 粘性事件传递pid
        * */
        EventBus.getDefault().postSticky(new PidUser(pid));

        return view;
    }
    class ViewHondel{
        TextView text1;
        SimpleDraweeView img;
    }
}

