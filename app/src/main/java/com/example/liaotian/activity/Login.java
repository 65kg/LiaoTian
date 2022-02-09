package com.example.liaotian.activity;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.liaotian.R;

import cn.bmob.v3.Bmob;


/**
 * 登录界面
 */
public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Bmob.initialize(this,"320a371a14fd5a1f1820feeeeb04e264");//注册bmob

    }

    @Override
    public void onBackPressed() {
        bankTask();
    }

    private void bankTask() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 3){
            onDestroy();
        }else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
