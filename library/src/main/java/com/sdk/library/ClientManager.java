package com.sdk.library;

import com.sdk.library.proxy.TransactionHandler;
import com.sdk.library.service.SdkImpl;
import com.sdk.library.service.SdkService;

/**
 *
 * Created by zhoujiaqi on 2018/1/24.
 */

public class ClientManager {

    private static SdkService instance;

    public static SdkService getInstance() {
        if (instance == null) {
            synchronized (ClientManager.class) {
                if (instance == null) {
                    SdkService service = new SdkImpl();
                    instance = (SdkService) new TransactionHandler().getInstance(service);
                }
            }
        }
        return instance;
    }


}
