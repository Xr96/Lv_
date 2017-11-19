package com.lv.mama.lv.kind;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lv.mama.lv.R;
import com.lv.mama.lv.kind.adapter.LeftAdapter;
import com.lv.mama.lv.kind.adapter.RightAdapter;
import com.lv.mama.lv.kind.bean.KindBean;
import com.lv.mama.lv.kind.bean.RightBean;
import com.lv.mama.lv.kind.presenter.Kpresenter;
import com.lv.mama.lv.kind.view.Kview;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class Fragment2 extends Fragment implements Kview {

    @BindView(R.id.left)
    RecyclerView left;
    @BindView(R.id.right)
    RecyclerView right;
    Unbinder unbinder;
    private Kpresenter kpresent;
    private LeftAdapter leftAdapter;
    private RightAdapter rightadapter;
    private int count=1;
    private HashMap<String, String> rMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra2, null, false);
        unbinder = ButterKnife.bind(this, view);
        kpresent=new Kpresenter(this);
        kpresent.getpleft("");
        rMap = new HashMap<>();
        rMap.put("cid","1");
        kpresent.getpright(rMap,"product/getProductCatagory");
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getleft(final List<KindBean.DataBean> data) {
        leftAdapter=new LeftAdapter(data,getActivity());
        left.setLayoutManager(new LinearLayoutManager(getActivity()));
        left.setAdapter(leftAdapter);
        leftAdapter.setOnItemClicks(new LeftAdapter.OnItemClicks() {
            @Override
            public void itemclick(int position, View view) {

                rMap.clear();
                int cid = data.get(position).getCid();
                rMap.put("cid",cid+"");
                kpresent.getpright(rMap,"product/getProductCatagory");
                Toast.makeText(getActivity(),cid+"",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void getright(List<RightBean.DataBean> data) {
        rightadapter=new RightAdapter(data,getActivity());
        right.setLayoutManager(new LinearLayoutManager(getActivity()));
        right.setAdapter(rightadapter);

    }
}
