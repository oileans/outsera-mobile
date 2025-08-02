package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import support.DriverFactory;

public class SuccessPage {
    private AppiumDriver driver;

    By PLACE_ORDER = AppiumBy.accessibilityId("Place Order button");
    By SUCCESS_PAGE = AppiumBy.xpath("//android.widget.TextView[@text=\"Thank you for your order\"]");

    public SuccessPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void placeOrder() {
        driver.findElement(PLACE_ORDER).click();
    }

    public void validarSuccessPage() {
        driver.findElement(SUCCESS_PAGE).isDisplayed();
    }
}
