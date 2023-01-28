package General;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import DepositsScreenElements.DepositsPage;
import ScreenElements.*;
import UserSettingsElements.UserSettingsPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import utils.VRTHelper;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;


public class TestBase {

    public static IOSDriver driver;
    public OnboardingElements onboardingElements;
    public MainScreenElements mainScreenElements;
    public DepositsPage depositsPage;
    public UserSettingsPage userSettingsPage;
    public Actions actions;
    public VRTHelper vrtHelper;
    public ProfileSettingsPage profileSettingsPage;
    public CardSwipe cardSwipe;
    public CardSettingsPage cardSettingsPage;
    public ReissueVirtualCardModule reissueVirtualCardModule;


    public static IOSDriver mycapabilities() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(DEVICE_NAME, "iPhone Xr");
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability(PLATFORM_VERSION, "16");
        cap.setCapability(PLATFORM_NAME, "iOS");
        cap.setCapability(UDID, "*****");
        cap.setCapability("autoAcceptAlerts", true);
        cap.setCapability("bundleId", "******");
        cap.setCapability("newCommandTimeout", 10000);
        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;

    }

    public void reAuth() throws MalformedURLException {
        driver = mycapabilities();
        //Сюда добавляем вызов экранов (когда создали новый класс)
        onboardingElements = new OnboardingElements(driver);
        mainScreenElements = new MainScreenElements(driver);
        depositsPage = new DepositsPage(driver);
        cardSettingsPage = new CardSettingsPage(driver);
        userSettingsPage = new UserSettingsPage(driver);
        reissueVirtualCardModule = new ReissueVirtualCardModule(driver);
        cardSwipe = new CardSwipe();
        profileSettingsPage = new ProfileSettingsPage(driver);
        actions = new Actions(driver);
        vrtHelper = new VRTHelper();

        onboardingElements.TwoPinButton.isDisplayed();
        onboardingElements.TwoPinButton.click();
        onboardingElements.FivePinButton.click();
        onboardingElements.EightPinButton.click();
        onboardingElements.ZeroPinButton.click();
        mainScreenElements.walletNavBar.isDisplayed();
    }

    public void firstAuth() throws MalformedURLException, InterruptedException {
        driver = mycapabilities();
        onboardingElements = new OnboardingElements(driver);
        mainScreenElements = new MainScreenElements(driver);

        WebDriverWait wait = new WebDriverWait(driver, 45);
        onboardingElements.titleEnterPhone.isDisplayed();
        onboardingElements.phoneNumberField.clear();
        onboardingElements.phoneNumberField.sendKeys ( "507061794" );
        onboardingElements.nextButtonOnTheKeyboard.isDisplayed();
        onboardingElements.nextButtonOnTheKeyboard.click();
        onboardingElements.TwoPinButton.isDisplayed();
        onboardingElements.TwoPinButton.click();
        onboardingElements.FivePinButton.click();
        onboardingElements.EightPinButton.click();
        onboardingElements.ZeroPinButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(onboardingElements.FirstOtpNumber));
        onboardingElements.FirstOtpNumber.click();
        onboardingElements.SecondOtpNumber.click();
        onboardingElements.ThirdOtpNumber.click();
        onboardingElements.FourthOtpNumber.click();
        mainScreenElements.walletNavBar.isDisplayed();
    }

    @Step
    public boolean isOtp() {
        try {
            onboardingElements.FirstOtpNumber.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void scrollToText( String someText) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\""+someText+"\"))"));
    }

    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions
        final int ANIMATION_TIME = 200;
        final int PRESS_TIME = 200;
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = driver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        switch (dir) {
            case DOWN:
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP:
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT:
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT:
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return getDriver();
    }

}