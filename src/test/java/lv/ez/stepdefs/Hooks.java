package lv.ez.stepdefs;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lv.ez.config.WebDriverConfiguration;
import org.openqa.selenium.OutputType;

import java.util.Base64;

public class Hooks {

    @Before
    public void setupWebDriver() {
        if (!WebDriverConfiguration.isLocalRun()) {
            WebDriverConfiguration.setupWebDriverConfiguration();
        }
    }

    @After
    public void closeDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
            byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
            scenario.attach(decoded, "image/png", "Screenshot");
        }
        Selenide.closeWebDriver();
    }
}
