package AllureTests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;
import General.TestBase;
public class AllureLogInTest extends TestBase {

    @Test(description="Авторизация с ОТП")
    public void checkLoginTest() throws MalformedURLException, InterruptedException {
        firstAuth();
        // chooseAnotherLanguage();
    }

    @Test(description="Восстановление сессии")
    public void reAuth() throws MalformedURLException {
        reAuth();
    }
    //Тут можно писать остальные тесты
}