package com.lv.mama.lv.kind.model;

import com.lv.mama.lv.client.Api;
import com.lv.mama.lv.client.ApiServer;
import com.lv.mama.lv.kind.bean.DataleftBean;
import com.lv.mama.lv.kind.bean.DatarightBean;

import java.util.HashMap;
import java.util.List;

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
    * 获取后台的数据
    * */
    @Override
    public void getServerData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_PATH).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<DataleftBean> kindLeft = apiServer.getKindLeft();
        kindLeft.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataleftBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DataleftBean dataleftBean) {
                        List<DataleftBean.DatasBean.ClassListBean> class_list = dataleftBean.getDatas().getClass_list();
                        getkingchuan.getKingUser(class_list);
                    }
                });

    }

    @Override
    public void getServerTypeData(String gc_id, int position) {
        HashMap<String,String> map=new HashMap<>();
        map.put("gc_id",gc_id);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.TYPE_PATH).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<DatarightBean> kindRigth = apiServer.getKindRigth("index.php?act=goods_class",map);
        kindRigth.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DatarightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DatarightBean datarightBean) {
                        List<DatarightBean.DatasBean.ClassListBean> class_list = datarightBean.getDatas().getClass_list();
                        getkindchuans.getKindUsers(class_list);
                    }
                });

    }
    /*
    * 右边
    * */
    public interface getKindChuans{
        void getKindUsers(List<DatarightBean.DatasBean.ClassListBean> class_list);
    }
    public getKindChuans getkindchuans;

    public void setkingdatas(getKindChuans getkindchuans) {
        this.getkindchuans = getkindchuans;
    }

    /*
        * 左边
        * */
    public interface getKindChuan{
        void getKingUser(List<DataleftBean.DatasBean.ClassListBean> class_list);
    }
    public getKindChuan getkingchuan;

    public void setkingdata(getKindChuan getkingchuan) {
        this.getkingchuan = getkingchuan;
    }
}
