package UserSettingsElements;

import General.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class UserSettingsPage extends TestBase {

    public UserSettingsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility="Персональні дані")
    public MobileElement personalDataButton;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"Підтримка\"`]")
    public MobileElement helpButton;

    @iOSXCUITFindBy(xpath="//*[contains(@name, 'Канал комунікації:')]")
    public MobileElement communicationScreenText;

    @iOSXCUITFindBy(accessibility="ic back main")
    public MobileElement backButton;
    @iOSXCUITFindBy(accessibility="Електронна адреса")
    public MobileElement emailAddress;

    @iOSXCUITFindBy(accessibility="Тарифи та правила")
    public MobileElement rateButton;

    @Step("Переход в депозиты")
    public void checkPersonalDataButtonDisplayed()  {
        personalDataButton.isDisplayed();
    }

    @Step("Проверка отображения кнопки Помощь в профиле клиента")
    public void checkHelpButton()  {
        helpButton.isDisplayed();
        helpButton.click();
        communicationScreenText.isDisplayed();
    }

    @Step("Проверка отображения кнопки Помощь в профиле клиента")
    public void pressBack()  {
        backButton.click();
    }

    @Step("Переход в персональные данные")
    public void goToPersonalData()  {
        personalDataButton.isDisplayed();
        personalDataButton.click();
        emailAddress.isDisplayed();
    }

    @Step("Переход в персональные данные")
    public void goToRate()  {
        rateButton.isDisplayed();
        rateButton.click();
    }

}
