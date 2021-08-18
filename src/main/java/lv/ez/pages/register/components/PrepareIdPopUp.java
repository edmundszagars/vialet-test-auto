package lv.ez.pages.register.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class PrepareIdPopUp {

    @FindBy(id = "modal-ready-popup")
    private SelenideElement prepIdPopUp;

    @FindBy(id = "close-ready-popup")
    private SelenideElement closeButton;

    public void isDisplayed() {
        prepIdPopUp.shouldBe(visible);
    }

    public void close() {
        closeButton.shouldBe(visible, Duration.ofSeconds(5))
                .click();
    }
}
