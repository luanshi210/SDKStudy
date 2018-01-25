package com.sdk.library;

import android.content.Context;
import android.os.Handler;

/**
 * Created by zhoujiaqi on 2018/1/24.
 */

public class SdkContext {

    private static Context mContext;
    private static Handler mHandler;

    public static void init(Context context) {
        mContext = context;
    }

    public static Context get() {
        return mContext;
    }


}
