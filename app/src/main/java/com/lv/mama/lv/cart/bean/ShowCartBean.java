package com.lv.mama.lv.cart.bean;

import java.util.List;

/**
 * Created by 武晓瑞 on 2017/11/18.
 */

public class ShowCartBean {
    private String sellerName;
    private String sellerid;
    private int selected;
    private List<CartBean.DataBean.GoodBean> list;

    public ShowCartBean(String sellerName, String sellerid, int selected, List<CartBean.DataBean.GoodBean> list) {
        this.sellerName = sellerName;
        this.sellerid = sellerid;
        this.selected = selected;
        this.list = list;
    }

    public ShowCartBean() {
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public List<CartBean.DataBean.GoodBean> getList() {
        return list;
    }

    public void setList(List<CartBean.DataBean.GoodBean> list) {
        this.list = list;
    }
}
