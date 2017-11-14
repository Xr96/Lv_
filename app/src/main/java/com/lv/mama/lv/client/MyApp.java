package com.lv.mama.lv.client;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class MyApp extends Application {
    public static Context context;
    public static MyApp mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        if (context == null){
            context=this;
        }
        ImageLoaderConfiguration aDefault = new ImageLoaderConfiguration.Builder(this)
                .memoryCache(new WeakMemoryCache())
                .memoryCacheSizePercentage(60)
                .build();
        ImageLoader.getInstance().init(aDefault);
        mInstance = this;
        Fresco.initialize(this);

    }
    public static MyApp getInstance() {
        return mInstance;
    }
}
