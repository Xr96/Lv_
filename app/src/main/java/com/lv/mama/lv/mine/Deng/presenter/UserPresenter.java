package com.lv.mama.lv.mine.Deng.presenter;

import com.lv.mama.lv.mine.Deng.bean.DengBean;
import com.lv.mama.lv.mine.Deng.model.UserMode;
import com.lv.mama.lv.mine.Deng.view.IUserView;

import java.util.Map;

/**
 * Created by 武晓瑞 on 2017/11/10.
 */

public class UserPresenter implements UserMode.onMFinsh,UserMode.onregMFinsh {
    public final IUserView iUserView;
    public final UserMode userMode;

    public UserPresenter(IUserView iUserView) {
        this.iUserView = iUserView;
        this.userMode=new UserMode();
    }
    public void getlogin(String url,Map<String,String> map)
    {
        userMode.setonfinsh(this);
        userMode.Success(url,map);
    }
    public void getreg(String url,Map<String,String> map)
    {
        userMode.setregFinsh(this);
        userMode.Register(url,map);
    }
    @Override
    public void getCode(DengBean.DataBean data, String msg) {
        if (msg.equals("登录成功")){
            iUserView.LoginSuccess(data,msg);
        }else {
            iUserView.Filde(msg);
        }
    }

    @Override
    public void getreg(String msg) {
        if (msg.equals("注册成功")){
            iUserView.Success(msg);
        }else{
            iUserView.Filde(msg);
        }
    }
}
