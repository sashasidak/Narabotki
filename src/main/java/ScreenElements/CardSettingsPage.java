package ScreenElements;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CardSettingsPage {
    public CardSettingsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath="//*[@text='Reissue of the card']")
    public MobileElement ReissueCardButton;

    @AndroidFindBy(id="ua.com.abank:id/tvCardNumber")
    public MobileElement CardNumberField;
}
