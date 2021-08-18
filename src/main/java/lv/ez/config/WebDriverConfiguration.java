package lv.ez.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverConfiguration {

    public static void setupWebDriverConfiguration() {
        Configuration.remote = "http://127.0.0.1:4444/wd/hub";
        Configuration.browser = getBrowserProperty();
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    private static String getBrowserProperty() {
        return System.getProperty("BROWSER").toLowerCase();
    }

    public static boolean isLocalRun() {
        return Boolean.parseBoolean(System.getProperty("LOCAL_RUN"));
    }
}
