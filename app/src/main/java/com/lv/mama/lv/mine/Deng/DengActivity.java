package com.lv.mama.lv.mine.Deng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lv.mama.lv.R;
import com.lv.mama.lv.mine.Deng.bean.MessageEvent;
import com.lv.mama.lv.mine.Deng.presenter.UserPresenter;
import com.lv.mama.lv.mine.Deng.view.IUserView;
import com.lv.mama.lv.utils.SharedPreferencesUtils;
import com.lv.mama.lv.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DengActivity extends AppCompatActivity implements IUserView {

    @BindView(R.id.Deng_top)
    RelativeLayout DengTop;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.editText3)
    EditText editText3;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.Deng_bom)
    RelativeLayout DengBom;
    @BindView(R.id.activity_deng)
    RelativeLayout activityDeng;

    private UserPresenter userpresenter;
    private String name;
    private String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng);
        ButterKnife.bind(this);
        userpresenter=new UserPresenter(this);
    }

    @OnClick({R.id.editText2, R.id.editText3, R.id.button, R.id.textView2, R.id.textView3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.editText2:
                break;
            case R.id.editText3:
                break;
            case R.id.button:
                name = editText2.getText().toString();
                pass = editText3.getText().toString();
                HashMap<String,String> map= new HashMap<>();
                map.put("mobile",name);
                map.put("password",pass);
                userpresenter.getdaTa("login",map);
                EventBus.getDefault().post(new MessageEvent(name));
                break;
            case R.id.textView2:
                startActivity(new Intent(this,ZhuActivity.class));
                break;
            case R.id.textView3:
                break;
        }
    }

    @Override
    public void onLoginYes(String msg) {
        if(msg.equals("登录成功")){
            ToastUtil.show(DengActivity.this,msg, Toast.LENGTH_SHORT);
            SharedPreferencesUtils.setParam(DengActivity.this,"isLogin",true);
            finish();
        }else {
            ToastUtil.show(DengActivity.this,msg, Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onLoginNo(String msg) {

    }
}
