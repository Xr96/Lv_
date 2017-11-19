package com.lv.mama.lv.cart.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lv.mama.lv.R;
import com.lv.mama.lv.cart.bean.CartBean;
import com.lv.mama.lv.cart.bean.ShowCartBean;

import java.util.ArrayList;

/**
 * Created by 武晓瑞 on 2017/11/18.
 */

public class ExpendAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<ShowCartBean> dataBeans;
    private CartListener mCartListener;
    public void setCartListener(CartListener mCartListener){
        this.mCartListener = mCartListener;
    }

    public ExpendAdapter(Context context, ArrayList<ShowCartBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @Override
    public int getGroupCount() {
        return dataBeans.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return dataBeans.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return dataBeans.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return dataBeans.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        Gholder gholder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.cart_shop_item,viewGroup,false);
            gholder = new Gholder();
            gholder.checkBox = view.findViewById(R.id.cart_shop_check);
            view.setTag(gholder);
        }else{
            gholder = (Gholder) view.getTag();
        }
        ShowCartBean group = (ShowCartBean) getGroup(i);
        gholder.checkBox.setTextColor(Color.BLACK);
        gholder.checkBox.setText(group.getSellerName());
        gholder.checkBox.setChecked(group.getSelected() == 1);

        if (mCartListener != null){
            gholder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCartListener.onGroupClick(i);
                }
            });
        }
        return view;
    }

    @Override
    public View getChildView(final int i,final int i1, boolean b, View view, ViewGroup viewGroup) {
        Cholder cholder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.cart_good_item,viewGroup,false);
            cholder = new Cholder();
            cholder.checkBox = view.findViewById(R.id.cart_good_check);
            cholder.imageView = view.findViewById(R.id.cart_good_img);
            cholder.title = view.findViewById(R.id.cart_good_title);
            cholder.subhead = view.findViewById(R.id.cart_good_subhead);
            cholder.moneyNow = view.findViewById(R.id.cart_good_item_money_now);
            cholder.moneyOld = view .findViewById(R.id.cart_good_item_money_old);
            cholder.num = view.findViewById(R.id.cart_good_item_num);

            //点击去编辑的按钮
            cholder.editor = view.findViewById(R.id.cart_good_item_editor);

            //第二种布局中的内容
            cholder.jia = view.findViewById(R.id.cart_good_item_jia);
            cholder.jian = view.findViewById(R.id.cart_good_item_jian);
            cholder.numEditoring = view.findViewById(R.id.cart_good_item_num_editoring);
            cholder.finish = view.findViewById(R.id.cart_good_item_finish);

            //两种形式的布局
            cholder.normal = view.findViewById(R.id.cart_good_item_layout_normal);
            cholder.editoring  = view.findViewById(R.id.cart_good_item_layout_editor);
            view.setTag(cholder);
        }else{
            cholder = (Cholder) view.getTag();
        }
        CartBean.DataBean.GoodBean goodBean = (CartBean.DataBean.GoodBean) getChild(i,i1);

        cholder.normal.setVisibility(goodBean.isEditor()?View.GONE:View.VISIBLE);
        cholder.editoring.setVisibility(!goodBean.isEditor()?View.GONE:View.VISIBLE);

        cholder.checkBox.setChecked(goodBean.getSelected() == 1);
        Glide.with(context).load(goodBean.getImages().split("\\|")[0]).into(cholder.imageView);
        cholder.title.setText(goodBean.getTitle());
        cholder.subhead.setText(goodBean.getSubhead());
        cholder.moneyNow.setText("￥"+goodBean.getBargainPrice());
        cholder.moneyOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线（删除线）
        cholder.moneyOld.setText("￥"+goodBean.getPrice());
        cholder.num.setText("数量:" + goodBean.getNum());
        cholder.numEditoring.setText("数量:" + goodBean.getNum());

        if (mCartListener != null){
            cholder.editor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCartListener.changeEditor(true,i,i1);
                }
            });
            cholder.finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCartListener.changeEditor(false,i,i1);
                }
            });
            cholder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCartListener.onChildClick(i,i1);
                }
            });
            cholder.jia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCartListener.onAddClick(i,i1);
                }
            });
            cholder.jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCartListener.onMinus(i,i1);
                }
            });
        }
        return view;
    }

    class Gholder{
        CheckBox checkBox;
    }
    class Cholder{
        CheckBox checkBox;
        ImageView imageView;
        TextView title,subhead,moneyNow,moneyOld,num;
        Button editor,finish;

        LinearLayout normal,editoring;

        TextView jia,jian,numEditoring;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
