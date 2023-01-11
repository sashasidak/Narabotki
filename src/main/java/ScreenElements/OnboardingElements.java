package ScreenElements;

import General.TestBase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnboardingElements extends TestBase {
    public OnboardingElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="ua.com.abank:id/etPhoneNumber")
    public MobileElement phoneNumberField;


//    @AndroidFindBy(id="ua.com.abank:id/btn2")
    @iOSXCUITFindBy(accessibility = "ic chat new")
    public MobileElement TwoPinButton;

    @AndroidFindBy(id="ua.com.abank:id/btn5")
    public MobileElement FivePinButton;

    @AndroidFindBy(id="ua.com.abank:id/btn8")
    public MobileElement EightPinButton;

    @AndroidFindBy(id="ua.com.abank:id/btn0")
    public MobileElement ZeroPinButton;

    @AndroidFindBy(id="ua.com.abank:id/editOtp1")
    public MobileElement FirstOtpNumber;

    @AndroidFindBy(id="ua.com.abank:id/editOtp2")
    public MobileElement SecondOtpNumber;

    @AndroidFindBy(id="ua.com.abank:id/editOtp3")
    public MobileElement ThirdOtpNumber;

    @AndroidFindBy(id="ua.com.abank:id/editOtp4")
    public MobileElement FourthOtpNumber;

    @AndroidFindBy(id="ua.com.abank:id/btnNext")
    public MobileElement NextButtonAfterOtp;

}
