package com.lv.mama.lv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.lv.mama.lv.cart.Fragment3;
import com.lv.mama.lv.home.Fragment1;
import com.lv.mama.lv.kind.Fragment2;
import com.lv.mama.lv.mine.Deng.DengActivity;
import com.lv.mama.lv.mine.Fragment4;
import com.lv.mama.lv.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.zfragment)
    LinearLayout zfragment;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private FragmentManager fm;
    private boolean isLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fm = getSupportFragmentManager();
        FragmentTransaction fb = fm.beginTransaction();
        fb.add(R.id.zfragment, fragment1);
        fb.add(R.id.zfragment, fragment2);
        fb.add(R.id.zfragment, fragment3);
        fb.add(R.id.zfragment, fragment4);
        fb.show(fragment1);
        fb.hide(fragment2);
        fb.hide(fragment3);
        fb.hide(fragment4);
        fb.commit();


    }

    @Override
    protected void onStart() {
        super.onStart();
        isLogin = (boolean) SharedPreferencesUtils.getParam(MainActivity.this, "islog", false);
        if(isLogin==false){
            rb1.setChecked(true);
            FragmentTransaction ft1 = fm.beginTransaction();
            ft1.show(fragment1);
            ft1.hide(fragment2);
            ft1.hide(fragment3);
            ft1.hide(fragment4);
            ft1.commit();
        }else {
            rb4.setChecked(true);
            FragmentTransaction ft1 = fm.beginTransaction();
            ft1.show(fragment4);
            ft1.hide(fragment2);
            ft1.hide(fragment3);
            ft1.hide(fragment1);
            ft1.commit();
        }

    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                FragmentTransaction ft1 = fm.beginTransaction();
                ft1.show(fragment1);
                ft1.hide(fragment2);
                ft1.hide(fragment3);
                ft1.hide(fragment4);
                ft1.commit();
                break;
            case R.id.rb2:
                isLogin = (boolean) SharedPreferencesUtils.getParam(MainActivity.this, "islog", false);
                if(isLogin){
                    FragmentTransaction ft2 = fm.beginTransaction();
                    ft2.show(fragment2);
                    ft2.hide(fragment1);
                    ft2.hide(fragment3);
                    ft2.hide(fragment4);
                    ft2.commit();
                }else {
                    startActivity(new Intent(MainActivity.this, DengActivity.class));
                }

                break;
            case R.id.rb3:
                isLogin = (boolean) SharedPreferencesUtils.getParam(MainActivity.this, "islog", false);
                if(isLogin){
                    FragmentTransaction ft3 = fm.beginTransaction();
                    ft3.show(fragment3);
                    ft3.hide(fragment1);
                    ft3.hide(fragment2);
                    ft3.hide(fragment4);
                    ft3.commit();

                }else {
                    startActivity(new Intent(MainActivity.this, DengActivity.class));
                }
                break;
            case R.id.rb4:
                isLogin = (boolean) SharedPreferencesUtils.getParam(MainActivity.this, "islog", false);
                if(isLogin){
                    FragmentTransaction ft4 = fm.beginTransaction();
                    ft4.show(fragment4);
                    ft4.hide(fragment3);
                    ft4.hide(fragment1);
                    ft4.hide(fragment2);
                    ft4.commit();

                }else {
                    startActivity(new Intent(MainActivity.this, DengActivity.class));
                }
                break;
        }
    }
}
