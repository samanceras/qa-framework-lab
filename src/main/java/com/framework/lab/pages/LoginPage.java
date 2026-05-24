package com.framework.lab.pages;

import com.framework.lab.base.BasePage;
import com.framework.lab.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    private static final String LOGIN_PATH = "/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        openUrl(ConfigReader.getBaseUrl()+LOGIN_PATH);
    }

    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getFlashMessage() {
        return find(flashMessage).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}