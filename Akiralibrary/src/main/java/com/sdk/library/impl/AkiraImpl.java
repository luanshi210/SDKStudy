package com.sdk.library.impl;

import com.sdk.library.Utils.LogUtils;
import com.sdk.library.model.UserModel;
import com.sdk.library.response.ConnectResponse;
import com.sdk.library.response.UserResponse;
import com.sdk.library.service.IAkiraService;

/**
 * Created by zhoujiaqi on 2018/1/24.
 */

public class AkiraImpl implements IAkiraService {

    @Override
    public void connect(String mac, ConnectResponse response) {
        LogUtils.v(String.format("connect %s", mac));
        response.onResponse(0,true);
    }

    @Override
    public void getUser(UserResponse response) {
        LogUtils.v("disconnect");
        UserModel userModel = new UserModel();
        userModel.setAge(10);
        userModel.setUid(10001);
        userModel.setName("XianDaoZhang");
        response.onResponse(0,userModel);
    }

}
