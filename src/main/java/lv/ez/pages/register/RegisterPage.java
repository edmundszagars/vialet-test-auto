package lv.ez.pages.register;

import com.codeborne.selenide.SelenideElement;
import lv.ez.pages.Page;
import lv.ez.pages.register.components.PrepareIdPopUp;
import lv.ez.util.TestDataReader;
import lv.ez.util.dto.FormFirstStepDto;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage extends Page {

    @FindBy(css = "div.registration-wrap > div:nth-child(2) > div:nth-child(3) > input")
    private SelenideElement nameTextField;

    @FindBy(css = "div.registration-wrap > div:nth-child(2) > div:nth-child(4) > input")
    private SelenideElement surnameTextField;

    @FindBy(css = "div.registration-wrap > div:nth-child(2) > div:nth-child(5) > input")
    private SelenideElement peselCodeTextField;

    @FindBy(css = "div.registration-wrap > div:nth-child(2) > div:nth-child(6) > input")
    private SelenideElement emailTextField;

    @FindBy(css = "div.registration-wrap > div:nth-child(2) > div.npt-block.can-have-loader > div.phone-row > input.input.phone-field")
    private SelenideElement phoneNrTextField;

    @FindBy(id = "name-error")
    private SelenideElement nameErrorField;

    @FindBy(id = "surname-error")
    private SelenideElement surnameErrorField;

    @FindBy(id = "pesel-error")
    private SelenideElement peselCodeErrorField;

    @FindBy(id = "email-error")
    private SelenideElement emailErrorField;

    @FindBy(id = "phone-error")
    private SelenideElement phoneNrErrorField;

    private final TestDataReader userDataReader = new TestDataReader("testdata/first_form.json");
    private final PrepareIdPopUp prepareIdPopUp = page(PrepareIdPopUp.class);

    public void prepareIdPopUpIsDisplayed() {
        prepareIdPopUp.isDisplayed();
        prepareIdPopUp.close();
    }

    public void verifyAllErrorMessagesAreDisplayed() {
        nameErrorField.shouldBe(visible);
        surnameErrorField.shouldBe(visible);
        peselCodeErrorField.shouldBe(visible);
        emailErrorField.shouldBe(visible);
        phoneNrErrorField.shouldBe(visible);
    }

    public void verifyAllErrorMessagesAreNotDisplayed() {
        nameErrorField.shouldBe(hidden);
        surnameErrorField.shouldBe(hidden);
        peselCodeErrorField.shouldBe(hidden);
        emailErrorField.shouldBe(hidden);
        phoneNrErrorField.shouldBe(hidden);
    }

    public void populateFormWithData(String form) {
        FormFirstStepDto formFirstStepDto = userDataReader.findFirstStepForm(form);
        switch (form) {
            case "VALID":
                setValuesForFirstPageForm(formFirstStepDto);
                break;
            case "INVALID":
                setValuesForFirstPageForm(formFirstStepDto);
                clearName();
                clearSurname();
                break;
        }
    }

    private void setValuesForFirstPageForm(FormFirstStepDto formFirstStepDto) {
        nameTextField.setValue(formFirstStepDto.getFirstName());
        surnameTextField.setValue(formFirstStepDto.getLastName());
        peselCodeTextField.setValue(formFirstStepDto.getPeselCode());
        emailTextField.setValue(formFirstStepDto.getEmail());
        phoneNrTextField.setValue(formFirstStepDto.getPhoneNr());
    }

    private void clearName() {
        nameTextField.sendKeys(Keys.CONTROL, "a");
        nameTextField.sendKeys(Keys.DELETE);
    }

    private void clearSurname() {
        surnameTextField.sendKeys(Keys.CONTROL, "a");
        surnameTextField.sendKeys(Keys.DELETE);
    }

    @Override
    public void openPage() {
        open(BASE_URL + "/register");
    }
}
