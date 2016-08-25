package com.tdd.nilesh.studentattendance.login;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nileshjarad on 02/08/16.
 */
public class LoginPresenterTest {

    @Test
    public void checkIfLoginAttemptIsExceeded() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }


    @Test
    public void checkIfLoginAttemptIsNotExceeded() {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded());
    }


    @Test
    public void checkUsernameAndPasswordIsCorrect()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("nj","tdd");
        verify(loginView).showLoginSuccessMessage();
    }

    @Test
    public void checkUsernameAndPasswordIsInCorrect()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz","tdd");
        verify(loginView).showErrorMessageForUserNamePassword();
    }

    @Test
    public void checkIfLoginAttemptIsExceededAndViewMethodCalled()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz","tdd");
        loginPresenter.doLogin("xyz","tdd");
        loginPresenter.doLogin("xyz","tdd");
        loginPresenter.doLogin("xyz","tdd");
        verify(loginView).showErrorMessageForMaxLoginAttempt();
    }
}