package AllureTests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import General.TestBase;
import io.qameta.allure.Step;

public class AllureReissueCardTest extends TestBase {

    @Test(description="Check the possibility to reissue the card (virtual)")
    public void checkcardReissue() throws InterruptedException, MalformedURLException {
        reAuth();
        String oldCardNumber=openCardSettingsPage();
        firstScreenTest();
        secondScreenTest();
        addPinScreen();
        changeDesignScreen();
        didgitalScreenOpen();
        logOutAndLogIn();
        String newCardNumber = cardIsReopened();
        cardNumberReissueCheck(oldCardNumber,newCardNumber);
    }


    @Step
    public boolean isOtp()
    {
        try {
            onboardingElements.FirstOtpNumber.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("open card settings page")
    public String openCardSettingsPage() throws InterruptedException {
        Thread.sleep(6000);
        mainScreenElements.CardSettingButton.click();
        Thread.sleep(3000);

        String oldcardNumber=mainScreenElements.CardNumberField.getText();

        return oldcardNumber;
    }

    @Step("Check first screen")
    public void firstScreenTest() {
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Reissue of the card\").instance(0))";
//        driver.findElementByAndroidUIAutomator(scrollElement);
        cardSettingsPage.ReissueCardButton.click();

        String titleText=reissueVirtualCardModule.TitleUp.getText();
        Assert.assertEquals(titleText, "Reissue of the card");

        String expPhisicalText=reissueVirtualCardModule.ChoosePhisicalCardButton.getText();
        Assert.assertEquals(expPhisicalText, "Physical");

        String expVirtualcardText=reissueVirtualCardModule.ChooseVirtualCardButton.getText();
        Assert.assertEquals(expVirtualcardText, "Virtual");

        String exp1Line=reissueVirtualCardModule.FirstLineOfText.getText();
        Assert.assertEquals(exp1Line, "Your current card will be closed");

        String exp2Line=reissueVirtualCardModule.SecondLineofText.getText();
        Assert.assertEquals(exp2Line, "The card will be available immediately and has the same advantages as physical");

        String exp3Line=reissueVirtualCardModule.ThirdLineofText.getText();
        Assert.assertEquals(exp3Line, "You can reissue cards no more than once a week");
		/*
		String expTextOnButton=reissueVirtualCardModule.ChooseVirtualCardButton.getText();
		Assert.assertEquals(expTextOnButton, "Next");
		*/

        reissueVirtualCardModule.ChooseVirtualCardButton.click();
        reissueVirtualCardModule.NextButton.click();
    }

    @Step("Check the second screen")
    public void secondScreenTest() {
        String exp4Line=reissueVirtualCardModule.FourthLineifText.getText();
        Assert.assertEquals(exp4Line, "Instant release without plastic");

        String exp5Line=reissueVirtualCardModule.FifthLineofText.getText();
        Assert.assertEquals(exp5Line, "Use the credit limit, give gifts and make your wishes come true");

        String exp6Line=reissueVirtualCardModule.SixthLineofText.getText();
        Assert.assertEquals(exp6Line, "Get up to 20% cashback from each purchase and decide for yourself where to spend it");

        String exp7Line=reissueVirtualCardModule.SeventhLineofText.getText();
        Assert.assertEquals(exp7Line, "Bring your friends and get 50 UAH for each friend who becomes a client of the bank");

        String expButtontext=reissueVirtualCardModule.ReissueCardButtonFinal.getText();
        Assert.assertEquals(expButtontext, "Reissue card");

        reissueVirtualCardModule.ReissueCardButtonFinal.click();
    }

    @Step("Check add pin screen")
    public void addPinScreen() {
        reissueVirtualCardModule.FirstNumberPin.sendKeys("2");
        reissueVirtualCardModule.SecondNumberPin.sendKeys("5");
        reissueVirtualCardModule.ThirdNumberPin.sendKeys("8");
        reissueVirtualCardModule.SavePinButton.click();

        String expErrorTitle=reissueVirtualCardModule.ErrorTitle.getText();
        Assert.assertEquals(expErrorTitle, "Error");

        reissueVirtualCardModule.CloseErrorTitle.click();
        reissueVirtualCardModule.FourthNumberPin.sendKeys("0");
        reissueVirtualCardModule.SavePinButton.click();
    }
    @Step("Check the change design screen")
    public void changeDesignScreen() {
        String expDesignScreenTitle=reissueVirtualCardModule.TitleTextOnChangeDesign.getText();
        Assert.assertEquals(expDesignScreenTitle, "The virtual card has been reissued");

        String expTextMakeYourCard=reissueVirtualCardModule.MakeYourCardUniqueText.getText();
        Assert.assertEquals(expTextMakeYourCard, "Make your card unique");

        String expChooseBrightText=reissueVirtualCardModule.ChooseDesignText.getText();
        Assert.assertEquals(expChooseBrightText, "Choose a bright and unique design from our gallery");


        String expTextOnButtonChooseDesign=reissueVirtualCardModule.ChooseADesignButton.getText();
        Assert.assertEquals(expTextOnButtonChooseDesign, "Choose a design");

        String expTextChooseDesignLater=reissueVirtualCardModule.ChooseDesignLaterButton.getText();
        Assert.assertEquals(expTextChooseDesignLater, "Choose later");

        reissueVirtualCardModule.ChooseADesignButton.click();

    }

    @Step("Check the opening of digital screen page")
    public void didgitalScreenOpen() {

        String expTitledidgitalScreen=reissueVirtualCardModule.CardDesignTitle.getText();
        Assert.assertEquals(expTitledidgitalScreen, "Card design");

        String expVisivankaText=reissueVirtualCardModule.IndependentText.getText();
        Assert.assertEquals(expVisivankaText, "Free and independent (up to 30 May 2024)");

        reissueVirtualCardModule.BackButtonDidgitalScreen.click();
    }

    @Step("Check that card id reopened")
    public String cardIsReopened() {
        mainScreenElements.CardSettingButton.click();
        String newCardNumber=mainScreenElements.CardNumberField.getText();
        return newCardNumber;
    }

    @Step("Chek CardNumber Reissue")
    public void cardNumberReissueCheck(String oldcardNumber, String newCardNumber) {

        Assert.assertNotSame(oldcardNumber, newCardNumber);
    }

    @Step("Log out and log in")
    public void logOutAndLogIn() {
        mainScreenElements.AvatarSettingsButton.click();
        profileSettingsPage.ExitButton.click();
        profileSettingsPage.YesLogOutButton.click();
        driver.launchApp();


        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ua.com.abank:id/etPhoneNumber")));
        onboardingElements.phoneNumberField.sendKeys("638389626");

        // enter OTP if needed
        if (isOtp ()) {
            wait.until(ExpectedConditions.elementToBeClickable(onboardingElements.FirstOtpNumber));
            onboardingElements.FirstOtpNumber.sendKeys("7");
            onboardingElements.SecondOtpNumber.sendKeys("1");
            onboardingElements.ThirdOtpNumber.sendKeys("7");
            onboardingElements.FourthOtpNumber.sendKeys("2");
            onboardingElements.NextButtonAfterOtp.click();
        }

        onboardingElements.TwoPinButton.click();
        onboardingElements.FivePinButton.click();
        onboardingElements.EightPinButton.click();
        onboardingElements.ZeroPinButton.click();
        onboardingElements.NextButtonAfterOtp.click();
    }





/*@BeforeTest
public boolean beforeTest() throws MalformedURLException {
	 driver = mycapabilities();
	 onboardingElements = new OnboardingElements(driver);
	 mainScreenElements = new MainScreenElements(driver);

	 cardSettingsPage = new CardSettingsPage(driver);
	 reissueVirtualCardModule = new ReissueVirtualCardModule(driver);
	 cardSwipe = new CardSwipe();
	 profileSettingsPage = new ProfileSettingsPage(driver);
	 WebDriverWait wait = new WebDriverWait(driver, 30);
	 wait.until(ExpectedConditions.elementToBeClickable(By.id("ua.com.abank:id/etPhoneNumber")));
	 onboardingElements.phoneNumberField.sendKeys("638389626");
	 wait.until(ExpectedConditions.elementToBeClickable(onboardingElements.TwoPinButton));



	onboardingElements.TwoPinButton.click();
	onboardingElements.FivePinButton.click();
	onboardingElements.EightPinButton.click();
	onboardingElements.ZeroPinButton.click();



	try

 	       {
 	           if(onboardingElements.FirstOtpNumber.isDisplayed());
 	           {
 	        onboardingElements.FirstOtpNumber.sendKeys("7");
 	        onboardingElements.SecondOtpNumber.sendKeys("1");
 	        onboardingElements.ThirdOtpNumber.sendKeys("7");
 	        onboardingElements.FourthOtpNumber.sendKeys("2");

 	          return true;
 	           }

 	}
	        catch(Exception e)
 	        {
	        return true;

 	        }




	}*/
}

