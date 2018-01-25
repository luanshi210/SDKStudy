package com.sdkstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sdk.library.ClientManager;
import com.sdk.library.Utils.LogUtils;
import com.sdk.library.model.UserModel;
import com.sdk.library.response.ConnectResponse;
import com.sdk.library.response.DisConnectResponse;

public class FullscreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);


        ClientManager.getClient().connect("mac", new ConnectResponse() {
            @Override
            public void onResponse(int code, String data) {
                LogUtils.e(data+"");
            }
        });


        ClientManager.getClient().disconnect("mac", new DisConnectResponse() {
            @Override
            public void onResponse(int code, UserModel data) {
                LogUtils.e(data.toString()+"");
            }
        });


    }
}
