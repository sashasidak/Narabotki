package ScreenElements;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfileSettingsPage {
    public ProfileSettingsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="ua.com.abank:id/changeLanguage")
    public MobileElement ChangeLanguageButton;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]")
    public MobileElement UkrainianLanguageButton;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]")
    public MobileElement EnglishLanguageButton;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]")
    public MobileElement RussiaLanguageButton;

    @AndroidFindBy(id="ua.com.abank:id/tvSave")
    public MobileElement SaveChangeLanguageButton;

    @AndroidFindBy(id="ua.com.abank:id/exit")
    public MobileElement ExitButton;

    @AndroidFindBy(id="android:id/button2")
    public MobileElement YesLogOutButton;
}
