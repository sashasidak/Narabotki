package ScreenElements;

import org.openqa.selenium.support.PageFactory;

import General.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class CardSwipe extends TestBase {











    public void swipe(AndroidDriver driver) {
        TouchAction swipe = new TouchAction(driver)
                .press(PointOption.point(1267,696))
                .moveTo(PointOption.point(179,750))
                .release()
                .perform();
    }

    public void scroll(AndroidDriver driver) {
        TouchAction scroll = new TouchAction(driver)
                .press(PointOption.point(684,2463))
                .moveTo(PointOption.point(714,244))
                .release()
                .perform();
    }
	/*
	public void scroll2(AndroidDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(684,2463))
                   .waitAction(waitOptions(ofSeconds(2)))
                   .release()
                   .perform();

        touchAction.press(714,244))
        .waitAction(waitOptions(ofSeconds(2)))
        .release()
        .perform();
	}

	*/



}


