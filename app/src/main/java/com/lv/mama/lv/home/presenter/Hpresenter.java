package com.lv.mama.lv.home.presenter;

import com.lv.mama.lv.home.bean.HomeBean;
import com.lv.mama.lv.home.model.Mmodel;
import com.lv.mama.lv.home.view.Hview;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class Hpresenter implements Mmodel.getHmodel {
    public final Hview hview;
    public final Mmodel mmodel;

    public Hpresenter(Hview hview) {
        this.hview = hview;
        this.mmodel=new Mmodel();
    }
    public void getdaTa(){
        mmodel.setondata(this);
        mmodel.getDatas();
    }

    @Override
    public void getUser(HomeBean.DataBean data) {
        hview.getData(data);
    }
}
