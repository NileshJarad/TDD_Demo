package com.tdd.nilesh.studentattendance.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.tdd.nilesh.studentattendance.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializePresenter();
        initializeViews();
    }


    private void initializePresenter() {
        loginPresenter = new LoginPresenter(this);
    }

    private void initializeViews() {
        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin(edtUserName.getText().toString().trim(),
                        edtPassword.getText().toString().trim());
            }
        });
    }

    @Override
    public void showErrorMessageForUserNamePassword() {
        Snackbar.make(edtPassword, "Please check Username or Password.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessageForMaxLoginAttempt() {
        Snackbar.make(btnLogin, "You have exceeded MAX attempt.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginSuccessMessage() {
        Snackbar.make(btnLogin, "Login successful.", Snackbar.LENGTH_LONG).show();
    }
}

