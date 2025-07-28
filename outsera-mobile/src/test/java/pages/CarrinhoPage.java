package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import support.DriverFactory;

public class CarrinhoPage {
    private AppiumDriver driver;

    By MINI_CART_PAGE = By.xpath("//android.widget.TextView[@text=\"My Cart\"]");
    By MINI_CART = By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]");
    By ADD_TO_CART = By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]");

    public CarrinhoPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void acessarMiniCart() {
        driver.findElement(MINI_CART).click();
    }

    public void validaMinicart() {
        driver.findElement(MINI_CART_PAGE).isDisplayed();
    }

    public void addToCart() {
        driver.findElement(ADD_TO_CART).click();
    }

    public void proceedCheckout() {
        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiSelector().textContains(\"Proceed To Checkout\")"
                )
        ).click();
    }

}
