package com.example.liaotian.Fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liaotian.Bean.User;
import com.example.liaotian.R;
import com.example.liaotian.activity.MainActivity;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    //声明控件
    private EditText username,password;
    private TextView user,//注册账号
                     pass;//忘记密码

    private Button button ;
    private NavController controller;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        find();

    }
    /**
     * 绑定控件的方法
     */
    private void find() {
        username = getView().findViewById(R.id.username);
        password = getView().findViewById(R.id.password);
        user = getView().findViewById(R.id.textuser);
        pass = getView().findViewById(R.id.textpassword);
        button = getView().findViewById(R.id.login11);


        click();
    }
    /**
     * 设置点击事件的方法
     */
    //登录按钮点击
    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loging();
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_loginFragment_to_registerFragment);

            }
        });

    }
    /**
     * 登录的操作
     */
    private void loging() {
        User user = new User();
        //获得控件输入的内容  trim（）删除头尾空白的方法
        user.setUsername(username.getText().toString().trim());
        user.setPassword(password.getText().toString().trim());
        //判断如果登陆成功就跳转主页面
        user.login(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    Toast.makeText(getActivity(), "登陆成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), MainActivity.class));

                } else {
                    Toast.makeText(getActivity(), "登陆失败，请输入正确的账号密码！", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}
