package com.lv.mama.lv.kind.presenter;

import com.lv.mama.lv.kind.bean.KindBean;
import com.lv.mama.lv.kind.bean.RightBean;
import com.lv.mama.lv.kind.model.Kmmodel;
import com.lv.mama.lv.kind.view.Kview;

import java.util.List;
import java.util.Map;

/**
 * Created by 武晓瑞 on 2017/11/14.
 */

public class Kpresenter implements Kmmodel.onFinshkind,Kmmodel.onRightkind {
    public final Kview kview;
    public final Kmmodel kmmodel;

    public Kpresenter(Kview kview) {
        this.kview = kview;
        this.kmmodel=new Kmmodel();
    }
    public void getpleft(String str){
        kmmodel.Setkind(this);
        kmmodel.getKind(str);
    }
    public void getpright(Map<String,String> map, String str){
        kmmodel.SetRightkind(this);
        kmmodel.getKindrig(map,str);
    }


    @Override
    public void Finshkind(List<KindBean.DataBean> data) {
        kview.getleft(data);
    }

    @Override
    public void Rigthkind(List<RightBean.DataBean> data) {
        kview.getright(data);
    }
}
