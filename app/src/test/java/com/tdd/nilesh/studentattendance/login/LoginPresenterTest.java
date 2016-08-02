package com.tdd.nilesh.studentattendance.login;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nileshjarad on 02/08/16.
 */
public class LoginPresenterTest {

    @Test
    public void checkIfLoginAttemptIsExceeded() {
        LoginPresenter loginPresenter = new LoginPresenter();
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }

}