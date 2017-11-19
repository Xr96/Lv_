package com.lv.mama.lv.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.lv.mama.lv.R;
import com.lv.mama.lv.base.BaseFragment;
import com.lv.mama.lv.cart.adapter.CartListener;
import com.lv.mama.lv.cart.adapter.ExpendAdapter;
import com.lv.mama.lv.cart.bean.CartBean;
import com.lv.mama.lv.cart.bean.DeleteBean;
import com.lv.mama.lv.cart.bean.ShowCartBean;
import com.lv.mama.lv.cart.bean.UpdateBean;
import com.lv.mama.lv.cart.presenter.MyPresenter;
import com.lv.mama.lv.cart.view.ImyView;
import com.lv.mama.lv.client.MyApp;
import com.lv.mama.lv.utils.SharedPreferencesUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class Fragment3 extends BaseFragment implements ImyView,CartListener {
    View view;
    @BindView(R.id.cart_expandable_view)
    ExpandableListView cartExpandableView;
    @BindView(R.id.cart_check_all)
    CheckBox cartCheckAll;
    @BindView(R.id.cart_view_flipper)
    ViewFlipper cartViewFlipper;
    @BindView(R.id.cart_button_delete)
    Button cartButtonDelete;
    @BindView(R.id.cart_button_buy)
    Button cartButtonBuy;
    Unbinder unbinder;
    int uid;
    @BindView(R.id.cart_text_all)
    TextView cartTextAll;
    private MyPresenter presenter;
    private ArrayList<ShowCartBean> shopBeans;
    View v1;
    View v2;
    View v3;
    TextView t1, t2, t3;
    private ExpendAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra3, null, false);
        unbinder = ButterKnife.bind(this, view);
        presenter=new MyPresenter(this);
        uid = (int) SharedPreferencesUtils.getParam(getActivity(), "uid", 666);
        Toast.makeText(getActivity(), "uid :" + uid, Toast.LENGTH_SHORT).show();
        v1 = View.inflate(getActivity(), R.layout.fileter_one, null);
        v2 = View.inflate(getActivity(), R.layout.fileter_two, null);
        v3 = View.inflate(getActivity(), R.layout.fileter_three, null);
        t1 = v1.findViewById(R.id.fileter_one_text);
        t2 = v2.findViewById(R.id.fileter_two_text);
        t3 = v3.findViewById(R.id.fileter_three_text);
        cartViewFlipper.addView(v1);
        cartViewFlipper.addView(v2);
        cartViewFlipper.addView(v3);
        return view;
    }

    @Override
    public void initData() {
        shopBeans=new ArrayList<>();
    }
    @OnClick({R.id.cart_check_all, R.id.cart_view_flipper, R.id.cart_button_delete, R.id.cart_button_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cart_check_all:
                break;
            case R.id.cart_view_flipper:
                break;
            case R.id.cart_button_delete:
                break;
            case R.id.cart_button_buy:
                break;
        }
    }

    @Override
    public void changeEditor(boolean isEditor, int groupId, int childId) {
        shopBeans.get(groupId).getList().get(childId).setEditor(isEditor);
        adapter.notifyDataSetChanged();
        if (!isEditor){
            int sellerid = Integer.parseInt(shopBeans.get(groupId).getSellerid());
            int pid = shopBeans.get(groupId).getList().get(childId).getPid();
            int num = shopBeans.get(groupId).getList().get(childId).getNum();
            int select = 0;
            presenter.updateCarts(uid,sellerid,pid,num,select);
        }
    }

    @Override
    public void onGroupClick(int groupId) {
        int select = shopBeans.get(groupId).getSelected();
        if (select == 0) {
            shopBeans.get(groupId).setSelected(1);
        } else {
            shopBeans.get(groupId).setSelected(0);
        }
        for (int i = 0; i < shopBeans.get(groupId).getList().size(); i++) {
            shopBeans.get(groupId).getList().get(i).setSelected(shopBeans.get(groupId).getSelected());
        }
        notifyCheckAll();
    }

    @Override
    public void onChildClick(int groupId, int childId) {
        int select = shopBeans.get(groupId).getList().get(childId).getSelected();
        if (select == 0) {
            shopBeans.get(groupId).getList().get(childId).setSelected(1);
        } else {
            shopBeans.get(groupId).getList().get(childId).setSelected(0);
        }
        int flag = 0;
        for (int i = 0; i < shopBeans.get(groupId).getList().size(); i++) {
            if (shopBeans.get(groupId).getList().get(i).getSelected() == 1) {
                flag++;
            }
        }
        if (flag == shopBeans.get(groupId).getList().size()) {
            shopBeans.get(groupId).setSelected(1);
        } else {
            shopBeans.get(groupId).setSelected(0);
        }
        notifyCheckAll();
    }

    @Override
    public void onAddClick(int groupId, int childId) {
        int num = shopBeans.get(groupId).getList().get(childId).getNum();
        shopBeans.get(groupId).getList().get(childId).setNum(++num);
        adapter.notifyDataSetChanged();
        notifyAllMoney();
    }

    @Override
    public void onMinus(int groupId, int childId) {
        int num = shopBeans.get(groupId).getList().get(childId).getNum();
        if (num == 1){
            Toast.makeText(getActivity(), "受不了了主人，不能再少了", Toast.LENGTH_SHORT).show();
        }else{
            shopBeans.get(groupId).getList().get(childId).setNum(--num);
        }
        adapter.notifyDataSetChanged();
        notifyAllMoney();
    }
    public void notifyCheckAll() {
        int flag = 0;
        for (int i = 0; i < shopBeans.size(); i++) {
            if (shopBeans.get(i).getSelected() == 1) {
                flag++;
            }
        }
        if (flag == shopBeans.size()) {
            cartCheckAll.setChecked(true);
        } else {
            cartCheckAll.setChecked(false);
        }
        adapter.notifyDataSetChanged();
        notifyAllMoney();
    }
    public void notifyAllMoney() {
        float money = 0;
        for (int i = 0; i < shopBeans.size(); i++) {
            for (int j = 0; j < shopBeans.get(i).getList().size(); j++) {
                if (shopBeans.get(i).getList().get(j).getSelected() == 1) {
                    money += shopBeans.get(i).getList().get(j).getNum() * shopBeans.get(i).getList().get(j).getBargainPrice();
                }
            }
        }
        cartTextAll.setText("￥"+money);
    }

    @Override
    public void onDataOver(CartBean cartBean) {
       // Toast.makeText(getActivity(), "数据:" + cartBean.getData().get(0).getList().get(0).getTitle(), Toast.LENGTH_SHORT).show();
        ArrayList<CartBean.DataBean> data = (ArrayList<CartBean.DataBean>) cartBean.getData();
        data.remove(0);
        shopBeans.clear();
        for (int i=0;i<data.size();i++){
            shopBeans.add(new ShowCartBean(data.get(i).getSellerName(),data.get(i).getSellerid(),0,data.get(i).getList()));
           /* switch (i){
                case 0:
                    t1.setText(data.get(i).getList().get(i).getTitle());
                    break;
                case 1:
                    t2.setText(data.get(i).getList().get(i).getTitle());
                    break;
                case 2:
                    t3.setText(data.get(i).getList().get(i).getTitle());
                    break;
            }*/
        }
        for (int i=0;i<shopBeans.size();i++){
            for (int j=0;j<shopBeans.get(i).getList().size();j++){
                shopBeans.get(i).getList().get(j).setEditor(false);
            }
        }
        adapter=new ExpendAdapter(MyApp.context,shopBeans);
        adapter.setCartListener(this);
        cartExpandableView.setAdapter(adapter);
        cartViewFlipper.startFlipping();
        for (int i=0;i<adapter.getGroupCount();i++){
            cartExpandableView.expandGroup(i);
        }
        cartCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ischeck=cartCheckAll.isChecked();
                for (int i=0;i<shopBeans.size();i++){
                    shopBeans.get(i).setSelected(ischeck?1:0);
                    for (int j=0;j<shopBeans.get(i).getList().size();j++){
                        shopBeans.get(i).getList().get(j).setSelected(ischeck?1:0);
                    }
                }
                //刷新适配器
                adapter.notifyDataSetChanged();
                notifyAllMoney();
            }
        });
        cartButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //子数据
                ArrayList<ArrayList<CartBean.DataBean.GoodBean>> willDelAll=new ArrayList<ArrayList<CartBean.DataBean.GoodBean>>();
                //根据名字  id 框选
                ArrayList<ShowCartBean> willDelGroup=new ArrayList<ShowCartBean>();
                for (int i=0;i<shopBeans.size();i++){
                    ArrayList<CartBean.DataBean.GoodBean> willDel=new ArrayList<CartBean.DataBean.GoodBean>();
                    for (int j=0;j<shopBeans.get(i).getList().size();j++){
                        if (shopBeans.get(i).getList().get(j).getSelected()==1){
                            willDel.add(shopBeans.get(i).getList().get(j));
                        }
                    }
                    if (willDel.size()==shopBeans.get(i).getList().size()){
                        willDelGroup.add(shopBeans.get(i));
                    }
                    shopBeans.get(i).getList().removeAll(willDel);
                    willDelAll.add(willDel);
                }
                shopBeans.removeAll(willDelGroup);
                adapter.notifyDataSetChanged();

                for (int i=0;i<willDelAll.size();i++){
                    for (int j=0;j<willDelAll.get(i).size();j++){
                        CartBean.DataBean.GoodBean goodBean=willDelAll.get(i).get(j);
                        int pid = goodBean.getPid();
                        presenter.delete(uid,pid);
                    }
                }
            }
        });
    }

    @Override
    public void onUpdateOver(UpdateBean updateBean) {
        Log.d("mylog", "onUpdateOver:更新服务器数据 " + updateBean.getMsg());
    }

    @Override
    public void onDeleteOver(DeleteBean deleteBean) {
        Log.d("mylog", "onUpdateOver:删除数据 " + deleteBean.getMsg());
    }
    @Override
    public void onResume() {
        super.onResume();
        if (uid > 0) {
            presenter.getDatas(uid);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
