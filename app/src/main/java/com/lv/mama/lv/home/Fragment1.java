package com.lv.mama.lv.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lv.mama.lv.R;
import com.lv.mama.lv.home.adapter.XRAdapter;
import com.lv.mama.lv.home.bean.HomeBean;
import com.lv.mama.lv.home.presenter.Hpresenter;
import com.lv.mama.lv.home.view.Hview;
import com.lv.mama.lv.home.view.SouActivity;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class Fragment1 extends Fragment implements Hview {
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.title1)
    RelativeLayout title1;
    Unbinder unbinder;
    private XRecyclerView xr;
    private List<String> list = new ArrayList<>();
    //获取数据的开始
    private int curr;
    private XRAdapter adapter;
    private Hpresenter hpresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra1, null, false);
        unbinder = ButterKnife.bind(this, view);
        xr=(XRecyclerView)view.findViewById(R.id.xre_xrv);
        //加布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(layoutManager);
        hpresenter=new Hpresenter(this);
        hpresenter.getdaTa();
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                curr=0;
                list.clear();
                xr.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                curr++;
                list.clear();
                xr.loadMoreComplete();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.img1, R.id.img2, R.id.editText, R.id.img3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img1:
                Toast.makeText(getActivity(),"进行二维码扫描",Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
                break;
            case R.id.img2:
                break;
            case R.id.editText:
                Intent intent = new Intent(getActivity(), SouActivity.class);
                startActivity(intent);
                break;
            case R.id.img3:
                break;
        }
    }

    @Override
    public void getData(HomeBean.DataBean data) {
        adapter=new XRAdapter(getActivity(),data);
        xr.setAdapter(adapter);
    }
}
