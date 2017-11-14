package com.lv.mama.lv.kind.presenter;

import com.lv.mama.lv.kind.bean.DataleftBean;
import com.lv.mama.lv.kind.bean.DatarightBean;
import com.lv.mama.lv.kind.model.Kmmodel;
import com.lv.mama.lv.kind.view.Kview;

import java.util.List;

/**
 * Created by 武晓瑞 on 2017/11/14.
 */

public class Kpresenter implements Kmmodel.getKindChuan,Kmmodel.getKindChuans {
    public final Kview kview;
    public final Kmmodel kmmodel;

    public Kpresenter(Kview kview) {
        this.kview = kview;
        this.kmmodel=new Kmmodel();
    }
    public void getKingdaTa(){
        kmmodel.setkingdata(this);
        kmmodel.getServerData();

    }
    public void getKingdaTas(String url,int position){
        kmmodel.setkingdatas(this);
        kmmodel.getServerTypeData(url,position);
    }

    @Override
    public void getKingUser(List<DataleftBean.DatasBean.ClassListBean> class_list) {
        kview.getKdata(class_list);
    }

    @Override
    public void getKindUsers(List<DatarightBean.DatasBean.ClassListBean> class_list) {
        kview.getKdatas(class_list);
    }
}
