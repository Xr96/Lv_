package com.lv.mama.lv.mine.Deng.model;

import com.lv.mama.lv.client.Api;
import com.lv.mama.lv.client.ApiServer;
import com.lv.mama.lv.mine.Deng.bean.DengBean;
import com.lv.mama.lv.mine.Deng.bean.ZhuBean;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 武晓瑞 on 2017/11/10.
 */

public class UserMode implements IUserModel {

    @Override
    public void Login(String url,HashMap<String,String> map) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_MINE_DENG).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<DengBean> postpage = apiServer.postpage(url, map);
        postpage.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DengBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DengBean dengBean) {
                        String code = dengBean.getMsg().toString();
                        getusermodel.getUser(code);
                    }
                });
    }

    @Override
    public void Resele(String url, HashMap<String, String> map) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_MINE_DENG).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<ZhuBean> postzhu = apiServer.postzhu(url, map);
        postzhu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ZhuBean zhuBean) {
                        String code = zhuBean.getMsg().toString();
                        getusermodel.getUser(code);
                    }
                });
    }

    public interface getUserModel{
        void getUser(String msg);
    }
    public getUserModel getusermodel;

    public void setondata(getUserModel getusermodel) {
        this.getusermodel = getusermodel;
    }
}
