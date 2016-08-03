package com.tdd.nilesh.studentattendance.login;

/**
 * Created by nileshjarad on 28/07/16.
 */

public class LoginPresenter {

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private int loginAttempt;


    public int incrementLoginAttempt() {
        loginAttempt = loginAttempt + 1;
        return loginAttempt;
    }

    public boolean isLoginAttemptExceeded() {
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }


    public boolean isLoginSuccess(String userName, String password) {
        if (isLoginAttemptExceeded()) {
            return false;
        }

        if (userName.equals("nilesh") && password.equals("tdd")) {
            return true;
        }
        // increment login attempt if it's fail
        incrementLoginAttempt();
        return false;
    }
}






