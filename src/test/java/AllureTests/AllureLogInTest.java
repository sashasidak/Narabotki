package AllureTests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;
import General.TestBase;
public class AllureLogInTest extends TestBase {

    @Test(description="Check the possibility open card reissue")
    public void checkLoginTest() throws MalformedURLException, InterruptedException {
        firstAuth();
        // chooseAnotherLanguage();
    }
    //Тут можно писать остальные тесты
}