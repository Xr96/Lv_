package com.lv.mama.lv.kind;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.lv.mama.lv.R;
import com.lv.mama.lv.kind.adapter.MyAdapter_left;
import com.lv.mama.lv.kind.adapter.MyAdapter_right;
import com.lv.mama.lv.kind.bean.DataleftBean;
import com.lv.mama.lv.kind.bean.DatarightBean;
import com.lv.mama.lv.kind.presenter.Kpresenter;
import com.lv.mama.lv.kind.view.Kview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class Fragment2 extends Fragment implements Kview {

    @BindView(R.id.type_rvleft)
    RecyclerView rv_left;
    @BindView(R.id.type_rvright)
    RecyclerView rv_right;
    Unbinder unbinder;
    private Kpresenter kpresenter;
    private MyAdapter_left myAdapter_left;
    private String gc_id;
    private List<DataleftBean.DatasBean.ClassListBean> list=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra2, null, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        //得到WindowManager
        WindowManager windowManager = getActivity().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //得到屏幕宽
        int width = display.getWidth();
        //将RecyclerView宽设置为屏幕宽的1/5
        params.width = width * 1 / 5;
        rv_left.setLayoutParams(params);
        //得到RecyclerView布局管理器
        LinearLayoutManager leftLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        rv_left.setLayoutManager(leftLayoutManager);
        //得到RecyclerView布局管理器
        LinearLayoutManager rightLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        rv_right.setLayoutManager(rightLayoutManager);
        //获取后台数据，添加适配器
        kpresenter=new Kpresenter(this);
        kpresenter.getKingdaTa();
        return view;
    }

    @Override
    public void getKdata(final List<DataleftBean.DatasBean.ClassListBean> class_list) {
        myAdapter_left = new MyAdapter_left(getActivity(),class_list);
        rv_left.setAdapter(myAdapter_left);
        //子条目点击监听
        myAdapter_left.setRecycleViewItemClickListener(new MyAdapter_left.OnRecycleViewItemClickListener() {
            @Override
            public void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {
                myAdapter_left.setTagPosition(position);
                myAdapter_left.notifyDataSetChanged();
                kpresenter.getKingdaTas(class_list.get(position).getGc_id(),position);
            }
        });
    }

    @Override
    public void getKdatas(List<DatarightBean.DatasBean.ClassListBean> class_list) {
        MyAdapter_right myAdapter_right=new MyAdapter_right(getActivity(),class_list);
        rv_right.setAdapter(myAdapter_right);
    }

    /*public interface OnGetServerDateLisnter {
        void getData(String string);
    }*/
   /* //获取网络数据的方法
    public static void getServerData(Context context, String url, final OnGetServerDateLisnter onGetServerDateLisnter) {
        OkHttp3Utils.getInstance().doGet(url, new GsonObjectCallback<Datebeanitem>() {
            @Override
            public void onUi(Datebeanitem datebeanitem) {
                onGetServerDateLisnter.getData(datebeanitem.getDatas().toString());
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
