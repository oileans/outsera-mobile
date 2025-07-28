package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import support.DriverFactory;

public class LoginPage {
    private AppiumDriver driver;

    By USERNAME = AppiumBy.accessibilityId("Username input field");
    By PASSWORD = AppiumBy.accessibilityId("Password input field");
    By LOGIN_BTN = AppiumBy.accessibilityId("Login button");

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void efetuaLogin(String login, String senha) {
        driver.findElement(USERNAME).sendKeys(login);
        driver.findElement(PASSWORD).sendKeys(senha);
        driver.findElement(LOGIN_BTN).click();
    }
}
