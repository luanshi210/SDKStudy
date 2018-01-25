package com.sdk.library;

import com.sdk.library.proxy.TransactionHandler;
import com.sdk.library.service.SdkImpl;
import com.sdk.library.service.SdkService;

/**
 *
 * Created by zhoujiaqi on 2018/1/24.
 */

public class ClientManager {

    private static SdkService mClient;

    public static SdkService getClient() {
        if (mClient == null) {
            synchronized (ClientManager.class) {
                if (mClient == null) {
                    SdkService service = new SdkImpl();
                    mClient = (SdkService) new TransactionHandler().getInstance(service);
                }
            }
        }
        return mClient;
    }


}
