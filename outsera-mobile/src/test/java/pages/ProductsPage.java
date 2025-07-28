package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import support.DriverFactory;

public class ProductsPage {
    private AppiumDriver driver;

    By PRODUCTS_LIST = By.xpath("//android.widget.TextView[@text=\"Products\"]");

    public ProductsPage() {
        this.driver = DriverFactory.getDriver();
    }

    public boolean validaProduct() {
        driver.findElement(PRODUCTS_LIST).isDisplayed();
        return true;
    }

    public void selecionaProdutoPorNome(String nomeProduto) {
        String xpath = "//android.widget.TextView[@text='" + nomeProduto + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

}
