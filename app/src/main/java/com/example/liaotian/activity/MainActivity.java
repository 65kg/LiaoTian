package com.example.liaotian.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.liaotian.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * 主页面
 */

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     *组件的绑定及装配的方法
     */
    private void initView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,R.id.fragment3);
        //获取顶部标题栏的显示，这里获取了底部菜单的menu
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(bottomNavigationView.getMenu()).build();
        //装配顶部UI显示
        NavigationUI.setupActionBarWithNavController(this,navController,configuration);
        //装配页面UI
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }


}
