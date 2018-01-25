package com.sdkstudy;

import android.app.Application;
import com.sdk.library.SdkContext;

/**
 * Created by zhoujiaqi on 2018/1/24.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SdkContext.init(this);
    }
}
