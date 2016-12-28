package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 21.12.2016.
 */
public class Registration extends MobileBasePage {
    private static final By EMAIL = new ByLocator"//android.widget.EditText[@resource-id="+"com.mgrmobi.intouch:id/et_email";
    public Registration() {
        super(MobilePlatform.ANDROID);
    }
}
