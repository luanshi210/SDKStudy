package com.sdk.library.response.base;

/**
 * Created by zhoujiaqi on 2018/1/24.
 */

public interface TResponse<T> {
    void onResponse(int code, T data);

}
