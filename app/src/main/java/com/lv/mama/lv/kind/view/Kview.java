package com.lv.mama.lv.kind.view;

import com.lv.mama.lv.kind.bean.KindBean;
import com.lv.mama.lv.kind.bean.RightBean;

import java.util.List;

/**
 * Created by 武晓瑞 on 2017/11/14.
 */

public interface Kview {
    void getleft(List<KindBean.DataBean> data);
    void getright(List<RightBean.DataBean> data);
}
