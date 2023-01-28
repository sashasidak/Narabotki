package AllureTests;

import General.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class UserSettingsTest extends TestBase {

    @Test(description="Переход в настройки пользователя")
    public void goToUserSettings() throws MalformedURLException {
        reAuth();
        mainScreenElements.openUserSettings();
    }

    @Test(description="Кнопка \"Помощь\" в меню профиль, в меню персональные данные, и в меню тарифы и правила")
    public void checkHelpButton() throws IOException, InterruptedException {
        reAuth();
        mainScreenElements.openUserSettings();
        userSettingsPage.checkHelpButton();
        userSettingsPage.pressBack();
        userSettingsPage.goToPersonalData();
        userSettingsPage.checkHelpButton();
        userSettingsPage.pressBack();
        userSettingsPage.pressBack();
        userSettingsPage.goToRate();
        userSettingsPage.checkHelpButton();
        vrtHelper.track("Скрин элементов профиля");
    }

}