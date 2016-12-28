package autotest.android.pages;

import autotest.android.pages.page_enum.MainMenu;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 27.12.2016.
 */
public class MainMenuTab extends MobileBasePage {
    private static final String ITEM_MENU_XPATH_PATTERN = "//android.widget.RelativeLayout[@resource-id=" +
            "'com.mgrmobi.intouch:id/bottom_menu' and @text='%s']/parent::*/parent::*";
    public  MainMenuTab() {
        super(MobilePlatform.ANDROID);
    }

    public <T extends MobileBasePage> T selectMainMenu(MainMenu mainMenu) {
        By locator = new ByLocator(String.format(ITEM_MENU_XPATH_PATTERN, mainMenu.getRusName()), true);
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
