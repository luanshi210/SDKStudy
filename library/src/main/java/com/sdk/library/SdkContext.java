package com.sdk.library;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by zhoujiaqi on 2018/1/24.
 */

public class SdkContext {

    private static Context mContext;
    private static Handler mHandler;

    public static void set(Context context) {
        mContext = context;
    }

    public static Context get() {
        return mContext;
    }

    public static void post(Runnable runnable) {
        postDelayed(runnable, 0);
    }

    public static void postDelayed(Runnable runnable, long delayInMillis) {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
        mHandler.postDelayed(runnable, delayInMillis);
    }

    public static String getCurrentMethodName() {
        StackTraceElement e = Thread.currentThread().getStackTrace()[4];
        return e.getMethodName();
    }
}
