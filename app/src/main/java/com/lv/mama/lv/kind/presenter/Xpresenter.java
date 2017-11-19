package com.lv.mama.lv.kind.presenter;

import com.lv.mama.lv.kind.bean.SplbBean;
import com.lv.mama.lv.kind.model.Kmmodel;
import com.lv.mama.lv.kind.view.Xview;

import java.util.List;
import java.util.Map;

/**
 * Created by 武晓瑞 on 2017/11/16.
 */

public class Xpresenter implements Kmmodel.onSplbKind {
    public final Xview xview;
    public final Kmmodel kmmodel;

    public Xpresenter(Xview xview) {
        this.xview = xview;
        this.kmmodel=new Kmmodel();
    }
    public void getSplbdaTa(String url, Map<String,String> map){
        kmmodel.setsplbdata(this);
        kmmodel.getXqy(url,map);
    }
    @Override
    public void Splbkind(List<SplbBean.DataBean> data) {
        xview.getSplbdata(data);
    }
}
