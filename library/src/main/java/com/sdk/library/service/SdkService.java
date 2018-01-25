package com.sdk.library.service;

import com.sdk.library.response.ConnectResponse;
import com.sdk.library.response.DisConnectResponse;

/**
 * Created by zhoujiaqi on 2018/1/24.
 */

public interface SdkService {

    void connect(String mac, ConnectResponse response);//连接

    void disconnect(String mac, DisConnectResponse response);//断开连接





}
