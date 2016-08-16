package com.tdd.nilesh.studentattendance.login;

/**
 * Created by nileshjarad on 04/08/16.
 */
public interface LoginView {
    void showErrorMessageForUserNamePassword();

    void showErrorMessageForMaxLoginAttempt();

    void showLoginSuccessMessage();
}
