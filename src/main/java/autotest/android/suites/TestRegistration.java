package autotest.android.suites;

import autotest.android.pages.IntroPage;
import autotest.android.pages.LogIn;
import core.appium.driver.AppiumExtDriver;
import core.logger.LevelLogger;
import core.test_case.BaseTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


/**
 * Created by zaborovsky on 21.12.2016.
 */
public class TestRegistration extends BaseTestCase{

    @Test(invocationCount = 1)
    public void test() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        default prj
        IntroPage myIntroLogin = mobilePageFactory.createPage(IntroPage.class);
//        Registration login = myIntroLogin.openRegistrationPage();
        LogIn login = myIntroLogin.openLoginPage();

//        Выполнение входа в приложение

        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());
        //AppiumExtDriver.getCurrentDriver().closeApp();
    }
}
