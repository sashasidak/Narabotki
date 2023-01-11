package AllureTests;

import General.TestBase;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class DepositTest extends TestBase {

    @Test(description="Проверка элементов на главном экране депозитов")
    public void checkDepositMainScreenElements() throws MalformedURLException, InterruptedException {
        reAuth();
        mainScreenElements.goToDeposits();
        depositsPage.checkDepositPageIsOpen();
        depositsPage.checkElementsOnMainScreenDeposits();
    }
    @Test(description="Проверка элементов на экране Инфо")
    public void checkDepositInfoScreenElements() throws MalformedURLException {
        reAuth();
        mainScreenElements.goToDeposits();
        depositsPage.checkDepositPageIsOpen();
        depositsPage.clickOnInfo();
        depositsPage.checkInfoElements();
    }
}

