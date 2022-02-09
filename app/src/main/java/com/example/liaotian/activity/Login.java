package com.example.liaotian.activity;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.example.liaotian.R;




/**
 * 登录界面
 */
public class Login extends AppCompatActivity {
    private NavController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        controller = Navigation.findNavController(this,R.id.fragment);

    }

    /**
     * 在该activity进入onPause状态时结束它
     */
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    /**
     * 判断当前fragment是否为loginFragment如果是按返回键直接退出程序
     *如果不是就正常返回上一个页面
     */
    @Override
    public void onBackPressed() {
        if (controller.getCurrentDestination().getId()  == R.id.loginFragment){
            finish();

        }else {

            super.onBackPressed();
        }

    }

}
