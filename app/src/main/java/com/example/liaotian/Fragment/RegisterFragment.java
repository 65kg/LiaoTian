package com.example.liaotian.Fragment;


import android.os.Bundle;

import androidx.annotation.NavigationRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liaotian.Bean.User;
import com.example.liaotian.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 注册账号的页面
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private EditText usename,password,nikename;
    private Button register;
    private NavController controller;



    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);

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
        usename = getView().findViewById(R.id.username);
        password = getView().findViewById(R.id.password);
        nikename = getView().findViewById(R.id.password2);
        register = getView().findViewById(R.id.register);
        click();
    }

    /**
     * 点击事件的方法
     *
     */
    private void click() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                User user = new User();
                user.setUsername(usename.getText().toString());
                user.setPassword(password.getText().toString());
                user.setNickName(nikename.getText().toString());
                if (usename.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "请输入账号", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "请输入密码", Toast.LENGTH_SHORT).show();
                }else if (nikename.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "请输入昵称", Toast.LENGTH_SHORT).show();
                }else {
                    user.signUp(new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                                if (e == null){
                                    Toast.makeText(getActivity(), "注册成功！", Toast.LENGTH_SHORT).show();
                                    controller = Navigation.findNavController(view);
                                    controller.navigate(R.id.action_registerFragment_to_loginFragment);
                                }else {
                                    Toast.makeText(getActivity(), "注册失败！", Toast.LENGTH_SHORT).show();

                                }
                        }
                    });
                }
            }
        });

    }
}
