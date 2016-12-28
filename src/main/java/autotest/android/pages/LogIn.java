package autotest.android.pages;

import autotest.android.pages.page_enum.MainMenu;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 21.12.2016.
 */
public class LogIn extends MobileBasePage {

    private static final By MAIN_LOGIN = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_login']", true);

    public LogIn() {
        super(MobilePlatform.ANDROID);
    }


    public <T extends MobileBasePage> T selectMainMenu(MainMenu mainMenu) {
        By locator = new ByLocator(String.format(MAIN_LOGIN, mainMenu.getRusName()), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем пункт меню '%s', нажимаем на " +
                "элемент c xpath: '%s'", mainMenu.getRusName(), locator.toString()));
        getSearchContext().findElement(locator).click();
        Class cl = null;
        try {
            cl = Class.forName(mainMenu.getPageNameClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)mobilePageFactory.createPage(cl);

    }

}
