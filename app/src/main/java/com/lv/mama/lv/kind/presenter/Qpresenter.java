package com.lv.mama.lv.kind.presenter;

import com.lv.mama.lv.kind.bean.XqBean;
import com.lv.mama.lv.kind.model.Kmmodel;
import com.lv.mama.lv.kind.view.Qview;

import java.util.Map;

/**
 * Created by 武晓瑞 on 2017/11/17.
 */

public class Qpresenter implements Kmmodel.getXqChuan{
    public final Qview qview;
    public final Kmmodel kmmodel;

    public Qpresenter(Qview qview) {
        this.qview = qview;
        this.kmmodel=new Kmmodel();
    }
    public void getXqdaTa(Map<String,String> map,String uri ){
        kmmodel.getXqdAta(map,uri);
        kmmodel.setXqdata(this);
    }

    @Override
    public void getQuser(XqBean.DataBean data) {
        qview.getXqData(data);
    }
}
