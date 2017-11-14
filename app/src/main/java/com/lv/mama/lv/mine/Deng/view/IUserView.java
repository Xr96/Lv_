package com.lv.mama.lv.mine.Deng.view;

/**
 * Created by 武晓瑞 on 2017/11/10.
 */

public interface IUserView {
    /*
    * 登录成功
    * */
    void onLoginYes(String msg);
    /*
    * 登录失败
    * */
    void onLoginNo(String msg);
}
