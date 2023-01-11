package ScreenElements;

import General.TestBase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class  MainScreenElements extends TestBase {
    public MainScreenElements(AppiumDriver driver)  {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility="ic_ab_wallet")
    public MobileElement walletNavBar;
    @AndroidFindBy(id="ua.com.abank:id/ivCardSetting")
    public MobileElement CardSettingButton;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]")
    public MobileElement CardNumberField;

    @AndroidFindBy(id="ua.com.abank:id/ivAvatar")
    public MobileElement AvatarSettingsButton;

    @AndroidFindBy(id="ua.com.abank:id/thirdItem")
    public MobileElement DepositsButton;

    @Step("Переход в депозиты")
    public void goToDeposits() {
        DepositsButton.click();
    }
}

