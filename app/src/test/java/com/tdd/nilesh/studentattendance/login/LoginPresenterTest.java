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
        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }


    @Test
    public void checkIfLoginAttemptIsNotExceeded() {
        LoginPresenter loginPresenter = new LoginPresenter();
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded());
    }


    @Test
    public void checkUsernameAndPasswordIsCorrect()
    {

    }

    @Test
    public void checkUsernameAndPasswordIsInCorrect()
    {

    }
}