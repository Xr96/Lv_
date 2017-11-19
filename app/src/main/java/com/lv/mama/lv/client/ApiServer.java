package com.lv.mama.lv.client;


import com.lv.mama.lv.cart.bean.CartBean;
import com.lv.mama.lv.cart.bean.DeleteBean;
import com.lv.mama.lv.cart.bean.UpdateBean;
import com.lv.mama.lv.home.bean.HomeBean;
import com.lv.mama.lv.kind.bean.AddBean;
import com.lv.mama.lv.kind.bean.KindBean;
import com.lv.mama.lv.kind.bean.RightBean;
import com.lv.mama.lv.kind.bean.SplbBean;
import com.lv.mama.lv.kind.bean.XqBean;
import com.lv.mama.lv.mine.Deng.bean.DengBean;
import com.lv.mama.lv.mine.Deng.bean.ZhuBean;

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
    /*
    * 首页
    * */
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();

    /*
    * 登录与注册
    * */
    @POST
    Observable<DengBean> postpage(@Url String url, @QueryMap Map<String,String> map);

    /*
    * 商品左边
    * */
    @POST
    Observable<ZhuBean> postzhu(@Url String url, @QueryMap Map<String,String> map);



    @GET("product/getCatagory")
    Observable<KindBean> getkd();

    /*
    * 商品分类右边
    * */
    @POST
    Observable<RightBean> getkdRight(@Url String str, @QueryMap Map<String,String> map);

    /*
    * 商品列表
    * */
    @POST()
    Observable<SplbBean> getSplb(@Url String url, @QueryMap Map<String,String> map);

    /*
    * 详情页
    * */
    @POST()
    Observable<XqBean> getXq(@Url String str, @QueryMap Map<String,String> map);

    /*
    * 加入购物车
    * */
    @POST()
    Observable<AddBean> getAdd(@Url String url,@QueryMap Map<String,String> map);

    @GET
    Observable<CartBean> getCart(@Url String url);

    @GET
    Observable<UpdateBean> updateCart(@Url String url);

    @GET
    Observable<DeleteBean> delete(@Url String url);
}
