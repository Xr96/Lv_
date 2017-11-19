package com.lv.mama.lv.cart.model;

/**
 * Created by 武晓瑞 on 2017/11/18.
 */

public interface ImyModel {
    void getDatas(int uid);
    void updateCarts(int uid,int seller,int pid,int num,int selected);
    void delete(int uid,int pid);
}
