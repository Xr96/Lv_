package com.lv.mama.lv.kind.view;

import com.lv.mama.lv.kind.bean.DataleftBean;
import com.lv.mama.lv.kind.bean.DatarightBean;

import java.util.List;

/**
 * Created by 武晓瑞 on 2017/11/14.
 */

public interface Kview {
    void getKdata(List<DataleftBean.DatasBean.ClassListBean> class_list);
    void getKdatas(List<DatarightBean.DatasBean.ClassListBean> class_list);
//    void getServerData();
}
