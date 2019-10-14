package com.tdd.nilesh.studentattendance.login;

/**
 * Created by nileshjarad on 28/07/16.
 */

class LoginPresenter {

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private final LoginView loginView;
    private int loginAttempt;

    LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    int incrementLoginAttempt() {
        loginAttempt = loginAttempt + 1;
        return loginAttempt;
    }

    private void resetLoginAttempt() {
        loginAttempt = 0;
    }

    boolean isLoginAttemptExceeded() {
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }


    void doLogin(String userName, String password) {
        if (isLoginAttemptExceeded()) {
            loginView.showErrorMessageForMaxLoginAttempt();
            return;
        }

        if (userName.equals("nj") && password.equals("tdd")) {
            loginView.showLoginSuccessMessage();
            resetLoginAttempt();
            return;
        }

        // increment login attempt only if it's fail
        incrementLoginAttempt();
        loginView.showErrorMessageForUserNamePassword();
    }
}






