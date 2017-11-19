package com.lv.mama.lv.mine.Deng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lv.mama.lv.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalActivity extends AppCompatActivity {

    @BindView(R.id.presonal_tui)
    ImageView presonalTui;
    @BindView(R.id.presonal_zi1)
    TextView presonalZi1;
    @BindView(R.id.presonal_duo)
    ImageView presonalDuo;
    @BindView(R.id.presonal_r1)
    RelativeLayout presonalR1;
    @BindView(R.id.tbtx)
    TextView tbtx;
    @BindView(R.id.h_rigth_1)
    ImageView hRigth1;
    @BindView(R.id.tbtx_x)
    ImageView tbtxX;
    @BindView(R.id.presonal_r2)
    RelativeLayout presonalR2;
    @BindView(R.id.hym)
    TextView hym;
    @BindView(R.id.h_rhm)
    TextView hRhm;
    @BindView(R.id.presonal_r3)
    RelativeLayout presonalR3;
    @BindView(R.id.tbnc)
    TextView tbnc;
    @BindView(R.id.h_rigth_3)
    ImageView hRigth3;
    @BindView(R.id.presonal_r4)
    RelativeLayout presonalR4;
    @BindView(R.id.ewm)
    TextView ewm;
    @BindView(R.id.h_rigth_4)
    ImageView hRigth4;
    @BindView(R.id.h_ewm)
    ImageView hEwm;
    @BindView(R.id.presonal_r5)
    RelativeLayout presonalR5;
    @BindView(R.id.xb)
    TextView xb;
    @BindView(R.id.h_rigth_5)
    ImageView hRigth5;
    @BindView(R.id.presonal_r6)
    RelativeLayout presonalR6;
    @BindView(R.id.activity_personal)
    RelativeLayout activityPersonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.presonal_tui)
    public void onViewClicked() {
        finish();
    }
}
