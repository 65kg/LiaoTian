package com.example.liaotian.Bean;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {
    private String nickname;//昵称

    public void setNickName(String nickname) {
        this.nickname = nickname;
    }

    public String getNickName() {
        return nickname;
    }
}
