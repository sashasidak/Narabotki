package ScreenElements;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReissueVirtualCardModule {
    public ReissueVirtualCardModule(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="ua.com.abank:id/tvLabel")
    public MobileElement TitleUp;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    public MobileElement ChooseVirtualCardButton;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    public MobileElement ChoosePhisicalCardButton;

    @AndroidFindBy(id="ua.com.abank:id/nex_btn1")
    public MobileElement NextButton;

    @AndroidFindBy(id="ua.com.abank:id/textView126")
    public MobileElement FirstLineOfText;

    @AndroidFindBy(id="ua.com.abank:id/textView127")
    public MobileElement SecondLineofText;

    @AndroidFindBy(id="ua.com.abank:id/textView1261")
    public MobileElement ThirdLineofText;

    @AndroidFindBy(id="ua.com.abank:id/ivBack")
    public MobileElement BackButton;

    @AndroidFindBy(id="ua.com.abank:id/textView128")
    public MobileElement FourthLineifText;

    @AndroidFindBy(id="ua.com.abank:id/textView127")
    public MobileElement FifthLineofText;

    @AndroidFindBy(id="ua.com.abank:id/textInfo3")
    public MobileElement SixthLineofText;

    @AndroidFindBy(id="ua.com.abank:id/textInfo4")
    public MobileElement SeventhLineofText;

    @AndroidFindBy(id="ua.com.abank:id/nex_btn")
    public MobileElement ReissueCardButtonFinal;

    @AndroidFindBy(id="ua.com.abank:id/textView132")
    public MobileElement PinTitle;

    @AndroidFindBy(id="ua.com.abank:id/editOtp1")
    public MobileElement FirstNumberPin;

    @AndroidFindBy(id="ua.com.abank:id/editOtp2")
    public MobileElement SecondNumberPin;

    @AndroidFindBy(id="ua.com.abank:id/editOtp3")
    public MobileElement ThirdNumberPin;

    @AndroidFindBy(id="ua.com.abank:id/editOtp4")
    public MobileElement FourthNumberPin;

    @AndroidFindBy(id="ua.com.abank:id/save_pin_btn")
    public MobileElement SavePinButton;

    @AndroidFindBy(id="ua.com.abank:id/tvTitle")
    public MobileElement ErrorTitle;

    @AndroidFindBy(id="ua.com.abank:id/ivClose")
    public MobileElement CloseErrorTitle;

    @AndroidFindBy(id="ua.com.abank:id/textView130")
    public MobileElement TitleTextOnChangeDesign;

    @AndroidFindBy(id="ua.com.abank:id/textView131")
    public MobileElement MakeYourCardUniqueText;

    @AndroidFindBy(id="ua.com.abank:id/textView133")
    public MobileElement ChooseDesignText;

    @AndroidFindBy(id="ua.com.abank:id/go_to_scins_btn")
    public MobileElement ChooseADesignButton;

    @AndroidFindBy(id="ua.com.abank:id/later_btn_get")
    public MobileElement ChooseDesignLaterButton;

    @AndroidFindBy(id="ua.com.abank:id/tvCardSettingsTitle")
    public MobileElement CardDesignTitle;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]")
    public MobileElement IndependentText;

    @AndroidFindBy(id="ua.com.abank:id/ivBack")
    public MobileElement BackButtonDidgitalScreen;
}
