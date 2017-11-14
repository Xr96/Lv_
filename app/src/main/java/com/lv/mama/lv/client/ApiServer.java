package com.lv.mama.lv.client;


import com.lv.mama.lv.home.bean.HomeBean;
import com.lv.mama.lv.kind.bean.DataleftBean;
import com.lv.mama.lv.kind.bean.DatarightBean;
import com.lv.mama.lv.mine.Deng.bean.DengBean;
import com.lv.mama.lv.mine.Deng.bean.ZhuBean;

import java.util.HashMap;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();
    @POST
    Observable<DengBean> postpage(@Url String url, @QueryMap Map<String,String> map);

    @POST
    Observable<ZhuBean> postzhu(@Url String url, @QueryMap Map<String,String> map);

    @GET("index.php?act=goods_class")
    Observable<DataleftBean> getKindLeft();
    @POST()
    Observable<DatarightBean> getKindRigth(@Url String url, @QueryMap HashMap<String,String> map);
}
