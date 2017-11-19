package com.lv.mama.lv.mine.Deng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lv.mama.lv.R;
import com.lv.mama.lv.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.presonal_tui)
    ImageView presonalTui;
    @BindView(R.id.presonal_zi1)
    TextView presonalZi1;
    @BindView(R.id.presonal_duo)
    ImageView presonalDuo;
    @BindView(R.id.setting_r1)
    RelativeLayout settingR1;
    @BindView(R.id.setting_top_toux)
    ImageView settingTopToux;
    @BindView(R.id.setting_top_name)
    TextView settingTopName;
    @BindView(R.id.setting_top_hyh)
    TextView settingTopHyh;
    @BindView(R.id.setting_top_names)
    TextView settingTopNames;
    @BindView(R.id.setting_wenzi)
    RelativeLayout settingWenzi;
    @BindView(R.id.s_h_rigth_1)
    ImageView sHRigth1;
    @BindView(R.id.s_h_ewm)
    ImageView sHEwm;
    @BindView(R.id.setting_r2)
    RelativeLayout settingR2;
    @BindView(R.id.shdz)
    TextView shdz;
    @BindView(R.id.s_h_rigth_2)
    ImageView sHRigth2;
    @BindView(R.id.setting_r3)
    RelativeLayout settingR3;
    @BindView(R.id.zhaq)
    TextView zhaq;
    @BindView(R.id.s_h_rigth_3)
    ImageView sHRigth3;
    @BindView(R.id.setting_r4)
    RelativeLayout settingR4;
    @BindView(R.id.dqsz)
    TextView dqsz;
    @BindView(R.id.s_h_rigth_4)
    ImageView sHRigth4;
    @BindView(R.id.setting_r5)
    RelativeLayout settingR5;
    @BindView(R.id.yxtz)
    TextView yxtz;
    @BindView(R.id.s_h_rigth_5)
    ImageView sHRigth5;
    @BindView(R.id.setting_r6)
    RelativeLayout settingR6;
    @BindView(R.id.ys)
    TextView ys;
    @BindView(R.id.s_h_rigth_6)
    ImageView sHRigth6;
    @BindView(R.id.setting_r7)
    RelativeLayout settingR7;
    @BindView(R.id.ty)
    TextView ty;
    @BindView(R.id.s_h_rigth_7)
    ImageView sHRigth7;
    @BindView(R.id.setting_r8)
    RelativeLayout settingR8;
    @BindView(R.id.xm)
    TextView xm;
    @BindView(R.id.s_h_rigth_8)
    ImageView sHRigth8;
    @BindView(R.id.setting_r9)
    RelativeLayout settingR9;
    @BindView(R.id.sjtb)
    TextView sjtb;
    @BindView(R.id.s_h_rigth_9)
    ImageView sHRigth9;
    @BindView(R.id.setting_r10)
    RelativeLayout settingR10;
    @BindView(R.id.setting_th)
    Button settingTh;
    @BindView(R.id.activity_setting)
    RelativeLayout activitySetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @OnClick({R.id.presonal_tui, R.id.setting_th})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.presonal_tui:
                finish();
                break;
            case R.id.setting_th:
                SharedPreferencesUtils.setParam(this,"islog",false);
                finish();
                break;
        }
    }
}
