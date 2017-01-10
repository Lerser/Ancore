package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.condition.SearchContextConditions;
import core.condition.Waiter;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 21.12.2016.
 */
public class LogIn extends MobileBasePage {

    private static final By EMAIL = new ByLocator("//android.widget.RelativeLayout[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_email'", true);
    private static final By PASSWORD = new ByLocator("//android.widget.RelativeLayout[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_password'", true);
    private static final By LOGIN = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_login'", true);

    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view'", true);




    public LogIn() {
        super(MobilePlatform.ANDROID);
    }

    public LogIn typeEmail(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим email в элемент c xpath: '%s'", EMAIL.toString()));
        getSearchContext().findElement(EMAIL).sendKeys(email);
        return this;
    }

    public LogIn typePassword(String password) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим пароль в элемент c xpath: '%s'", PASSWORD.toString()));
        getSearchContext().findElement(PASSWORD).sendKeys(password);
        return this;
    }

    public ShowappPage login() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем страницу авторизации, нажимаем на " +
                "Войти, элемент c xpath: '%s'", LOGIN.toString()));
        getSearchContext().findElement(LOGIN).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ShowappPage.class);
    }
//TODO Add login by Social Networks

}
