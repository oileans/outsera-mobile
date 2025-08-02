package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import support.DriverFactory;

public class CheckoutPage {
    private AppiumDriver driver;

    By CHECKOUT_TITLE = AppiumBy.accessibilityId("Username input field");
    By FULL_NAME = AppiumBy.accessibilityId("Full Name* input field");
    By ADRESS_LINE1 = AppiumBy.accessibilityId("Address Line 1* input field");
    By ADRESS_LINE2 = AppiumBy.accessibilityId("Address Line 2 input field");
    By CITY = AppiumBy.accessibilityId("City* input field");
    By STATE = AppiumBy.accessibilityId("State/Region input field");
    By ZIP_CODE = AppiumBy.accessibilityId("Zip Code* input field");
    By COUNTRY = AppiumBy.accessibilityId("Country* input field");
    By PAYMENT_BTN = AppiumBy.accessibilityId("To Payment button");


    public CheckoutPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void preencherFullName(String nome) {
        driver.findElement(FULL_NAME).sendKeys(nome);
    }

    public void preencherAddressLine1(String addr1) {
        driver.findElement(ADRESS_LINE1).sendKeys(addr1);
    }

    public void preencherAddressLine2(String addr2) {
        driver.findElement(ADRESS_LINE2).sendKeys(addr2);
    }

    public void preencherCity(String cidade) {
        driver.findElement(CITY).sendKeys(cidade);
    }

    public void preencherState(String estado) {
        driver.findElement(STATE).sendKeys(estado);
    }

    public void preencherZipCode(String cep) {
        driver.findElement(ZIP_CODE).sendKeys(cep);
    }

    public void preencherCountry(String pais) {
        driver.findElement(COUNTRY).sendKeys(pais);
    }

    public void clicarToPayment() {
        driver.findElement(PAYMENT_BTN).click();
    }

    public boolean validaPageCheckout() {
        driver.findElement(CHECKOUT_TITLE).isDisplayed();
        return true;
    }

    public void preencherFormulario(String nome,
                                    String addr1,
                                    String addr2,
                                    String cidade,
                                    String estado,
                                    String cep,
                                    String pais) {
        preencherFullName(nome);
        preencherAddressLine1(addr1);
        preencherAddressLine2(addr2);
        preencherCity(cidade);
        preencherState(estado);
        preencherZipCode(cep);
        preencherCountry(pais);
    }
}
