package com.lv.mama.lv.mine.Deng.view;

import com.lv.mama.lv.mine.Deng.bean.DengBean;

/**
 * Created by 武晓瑞 on 2017/11/10.
 */

public interface IUserView {
    //登录成功
    void Success(String msg);
    void LoginSuccess(DengBean.DataBean data, String msg);
    //登录失败
    void Filde(String msg);
}
