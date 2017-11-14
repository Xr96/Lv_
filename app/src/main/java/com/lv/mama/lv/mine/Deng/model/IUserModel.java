package com.lv.mama.lv.mine.Deng.model;

import java.util.HashMap;

/**
 * Created by 武晓瑞 on 2017/11/10.
 */

public interface IUserModel {
    void Login(String url,HashMap<String,String> map);
    void Resele(String url,HashMap<String,String> map);
}
