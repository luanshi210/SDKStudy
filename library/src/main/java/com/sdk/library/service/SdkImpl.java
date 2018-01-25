package com.sdk.library.service;

import com.sdk.library.Utils.LogUtils;
import com.sdk.library.model.UserModel;
import com.sdk.library.response.ConnectResponse;
import com.sdk.library.response.DisConnectResponse;

/**
 * SDK接口实现类
 * Created by zhoujiaqi on 2018/1/24.
 */

public class SdkImpl implements SdkService {


    @Override
    public void connect(String mac, ConnectResponse response) {
        LogUtils.v(String.format("connect %s", mac));
        response.onResponse(0,mac);
    }

    @Override
    public void disconnect(String mac, DisConnectResponse response) {
        LogUtils.v(String.format("disconnect %s", mac));
        UserModel userModel = new UserModel();
        userModel.setAge(10);
        userModel.setUid(10001);
        userModel.setName("仙道彰");
        response.onResponse(0,userModel);
    }



}
