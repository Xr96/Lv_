package com.lv.mama.lv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lv.mama.lv.common.PlayerManager;
import com.lv.mama.lv.kind.bean.PidUser;
import com.lv.mama.lv.kind.bean.XqBean;
import com.lv.mama.lv.kind.presenter.Addpresenter;
import com.lv.mama.lv.kind.presenter.Qpresenter;
import com.lv.mama.lv.kind.view.Addview;
import com.lv.mama.lv.kind.view.Qview;
import com.lv.mama.lv.media.IjkVideoView;
import com.lv.mama.lv.utils.SharedPreferencesUtils;
import com.lv.mama.lv.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity implements Qview, Addview,PlayerManager.PlayerStateListener {

    @BindView(R.id.details_tu)
    SimpleDraweeView detailsTu;
    @BindView(R.id.details_top)
    RelativeLayout detailsTop;
    @BindView(R.id.details_wenzi1)
    TextView detailsWenzi1;
    @BindView(R.id.kf)
    TextView kf;
    @BindView(R.id.sc)
    TextView sc;
    @BindView(R.id.details_gou)
    Button detailsGou;
    @BindView(R.id.details_fu)
    Button detailsFu;
    @BindView(R.id.details_bom)
    RelativeLayout detailsBom;
    @BindView(R.id.activity_details)
    RelativeLayout activityDetails;
    @BindView(R.id.video_view)
    IjkVideoView videoView;
    private Qpresenter qpresenter;
    private Addpresenter addpersenter;
    HashMap<String, String> demap;
    private String pid;
    private HashMap<String, String> addmap;
    private PlayerManager player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        EventBus.getDefault().register(DetailsActivity.this);
        demap = new HashMap<>();
        demap.put("pid", pid);
        qpresenter = new Qpresenter(this);
        qpresenter.getXqdaTa(demap, "product/getProductDetail");
        addmap = new HashMap<>();
        addpersenter = new Addpresenter(this);
        //初始化播放器
        //初始化播放器
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play("http://mp4.vjshi.com/2013-05-28/2013052815051372.mp4");
    }

    @OnClick({R.id.details_tu, R.id.kf, R.id.sc, R.id.details_gou, R.id.details_fu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_tu:
                break;
            case R.id.kf:
                break;
            case R.id.sc:
                break;
            case R.id.details_gou:
                int uid = (int) SharedPreferencesUtils.getParam(DetailsActivity.this, "uid", 666);
                addmap.put("uid", uid + "");
                addmap.put("pid", pid);
                addpersenter.getAdddaTa(addmap, "product/addCart");
                break;
            case R.id.details_fu:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*
        * 取消注册
        * */
        EventBus.getDefault().unregister(DetailsActivity.this);
    }

    @Subscribe(sticky = true)
    public void onEventMainThreads(PidUser event) {
        pid = event.getPid();
    }

    @Override
    public void getXqData(XqBean.DataBean data) {
        String images = data.getImages();
        String[] split = images.split("[|]");
        String[] split1 = split[0].split("[!]");
        detailsTu.setImageURI(split1[0]);
        detailsWenzi1.setText(data.getTitle());
        Toast.makeText(this, data.getTitle().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAddview(String msg) {
        ToastUtil.showShort(DetailsActivity.this, msg);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onPlay() {

    }
}
