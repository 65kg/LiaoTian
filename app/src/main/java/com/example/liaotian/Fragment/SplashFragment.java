package com.example.liaotian.Fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liaotian.R;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.BmobUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {
    private NavController controller;

    public SplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Timer tm = new Timer();
        tm.schedule(timetast,2000);

    }

    TimerTask timetast = new TimerTask() {
        @Override
        public void run() {

            BmobUser bmobUser = BmobUser.getCurrentUser(BmobUser.class);
            if (bmobUser != null){
                controller = Navigation.findNavController(getView());
                controller.navigate(R.id.action_splashFragment_to_mainActivity);

            }else {
               controller = Navigation.findNavController(getView());
               controller.navigate(R.id.action_splashFragment_to_loginFragment);
            }
        }
    };
}
