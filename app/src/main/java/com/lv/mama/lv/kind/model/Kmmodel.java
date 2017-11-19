package com.lv.mama.lv.kind.model;

import com.lv.mama.lv.client.Api;
import com.lv.mama.lv.client.ApiServer;
import com.lv.mama.lv.kind.bean.AddBean;
import com.lv.mama.lv.kind.bean.KindBean;
import com.lv.mama.lv.kind.bean.RightBean;
import com.lv.mama.lv.kind.bean.SplbBean;
import com.lv.mama.lv.kind.bean.XqBean;

import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 武晓瑞 on 2017/11/14.
 */

public class Kmmodel implements Kmodel {

    /*
    * 商品列表
    * */

    public interface onFinshkind{
        void Finshkind(List<KindBean.DataBean> data);
    }
    private onRightkind onrightkind;

    public void SetRightkind(onRightkind onrightkind) {
        this.onrightkind = onrightkind;
    }
    public interface onRightkind{
        void Rigthkind(List<RightBean.DataBean> data);
    }
    private onFinshkind onfinshkind;

    public void Setkind(onFinshkind onfinshkind) {
        this.onfinshkind = onfinshkind;
    }

    public interface onSplbKind{
        void Splbkind(List<SplbBean.DataBean> data);
    }
    public onSplbKind onsplbkind;

    public void setsplbdata(onSplbKind onsplbkind) {
        this.onsplbkind = onsplbkind;
    }

    public interface getXqChuan{
        void getQuser(XqBean.DataBean data);
    }
    public getXqChuan getxqchuan;

    public void setXqdata(getXqChuan getxqchuan) {
        this.getxqchuan = getxqchuan;
    }

    @Override
    public void getKind(String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_KIND).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<KindBean> getkd = apiServer.getkd();
        getkd.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<KindBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(KindBean kindBean) {
                        List<KindBean.DataBean> data = kindBean.getData();
                        onfinshkind.Finshkind(data);
                    }
                });
    }

    @Override
    public void getKindrig(Map<String, String> msp, String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_KIND).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<RightBean> kindBeanObservable = apiServer.getkdRight(url, msp);
        kindBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RightBean rightBean) {
                        List<RightBean.DataBean> data = rightBean.getData();
                        onrightkind.Rigthkind(data);
                    }
                });
    }

    @Override
    public void getXqy(String url, Map<String, String> map) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_KIND).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<SplbBean> splb = apiServer.getSplb(url, map);
        splb.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SplbBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SplbBean splbBean) {
                        List<SplbBean.DataBean> data = splbBean.getData();
                        onsplbkind.Splbkind(data);
                    }
                });
    }

    @Override
    public void getXqdAta(Map<String, String> msp, String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_KIND).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<XqBean> xq = apiServer.getXq(url, msp);
        xq.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XqBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(XqBean xqBean) {
                        XqBean.DataBean data = xqBean.getData();
                        getxqchuan.getQuser(data);
                    }
                });
    }

    @Override
    public void getAddData(Map<String, String> map, String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_KIND).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<AddBean> add = apiServer.getAdd(url, map);
        add.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AddBean addBean) {
                        String msg = addBean.getMsg();
                        getaddchuan.getAddUser(msg);
                    }
                });

    }
    public interface getAddChuan{
        void getAddUser(String msg);
    }
    public getAddChuan getaddchuan;

    public void setadddata(getAddChuan getaddchuan) {
        this.getaddchuan = getaddchuan;
    }
}
