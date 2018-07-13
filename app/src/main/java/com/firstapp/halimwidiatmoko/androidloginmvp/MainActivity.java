package com.firstapp.halimwidiatmoko.androidloginmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firstapp.halimwidiatmoko.androidloginmvp.Presenter.ILoginPresenter;
import com.firstapp.halimwidiatmoko.androidloginmvp.Presenter.LoginPresenter;
import com.firstapp.halimwidiatmoko.androidloginmvp.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView{

    EditText edtEmail,edtPassword;
    Button btnLogin;

    ILoginPresenter loginPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        loginPersenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPersenter.onLogin(edtEmail.getText().toString(), edtPassword.getText().toString());
            }
        });

    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this,message, Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message, Toast.LENGTH_SHORT ).show();

    }
}
