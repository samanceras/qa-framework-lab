package com.framework.lab.tests;

import com.framework.lab.base.BaseTest;
import com.framework.lab.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
        Assert.assertTrue(loginPage.getCurrentUrl().contains("/secure"));
    }
}