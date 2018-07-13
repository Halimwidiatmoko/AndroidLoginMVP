package com.firstapp.halimwidiatmoko.androidloginmvp.Presenter;

import com.firstapp.halimwidiatmoko.androidloginmvp.Model.User;
import com.firstapp.halimwidiatmoko.androidloginmvp.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        if (loginCode == 0) {
            loginView.onLoginError("you must enter your Email");
        } else if (loginCode == 1) {
            loginView.onLoginError("your format email incorrect");
        } else if (loginCode == 2) {
            loginView.onLoginError("password must greater than 6");
        } else {
            loginView.onLoginSuccess("you login success");
        }
    }
}
