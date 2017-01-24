package autotest.android.pages;

import autotest.android.business_objects.UserData;
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
public class Registration extends MobileBasePage {
//    private static final By EMAIL = new ByLocator"//android.widget.EditText[@resource-id="+"com.mgrmobi.intouch:id/et_email";

    private static final By USERNAME = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_username']", true);
    private static final By EMAIL = new ByLocator("//android.widget.EditText[@resource-id=" +
        "'com.mgrmobi.intouch:id/et_email']", true);
    private static final By PASSWORD = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_password']", true);
    private static final By REGISTRATION_BUTTON = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_signup']", true);

    private static final By FIO = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_name']", true);
    private static final By ABOUT = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_about']", true);
    private static final By GENDER_MALE = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/radio_button_male']", true);
    private static final By GENDER_FEMALE = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/radio_button_female']", true);
    private static final By BIRTHDAY = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_birthdate']", true);
    private static final By INTERESTS = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/interests_autocomplete']", true);
    private static final By CITY = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_city']", true);
    private static final By LINK = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_link']", true);
    private static final By DONE_BUTTON = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_signup']", true);

    private static final By ACTION_BUTTON = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_action']", true);

    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view']", true);

    public Registration() {
        super(MobilePlatform.ANDROID);
    }

    public Registration typeUsername(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим Username в элемент c xpath: '%s'", USERNAME.toString()));
        getSearchContext().findElement(USERNAME).sendKeys(email);
        return this;
    }

    public Registration typeEmail(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим email в элемент c xpath: '%s'", EMAIL.toString()));
        getSearchContext().findElement(EMAIL).sendKeys(email);
        return this;
    }

    public Registration typePassword(String password) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим пароль в элемент c xpath: '%s'", PASSWORD.toString()));
        getSearchContext().findElement(PASSWORD).sendKeys(password + "\\n");
        return this;
    }

    public Registration setUserData(UserData userData) {
        typeUsername(userData.getUsername());
        typeEmail(userData.getEmail());
        typePassword(userData.getPassword());
        return this;
    }

    public Registration registration() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране регистрации нажимаем на кнопку" +
                "Регистрации, элемент c xpath: '%s'", DONE_BUTTON.toString()));
        getSearchContext().findElement(DONE_BUTTON).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(Registration.class);
    }

    public Registration doneButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране регистрации нажимаем на кнопку" +
                "Регистрации, элемент c xpath: '%s'", DONE_BUTTON.toString()));
        getSearchContext().findElement(DONE_BUTTON).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(Registration.class);
    }

    public ShowappPage finishRegistration() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Войти, элемент c xpath: '%s'", ACTION_BUTTON.toString()));
        getSearchContext().findElement(ACTION_BUTTON).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после окончания регистрации не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ShowappPage.class);
    }
}
