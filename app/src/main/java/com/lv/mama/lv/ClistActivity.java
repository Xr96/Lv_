package com.lv.mama.lv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lv.mama.lv.kind.adapter.SplbAdapter;
import com.lv.mama.lv.kind.bean.PcidUser;
import com.lv.mama.lv.kind.bean.PidUser;
import com.lv.mama.lv.kind.bean.SplbBean;
import com.lv.mama.lv.kind.presenter.Xpresenter;
import com.lv.mama.lv.kind.view.Xview;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClistActivity extends AppCompatActivity implements Xview {

    @BindView(R.id.splb_list)
    ListView splbList;
    @BindView(R.id.activity_clist)
    RelativeLayout activityClist;
    private Xpresenter xpresenter;
    private int prcid;
    private SplbAdapter adapter;
    private HashMap<String, String> map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clist);
        ButterKnife.bind(this);
        /*
        * 创建注册
        * */
        EventBus.getDefault().register(ClistActivity.this);
        xpresenter=new Xpresenter(this);
        map = new HashMap<>();
        map.put("pscid", prcid + "");
        map.put("page", "1");
        map.put("sort", "0");
        xpresenter.getSplbdaTa("product/getProducts", map);
    }

    @Override
    public void getSplbdata(final List<SplbBean.DataBean> data) {
        adapter=new SplbAdapter(data,ClistActivity.this);
        splbList.setAdapter(adapter);
        splbList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String pid = data.get(i).getPid();
                Toast.makeText(ClistActivity.this, pid, Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky(new PidUser(pid));
                startActivity(new Intent(ClistActivity.this,DetailsActivity.class));
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*
        * 取消注册
        * */
        EventBus.getDefault().unregister(ClistActivity.this);
    }
    @Subscribe(sticky = true)
    public void onEventMainThread(PcidUser event) {
        prcid = event.getPrcid();
    }
}
