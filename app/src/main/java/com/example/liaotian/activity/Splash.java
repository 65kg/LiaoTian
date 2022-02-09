package com.example.liaotian.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;

import com.example.liaotian.R;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

/**
 * 欢迎页面
 */
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Bmob.initialize(this,"320a371a14fd5a1f1820feeeeb04e264");//注册bmob
        Timer tm = new Timer();
        tm.schedule(timetast,2000);
    }

    /**
     * 定义一个两秒的欢迎页面，之后判断是否登录账号
     * 如果有已经登录的就直接进入主页
     * 没有就进入登录页面
     */
    TimerTask timetast = new TimerTask() {
        @Override
        public void run() {

            BmobUser bmobUser = BmobUser.getCurrentUser(BmobUser.class);
            if (bmobUser != null){
               startActivity(new Intent(Splash.this,MainActivity.class));

            }else {
                startActivity(new Intent(Splash.this,Login.class));
            }
            finish();
        }
    };
}
