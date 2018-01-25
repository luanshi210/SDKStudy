package com.sdkstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sdk.library.Akira;
import com.sdk.library.Utils.LogUtils;
import com.sdk.library.model.UserModel;
import com.sdk.library.response.ConnectResponse;
import com.sdk.library.response.UserResponse;

public class MainActivity extends AppCompatActivity {

    private Button btn_connect;
    private Button btn_getuser;
    private TextView tv_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        btn_connect  = findViewById(R.id.btn_connect);
        btn_getuser = findViewById(R.id.btn_getuser);
        tv_detail = findViewById(R.id.tv_detail);


        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Akira.getInstance().connect("mac", new ConnectResponse() {
                    @Override
                    public void onResponse(int code, Boolean data) {
                        LogUtils.e(data+"");
                        tv_detail.setText(data+"");
                    }
                });

            }
        });



        btn_getuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Akira.getInstance().getUser(new UserResponse() {
                    @Override
                    public void onResponse(int code, UserModel data) {
                        LogUtils.e(data.toString()+"");
                        tv_detail.setText(data.toString());
                    }
                });

            }
        });








    }
}
