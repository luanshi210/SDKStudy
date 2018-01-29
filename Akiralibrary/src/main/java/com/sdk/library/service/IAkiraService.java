package com.sdk.library.service;

import com.sdk.library.response.ConnectResponse;
import com.sdk.library.response.UserResponse;

/**
 * Created by zhoujiaqi on 2018/1/24.
 */

public interface IAkiraService {

    void connect(String mac, ConnectResponse response);

    void getUser(UserResponse response);

}
