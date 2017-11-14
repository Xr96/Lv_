package com.lv.mama.lv.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lv.mama.lv.R;
import com.lv.mama.lv.mine.Deng.PersonalActivity;
import com.lv.mama.lv.mine.Deng.SettingActivity;
import com.lv.mama.lv.mine.Deng.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class Fragment4 extends Fragment {
    @BindView(R.id.Head_portrait)
    ImageView HeadPortrait;
    @BindView(R.id.f4a)
    RadioButton f4a;
    @BindView(R.id.f4b)
    RadioButton f4b;
    @BindView(R.id.f4c)
    RadioButton f4c;
    @BindView(R.id.f4d)
    RadioGroup f4d;
    @BindView(R.id.Number)
    TextView Number;
    @BindView(R.id.f4top)
    RelativeLayout f4top;
    @BindView(R.id.dingTu)
    ImageView dingTu;
    @BindView(R.id.dingZi)
    TextView dingZi;
    @BindView(R.id.jT1)
    ImageView jT1;
    @BindView(R.id.dingDan)
    RelativeLayout dingDan;
    @BindView(R.id.f4ad)
    RadioButton f4ad;
    @BindView(R.id.f4bd)
    RadioButton f4bd;
    @BindView(R.id.f4cd)
    RadioButton f4cd;
    @BindView(R.id.f4dd)
    RadioButton f4dd;
    @BindView(R.id.f4fd)
    RadioButton f4fd;
    @BindView(R.id.f4ding)
    RadioGroup f4ding;
    @BindView(R.id.caiTu)
    ImageView caiTu;
    @BindView(R.id.caiZi)
    TextView caiZi;
    @BindView(R.id.jT2)
    ImageView jT2;
    @BindView(R.id.caiChan)
    RelativeLayout caiChan;
    @BindView(R.id.f4ac)
    RadioButton f4ac;
    @BindView(R.id.f4bc)
    RadioButton f4bc;
    @BindView(R.id.f4cc)
    RadioButton f4cc;
    @BindView(R.id.f4dc)
    RadioButton f4dc;
    @BindView(R.id.f4fc)
    RadioButton f4fc;
    @BindView(R.id.f4cai)
    RadioGroup f4cai;
    @BindView(R.id.diTu)
    ImageView diTu;
    @BindView(R.id.diZi)
    TextView diZi;
    @BindView(R.id.jT3)
    ImageView jT3;
    @BindView(R.id.diZhi)
    RelativeLayout diZhi;
    @BindView(R.id.sheTu)
    ImageView sheTu;
    @BindView(R.id.sheZi)
    TextView sheZi;
    @BindView(R.id.jT4)
    ImageView jT4;
    @BindView(R.id.sheZhi)
    RelativeLayout sheZhi;
    Unbinder unbinder;
    @BindView(R.id.setting_up)
    TextView settingUp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra4, null, false);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        } else {
            Toast.makeText(getActivity(), "请勿重复注册事件", Toast.LENGTH_SHORT).show();
        }
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.Head_portrait, R.id.f4a, R.id.f4b, R.id.f4c, R.id.f4d,R.id.setting_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Head_portrait:
                startActivity(new Intent(getActivity(), PersonalActivity.class));
                break;
            case R.id.f4a:
                break;
            case R.id.f4b:
                break;
            case R.id.f4c:
                break;
            case R.id.f4d:
                break;
            case R.id.setting_up:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent message) {
        Number.setText(message.getMessage());
    }

}
