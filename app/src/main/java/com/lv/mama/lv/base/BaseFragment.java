package com.lv.mama.lv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by 武晓瑞 on 2017/11/8.
 */

public abstract class BaseFragment extends Fragment {
    //public abstract BaseFragment newInstance(String tag,String url);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }
    public abstract void initData();
}
