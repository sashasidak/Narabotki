package DepositsScreenElements;

import General.TestBase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static General.TestBase.Direction.UP;

public class DepositsPage extends TestBase {

    public DepositsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath="//*[contains(@text, 'Відкрити депозит')]")
    public MobileElement OpenDepositButton;
    @AndroidFindBy(xpath="//*[contains(@text, 'Максимальна вигода')]")
    public MobileElement OpenDepositSubtitle;
    @AndroidFindBy(xpath="//*[contains(@text, 'Підключити накопичення')]")
    public MobileElement KopilkaButton;
    @AndroidFindBy(xpath="//*[contains(@text, 'Безподатковий вклад')]")
    public MobileElement TaxFreeDepositButton;
    @AndroidFindBy(xpath="//*[contains(@text, 'Для отримувачів пенсій, зарплат, соц. виплат.')]")
    public MobileElement TaxFreeDepositSubtitle;
    @AndroidFindBy(xpath="//*[contains(@text, 'Купити валюту на вклад')]")
    public MobileElement BuyCurrencyButton;
    @AndroidFindBy(id="ua.com.abank:id/etAmount")
    public MobileElement AddDepositSummField;

    @AndroidFindBy(id="ua.com.abank:id/tvCurrency")
    public MobileElement ChooseCurrencySwitchButton;

    @AndroidFindBy(id="ua.com.abank:id/tvRate")
    public MobileElement PercentOfTheDeposit;

    @AndroidFindBy(id="ua.com.abank:id/sbPeriod")
    public MobileElement ChangeMonthDepositElement;

    @AndroidFindBy(id="ua.com.abank:id/ivAdditional")
    public MobileElement InfoButton;

    @AndroidFindBy(id="ua.com.abank:id/tvCapitalization")
    public MobileElement AddToDepositText;

    @AndroidFindBy(id="ua.com.abank:id/swCapitalization")
    public MobileElement CapitalizationSwitch;

    @AndroidFindBy(id="ua.com.abank:id/tvTermination")
    public MobileElement DostrokoveRozirvannyaText;

    @AndroidFindBy(id="ua.com.abank:id/swTermination")
    public MobileElement TerminationSwitch;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id='ua.com.abank:id/tvLabel'][@text='Депозити']")
    public MobileElement depositLabel;
    @AndroidFindBy(id="ua.com.abank:id/ivEnd")
    public MobileElement archiveButton;
    @AndroidFindBy(id="ua.com.abank:id/icon")
    public MobileElement icon;
    @AndroidFindBy(id="ua.com.abank:id/ivImage")
    public MobileElement advertisingImage;
    @AndroidFindBy(xpath="//android.view.ViewGroup")
    public MobileElement advertisingView;
    @AndroidFindBy(xpath="//android.widget.LinearLayout[1]")
    public MobileElement advertisingPin1;
    @AndroidFindBy(xpath="//android.widget.LinearLayout[2]")
    public MobileElement advertisingPin2;
    @AndroidFindBy(xpath="//android.widget.LinearLayout[3]")
    public MobileElement advertisingPin3;
    @AndroidFindBy(xpath="//*[contains(@text, 'Хапай депозит Online! Ставка більша, ніж у відділенні')]")
    public MobileElement firstAdvertisingText;
    @AndroidFindBy(xpath="//*[contains(@text, 'Безподатковий вклад вигідніший на 19.5%, тому що відсотки НЕ оподатковуються')]")
    public MobileElement secondAdvertisingText;
    @AndroidFindBy(xpath="//*[contains(@text, 'Дрібні гроші, що залишились на картці після покупок, відправляються в \"СкарбничкУ\"')]")
    public MobileElement thirdAdvertisingText;
    @AndroidFindBy(xpath="//*[contains(@text, 'Про розділ')]")
    public MobileElement infoLabel;
    @AndroidFindBy(xpath="//*[contains(@text, 'Це розділ програми, в якому ви можете')]")
    public MobileElement infoLabelSubtitle;
    @AndroidFindBy(xpath="//android.widget.ScrollView")
    public MobileElement advertisingInfo;
    @AndroidFindBy(xpath="//*[contains(@text, 'У додатку ABank24 ви можете оформити вклади у трьох валютах: гривня, долар США та євро.')]")
    public MobileElement subtitleDeposits;
    @AndroidFindBy(xpath="//*[contains(@text, 'Відсоткові ставки')]")
    public MobileElement interestRatesLink;
    @Step("Переход в депозиты")
    public void clickOnOpenDeposit()  {
        OpenDepositButton.click();
    }
    @Step("Переход в инфо")
    public void clickOnInfo()  {
        InfoButton.click();
        infoLabel.isDisplayed();
    }
    @Step("Проверка что открыта страница депозитов")
    public void checkDepositPageIsOpen() {
        depositLabel.isDisplayed();
    }
    @Step("Проверка элементов на стартовом экране")
    public void checkElementsOnMainScreenDeposits() throws InterruptedException {
        OpenDepositButton.isDisplayed();
        OpenDepositSubtitle.isDisplayed();
        KopilkaButton.isDisplayed();
        InfoButton.isDisplayed();
        archiveButton.isDisplayed();
        TaxFreeDepositButton.isDisplayed();
        TaxFreeDepositSubtitle.isDisplayed();
        BuyCurrencyButton.isDisplayed();
        icon.isDisplayed();
        advertisingView.isDisplayed();
        advertisingImage.isDisplayed();
        swipeScreen(UP);
        advertisingPin1.isDisplayed();
        firstAdvertisingText.isDisplayed();
        WebDriverWait wait = new WebDriverWait ( driver, 5 );
        wait.until ( ExpectedConditions.elementToBeClickable( advertisingPin2 ) );
        advertisingPin2.isDisplayed();
        advertisingPin2.click();
        secondAdvertisingText.isDisplayed();
        advertisingPin3.isDisplayed();
        advertisingPin3.click();
        thirdAdvertisingText.isDisplayed();
    }

    @Step("Проверка элементов на экране инфо")
    public void checkInfoElements() {
        WebDriverWait wait = new WebDriverWait ( driver, 10 );
        wait.until ( ExpectedConditions.visibilityOfAllElements( advertisingInfo ) );
        infoLabelSubtitle.isDisplayed();
        scrollToText( "Депозити");
        subtitleDeposits.isDisplayed();
        interestRatesLink.isDisplayed();
        scrollToText("Можливості депозитів");
        scrollToText("Розірвання вкладів");
        scrollToText("Ми дякуємо нашим клієнтам");
        scrollToText("Що таке Скарбничка?");
        scrollToText("Захищені Фондом Гарантування Вкладів");
    }

}
