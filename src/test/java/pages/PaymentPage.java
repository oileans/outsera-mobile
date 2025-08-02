package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import support.DriverFactory;

public class PaymentPage {
    private AppiumDriver driver;


    By FULL_NAME = AppiumBy.accessibilityId("Full Name* input field");
    By CC = AppiumBy.accessibilityId("Card Number* input field");
    By ED = AppiumBy.accessibilityId("Expiration Date* input field");
    By CVV = AppiumBy.accessibilityId("Security Code* input field");
    By CHECKOUT_HEADER = AppiumBy.accessibilityId("container header");
    By BTN_REVIEW_ORDER = AppiumBy.accessibilityId("Review Order button");


    public PaymentPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void preencherFullName(String nome) {
        driver.findElement(FULL_NAME).sendKeys(nome);
    }

    public void preencherNumeroCartao(String cc) {
        driver.findElement(CC).sendKeys(cc);
    }

    public void preencherCVV(String cvv) {
        driver.findElement(CVV).sendKeys(cvv);
    }

    public void preencherED(String ed) {
        driver.findElement(ED).sendKeys(ed);
    }

    public void clickConfirmOrder() {
        driver.findElement(BTN_REVIEW_ORDER).click();
    }

    public boolean conferirPedido() {
        driver.findElement(CHECKOUT_HEADER).isDisplayed();
        return true;
    }


    public void preencherDadosPagamento(String nome,
                                        String cc,
                                        String ed,
                                        String cvv

    ) {
        preencherNumeroCartao(cc);
        preencherED(ed);
        preencherCVV(cvv);
        preencherFullName(nome);

    }

}
