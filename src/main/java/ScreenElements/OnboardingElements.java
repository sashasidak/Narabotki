package ScreenElements;

import General.TestBase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnboardingElements extends TestBase {
    public OnboardingElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(iOSNsPredicate="type == \"XCUIElementTypeTextField\"")
    public MobileElement phoneNumberField;

    @iOSXCUITFindBy(accessibility="3")
    public MobileElement TwoPinButton;

    @iOSXCUITFindBy(accessibility="8")
    public MobileElement FivePinButton;

    @iOSXCUITFindBy(accessibility="1")
    public MobileElement EightPinButton;

    @iOSXCUITFindBy(accessibility="4")
    public MobileElement ZeroPinButton;

    @iOSXCUITFindBy(accessibility="7")
    public MobileElement FirstOtpNumber;

    @iOSXCUITFindBy(accessibility="1")
    public MobileElement SecondOtpNumber;

    @iOSXCUITFindBy(accessibility="7")
    public MobileElement ThirdOtpNumber;

    @iOSXCUITFindBy(accessibility="2")
    public MobileElement FourthOtpNumber;

    @iOSXCUITFindBy(id="ua.com.abank:id/btnNext")
    public MobileElement nextButton;

    @iOSXCUITFindBy(accessibility="Ваш номер телефону")
    public MobileElement titleEnterPhone;

    @iOSXCUITFindBy(xpath="(//XCUIElementTypeButton[@name=\"Далі\"])[2]")
    public MobileElement nextButtonOnTheKeyboard;

}
