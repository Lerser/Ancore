package autotest.android.pages.page_enum;



/**
 * Created by zaborovsky on 27.12.2016.
 */
public enum MainMenu implements LangEnum {

    Live("LIVE", "LIVE",""),
    Search("Поиск","Search","SearchPage"),
    Available("Доступные","",""),
    Activities("Активности","",""),
    Create("Создать","",""),
    Profile("Профиль","Profile",""),
    Settings("Настройки", "Settings",""),
    Exit("Выход","Exit","");

    private MainMenu(String rusName, String engName, String pageName){
        this.rusName = rusName;
        this.engName = engName;
        this.pageName = pageName;
    }

    private String rusName;
    private String engName;
    private String pageName;

    @Override
    public String getRusText(){
        return this.rusName;
    }

    @Override
    public String getRuEnValue(){
        return this.engName;
    }

    public String getPageNameClass() {
        return "autotest.page." + pageName;
    }

}
