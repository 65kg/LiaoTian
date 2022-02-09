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

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Bmob.initialize(this,"320a371a14fd5a1f1820feeeeb04e264");//注册bmob
        Timer tm = new Timer();
        tm.schedule(timetast,2000);
    }
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
