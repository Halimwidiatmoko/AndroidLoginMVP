package com.firstapp.halimwidiatmoko.androidloginmvp.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    private String email,passwrord;

    public User(String email, String passwrord) {
        this.email = email;
        this.passwrord = passwrord;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return passwrord;
    }

    @Override
    public int isValidData() {
        //0.cek apakah email di isi
        //1. cek apakah email patern sesuai
        // 2. cek password <6

        if (TextUtils.isEmpty(getEmail())){
            return 0;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            return 1;
        }else if (getPassword().length() <= 6){
            return 2;
        }else
            return -1;

    }
}
