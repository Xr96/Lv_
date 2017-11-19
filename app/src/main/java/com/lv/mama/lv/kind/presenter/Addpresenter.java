package com.lv.mama.lv.kind.presenter;

import com.lv.mama.lv.kind.model.Kmmodel;
import com.lv.mama.lv.kind.view.Addview;

import java.util.Map;

/**
 * Created by 武晓瑞 on 2017/11/17.
 */

public class Addpresenter implements Kmmodel.getAddChuan {
    public final Addview addview;
    public final Kmmodel kmmodel;

    public Addpresenter(Addview addview) {
        this.addview = addview;
        this.kmmodel=new Kmmodel();
    }
    public void getAdddaTa(Map<String,String> map, String url){
        kmmodel.getAddData(map, url);
        kmmodel.setadddata(this);
    }

    @Override
    public void getAddUser(String msg) {
        addview.getAddview(msg);
    }
}
