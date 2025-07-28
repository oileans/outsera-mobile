package support;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.Test;
import org.openqa.selenium.Capabilities;

import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static AndroidDriver driver;

    /**
     * Retorna o driver, criando‑o se necessário
     */
    public static AndroidDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    /**
     * Cria e configura o AndroidDriver para Appium 2.x
     */
    private static void createDriver() {
        try {
            Capabilities opt = new BaseOptions()
                    .amend("platformName", "Android")
                    .amend("appium:deviceName", "emulator-5554")
                    .amend("appium:automationName", "UiAutomator2")
                    .amend("appium:app", "C:\\Users\\Oileans\\Downloads\\Android-MyDemoAppRN.1.3.0.build-244.apk")
                    .amend("appium:appPackage", "com.saucelabs.mydemoapp.rn")
                    .amend("appium:appActivity", ".MainActivity")
                    .amend("appium:noReset", false)
                    .amend("appium:newCommandTimeout", 300)
                    .amend("appium:ensureWebviewsHavePages", true)
                    .amend("appium:nativeWebScreenshot", true)
                    .amend("appium:connectHardwareKeyboard", true);

            URL appiumUrl = new URL("http://127.0.0.1:4723");

            driver = new AndroidDriver(appiumUrl, opt);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            throw new RuntimeException("Falha ao iniciar AndroidDriver", e);
        }
    }

    /**
     * Encerra a sessão e zera o driver
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
