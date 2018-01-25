package com.sdk.library;

import com.sdk.library.proxy.TransactionHandler;
import com.sdk.library.impl.AkiraImpl;
import com.sdk.library.service.IAkiraService;

/**
 *
 * Created by zhoujiaqi on 2018/1/24.
 */

public class Akira {

    private static IAkiraService instance;

    public static IAkiraService getInstance() {
        if (instance == null) {
            synchronized (Akira.class) {
                if (instance == null) {
                    IAkiraService service = new AkiraImpl();
                    instance = (IAkiraService) new TransactionHandler().getInstance(service);
                }
            }
        }
        return instance;
    }


}
