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
     * Cria e configura o AndroidDriver para execução no Sauce Labs
     */
    private static void createDriver() {
        try {
//            String username = System.getenv("SAUCE_USERNAME");
//            String accessKey = System.getenv("SAUCE_ACCESS_KEY");


            String username = "oauth-5drzi8h8-105bb";
            String accessKey = "2a736532-d041-4fe0-adc6-cee95ef93155";

            if (username == null || accessKey == null) {
                throw new RuntimeException("SAUCE_USERNAME ou SAUCE_ACCESS_KEY não definidos nas variáveis de ambiente.");
            }

            // APK remoto no Sauce Storage
            String app = "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk";

            // URL remota do Sauce Labs
            String sauceUrl = String.format("https://%s:%s@ondemand.us-west-1.saucelabs.com:443/wd/hub", username, accessKey);

            Capabilities capabilities = new BaseOptions().amend("platformName", "Android").amend("appium:deviceName", "Google Pixel 5 GoogleAPI Emulator").amend("appium:platformVersion", "11.0").amend("appium:app", app).amend("appium:automationName", "UiAutomator2").amend("appium:noReset", false).amend("appium:newCommandTimeout", 300).amend("sauce:options", new java.util.HashMap<String, Object>() {{
                put("name", "Mobile Test - Appium Sauce Labs");
                put("build", "Build-01");
            }});

            driver = new AndroidDriver(new URL(sauceUrl), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            throw new RuntimeException("Falha ao iniciar AndroidDriver no Sauce Labs", e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
