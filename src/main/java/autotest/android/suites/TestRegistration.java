package autotest.android.suites;

import core.appium.AppiumExtDriver;
import org.testng.annotations.AfterMethod;



/**
 * Created by zaborovsky on 21.12.2016.
 */
public class TestRegistration /*BaseTestCase*/{

    @AfterMethod
    public void tearDown() throws Exception {
        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());
        //AppiumExtDriver.getCurrentDriver().closeApp();
    }
}
