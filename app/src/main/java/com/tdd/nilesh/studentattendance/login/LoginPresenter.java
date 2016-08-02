package com.tdd.nilesh.studentattendance.login;

/**
 * Created by nileshjarad on 28/07/16.
 */

public class LoginPresenter {

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private int loginAttempt;

    public boolean isLoginAttemptExceeded() {
        return loginAttempt<MAX_LOGIN_ATTEMPT;
    }
}