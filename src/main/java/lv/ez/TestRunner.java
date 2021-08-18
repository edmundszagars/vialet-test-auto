package lv.ez;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lv.ez.config.WebDriverConfiguration;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/report/", "json:target/cucumber.json", "rerun:target/rerun.txt"},
        features = {"src/test/resources/features"},
        glue = "src/test/java/stepdefs"
)
public class TestRunner {
    @BeforeClass
    public static void setup() {
        WebDriverConfiguration.setupWebDriverConfiguration();
    }
}