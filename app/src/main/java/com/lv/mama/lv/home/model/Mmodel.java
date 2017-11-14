package com.lv.mama.lv.home.model;

import android.content.Context;

import com.lv.mama.lv.client.MyApp;
import com.lv.mama.lv.home.bean.HomeBean;
import com.lv.mama.lv.utils.RetroFactory;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class Mmodel implements Hmodel {
    Context mContext = MyApp.context;
    @Override
    public void getDatas() {
        final Observable<HomeBean> home = RetroFactory.getInstance().getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        HomeBean.DataBean data = homeBean.getData();
                        gethmodel.getUser(data);
                    }
                });
    }
    public interface getHmodel{
        void getUser(HomeBean.DataBean data);
    }
    public getHmodel gethmodel;

    public void setondata(getHmodel gethmodel) {
        this.gethmodel = gethmodel;
    }
}
