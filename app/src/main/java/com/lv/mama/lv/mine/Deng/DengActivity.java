package com.lv.mama.lv.mine.Deng;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lv.mama.lv.R;
import com.lv.mama.lv.mine.Deng.bean.DengBean;
import com.lv.mama.lv.mine.Deng.bean.MessageEvent;
import com.lv.mama.lv.mine.Deng.presenter.UserPresenter;
import com.lv.mama.lv.mine.Deng.view.IUserView;
import com.lv.mama.lv.utils.SharedPreferencesUtils;
import com.lv.mama.lv.utils.ToastUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

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
    private RadioButton qq;
    private RadioGroup rgdlog;
    private TextView choosePhoto;
    private Dialog dialog;

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
                userpresenter.getlogin("user/login",map);
                EventBus.getDefault().post(new MessageEvent(name));
                break;
            case R.id.textView2:
                startActivity(new Intent(this,ZhuActivity.class));
                break;
            case R.id.textView3:
                dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
                //填充对话框的布局
                View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
                //初始化控件
                qq= (RadioButton) inflate.findViewById(R.id.qq);
                choosePhoto = (TextView) inflate.findViewById(R.id.choosePhoto);
                rgdlog = (RadioGroup) inflate.findViewById(R.id.rgdlog);
                //将布局设置给Dialog
                dialog.setContentView(inflate);
                //获取当前Activity所在的窗体
                Window dialogWindow = dialog.getWindow();
                //设置Dialog从窗体底部弹出
                dialogWindow.setGravity(Gravity.BOTTOM);
                //获得窗体的属性
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                lp.y = 20;//设置Dialog距离底部的距离
//       将属性设置给窗体
                dialogWindow.setAttributes(lp);
                dialog.show();//显示对话框
                rgdlog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.qq:
                                UMShareAPI.get(DengActivity.this).getPlatformInfo(DengActivity.this, SHARE_MEDIA.QQ,umAuthListener);

                                break;
                        }
                        dialog.dismiss();
                    }
                });
                choosePhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    UMAuthListener umAuthListener  = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            System.out.println("uid========"+map.get("uid"));
            System.out.println("name========"+map.get("name"));
            System.out.println("iconurl========"+map.get("iconurl"));
            ToastUtil.showLong(DengActivity.this , "社会瑞哥"+map.get("name"));
            /*//设置QQ头像
            ImageLoader.getInstance().displayImage(map.get("iconurl"),micon);
            //设置QQ名字
            mname.setText(map.get("name"));*/
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };

    @Override
    public void Success(String msg) {

    }

    @Override
    public void LoginSuccess(DengBean.DataBean data, String msg) {
        int uid = data.getUid();
        SharedPreferencesUtils.setParam(DengActivity.this,"uid",uid);
        ToastUtil.showShort(DengActivity.this,msg);
        SharedPreferencesUtils.setParam(DengActivity.this,"islog",true);
        SharedPreferencesUtils.setParam(DengActivity.this,"name",name);
        SharedPreferencesUtils.setParam(DengActivity.this,"img",R.mipmap.ic_default_user_head);
        finish();
    }

    @Override
    public void Filde(String msg) {
        ToastUtil.showShort(DengActivity.this,msg);
    }
}
