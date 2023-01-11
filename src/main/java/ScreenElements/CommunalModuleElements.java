package ScreenElements;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommunalModuleElements {
    public CommunalModuleElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="ua.com.abank:id/tvAddAddress")
    public MobileElement AddAddressButton;

    @AndroidFindBy(id="ua.com.abank:id/tietCity")
    public MobileElement AddTownFiled;

    @AndroidFindBy(id="ua.com.abank:id/tietStreet")
    public MobileElement AddStreetField;

    @AndroidFindBy(id="ua.com.abank:id/tietHouse")
    public MobileElement AddHomeNumberField;

    @AndroidFindBy(id="ua.com.abank:id/tietFlat")
    public MobileElement AddFlatNumberField;

    @AndroidFindBy(id="ua.com.abank:id/tietBox")
    public MobileElement AddHousingNumberField;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.TextView")
    public MobileElement ChooseDneprTown;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout[3]")
    public MobileElement ChooseGogolyaStreet;

    @AndroidFindBy(id="ua.com.abank:id/nextButton")
    public MobileElement AddButton;

    @AndroidFindBy(xpath="//*[@text='м. Дніпро, пров. Миколи Гоголя, буд. 15']")
    public MobileElement CheckAddedAddress;


}
