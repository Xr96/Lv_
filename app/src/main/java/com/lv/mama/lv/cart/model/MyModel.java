package com.lv.mama.lv.cart.model;

import android.util.Log;

import com.lv.mama.lv.cart.bean.CartBean;
import com.lv.mama.lv.cart.bean.DeleteBean;
import com.lv.mama.lv.cart.bean.UpdateBean;
import com.lv.mama.lv.client.Api;
import com.lv.mama.lv.client.ApiServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 武晓瑞 on 2017/11/18.
 */

public class MyModel implements ImyModel {
    public interface onDataOverListener{
        void onDataOver(CartBean cartBean);
    }
    private onDataOverListener mOnDataOverListener;
    public void setOnDataOverListener(onDataOverListener mOnDataOverListener){
        this.mOnDataOverListener = mOnDataOverListener;
    }
    @Override
    public void getDatas(int uid) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_KIND).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<CartBean> cart = apiServer.getCart("product/getCarts?uid=" + uid);
        cart.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("mylog", "onError: 失败");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        Log.d("mylog", "onNext: 成功");
                        if(mOnDataOverListener!=null){
                            mOnDataOverListener.onDataOver(cartBean);
                        }
                    }
                });
    }

    public interface onUpdateOverListener{
        void onUpdateOver(UpdateBean updateBean);
    }
    private onUpdateOverListener mOnUpdateOverListener;
    public void setOnUpdateOverListener(onUpdateOverListener mOnUpdateOverListener){
        this.mOnUpdateOverListener = mOnUpdateOverListener;
    }

    @Override
    public void updateCarts(int uid, int seller, int pid, int num, int selected) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_KIND).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<UpdateBean> updateBean = apiServer.updateCart("product/updateCarts?uid=" + uid + "&sellerid=" + seller + "&pid=" + pid + "&selected=" + selected + "&num=" + num);
        updateBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpdateBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UpdateBean updateBean) {
                        if(mOnUpdateOverListener!=null){
                            mOnUpdateOverListener.onUpdateOver(updateBean);
                        }
                    }
                });
    }

    public interface onDeleteOverListener{
        void onDeleteOver(DeleteBean deleteBean);
    }
    private onDeleteOverListener mOnDeleteOverListener;
    public void setOnDeleteOverListener(onDeleteOverListener mOnDataOverListener){
        this.mOnDeleteOverListener = mOnDataOverListener;

    }
    @Override
    public void delete(int uid, int pid) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_KIND).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<DeleteBean> delete = apiServer.delete("product/deleteCart?uid=" + uid + "&pid=" + pid);
        delete.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeleteBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DeleteBean deleteBean) {
                        if(mOnDeleteOverListener!=null){
                            mOnDeleteOverListener.onDeleteOver(deleteBean);
                        }
                    }
                });
    }
}
