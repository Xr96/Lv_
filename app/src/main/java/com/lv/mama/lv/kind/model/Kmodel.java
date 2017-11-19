package com.lv.mama.lv.kind.model;

import java.util.Map;

/**
 * Created by 武晓瑞 on 2017/11/14.
 */

public interface Kmodel {
    void getKind(String url);
    void getKindrig(Map<String,String> msp, String url);
    void getXqy(String url,Map<String,String> map);
    void getXqdAta(Map<String,String> msp,String url);
    void getAddData(Map<String,String> map,String url);
}
