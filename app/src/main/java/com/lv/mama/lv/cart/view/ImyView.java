package com.lv.mama.lv.cart.view;

import com.lv.mama.lv.cart.bean.CartBean;
import com.lv.mama.lv.cart.bean.DeleteBean;
import com.lv.mama.lv.cart.bean.UpdateBean;

/**
 * Created by 武晓瑞 on 2017/11/18.
 */

public interface ImyView {
    void onDataOver(CartBean cartBean);
    void onUpdateOver(UpdateBean updateBean);
    void onDeleteOver(DeleteBean deleteBean);
}
