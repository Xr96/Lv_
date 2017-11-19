package com.lv.mama.lv.cart.presenter;

import com.lv.mama.lv.cart.bean.CartBean;
import com.lv.mama.lv.cart.bean.DeleteBean;
import com.lv.mama.lv.cart.bean.UpdateBean;
import com.lv.mama.lv.cart.model.MyModel;
import com.lv.mama.lv.cart.view.ImyView;

/**
 * Created by 武晓瑞 on 2017/11/18.
 */

public class MyPresenter{
    ImyView imyView;
    MyModel myModel;

    public MyPresenter(ImyView imyView) {
        this.imyView = imyView;
        this.myModel=new MyModel();
    }

    public void getDatas(int uid) {
        myModel.getDatas(uid);
        myModel.setOnDataOverListener(new MyModel.onDataOverListener() {
            @Override
            public void onDataOver(CartBean cartBean) {
                imyView.onDataOver(cartBean);
            }
        });
    }

    public void updateCarts(int uid, int seller, int pid, int num, int selected) {
        myModel.updateCarts(uid,seller,pid,num,selected);
        myModel.setOnUpdateOverListener(new MyModel.onUpdateOverListener() {
            @Override
            public void onUpdateOver(UpdateBean updateBean) {
                imyView.onUpdateOver(updateBean);
            }
        });
    }

    public void delete(int uid, int pid) {
        myModel.setOnDeleteOverListener(new MyModel.onDeleteOverListener() {
            @Override
            public void onDeleteOver(DeleteBean deleteBean) {
                imyView.onDeleteOver(deleteBean);
            }
        });
    }
}
