package com.lv.mama.lv.mine.Deng.presenter;

import com.lv.mama.lv.mine.Deng.model.UserMode;
import com.lv.mama.lv.mine.Deng.view.IUserView;

import java.util.HashMap;

/**
 * Created by 武晓瑞 on 2017/11/10.
 */

public class UserPresenter implements UserMode.getUserModel {
    public final IUserView iUserView;
    public final UserMode userMode;

    public UserPresenter(IUserView iUserView) {
        this.iUserView = iUserView;
        this.userMode=new UserMode();
    }
    public void getdaTa(String url,HashMap<String,String> map){
        userMode.setondata(this);
        userMode.Login(url,map);
        userMode.Resele(url,map);
    }


    @Override
    public void getUser(String msg) {
        iUserView.onLoginYes(msg);
        iUserView.onLoginNo(msg);
    }
}
