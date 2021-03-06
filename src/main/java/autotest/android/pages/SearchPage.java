package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 12.01.2017.
 */
public class SearchPage extends MobileBasePage {

    private static final By OPEN_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_menu']", true);
    private static final By SEARCH_BAR = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_search']", true);
    private static final String OPEN_EVENT = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.widget.LinearLayout[@index='%d']";



    public SearchPage() {
        super(MobilePlatform.ANDROID);
    }

    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MENU.toString()));
        getSearchContext().findElement(OPEN_MENU).click();
        return mobilePageFactory.createPage(MainMenuList.class);
    }

    public SearchPage search(String searchQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SEARCH_BAR.toString()));
        getSearchContext().findElement(SEARCH_BAR).sendKeys(searchQuery + "\\n");
        return this;
    }

    public EventPage selectEvent(int number) {
        By locator = new ByLocator(String.format(OPEN_EVENT, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем событие под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return mobilePageFactory.createPage(EventPage.class);
    }


}
