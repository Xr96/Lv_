package com.lv.mama.lv.cart.bean;


/**
 * Created by 武晓瑞 on 2017/11/18.
 */

public class DeleteBean {
    /*
    * 删除购物车成功
    * */
    private String msg;
    private String code;

    public DeleteBean(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
