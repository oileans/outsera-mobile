package support;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
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
            // Caminho flexível do APK
            String apkPath = System.getProperty("user.dir") + "/src/test/resources/app/Android-MyDemoAppRN.1.3.0.build-244.apk";

            // URL do Appium Server
            String appiumServerUrl = System.getProperty("appium.server", "http://127.0.0.1:4723");

            Capabilities opt = new BaseOptions()
                    .amend("platformName", "Android")
                    .amend("appium:deviceName", "emulator-5554")
                    .amend("appium:automationName", "UiAutomator2")
                    .amend("appium:app", apkPath)
                    .amend("appium:appPackage", "com.saucelabs.mydemoapp.rn")
                    .amend("appium:appActivity", ".MainActivity")
                    .amend("appium:noReset", false)
                    .amend("appium:newCommandTimeout", 300)
                    .amend("appium:ensureWebviewsHavePages", true)
                    .amend("appium:nativeWebScreenshot", true)
                    .amend("appium:connectHardwareKeyboard", true);

            driver = new AndroidDriver(new URL(appiumServerUrl), opt);
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
